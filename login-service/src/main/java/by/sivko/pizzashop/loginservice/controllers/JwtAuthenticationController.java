package by.sivko.pizzashop.loginservice.controllers;

import by.sivko.pizzashop.loginservice.entitites.User;
import by.sivko.pizzashop.loginservice.models.JwtRequest;
import by.sivko.pizzashop.loginservice.models.JwtResponse;
import by.sivko.pizzashop.loginservice.models.UserDTO;
import by.sivko.pizzashop.loginservice.services.UserService;
import by.sivko.pizzashop.loginservice.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JwtAuthenticationController(JwtTokenUtil jwtTokenUtil, UserService userService, PasswordEncoder passwordEncoder) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody @Valid JwtRequest authenticationRequest) {
        final User user = this.userService.findUserByEmailAndCheckPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<String> createNewUser(@RequestBody @Valid UserDTO userDTO) {
        final User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        this.userService.createUserWithUserRole(user);

        return new ResponseEntity<>(user.getActivationCode(), HttpStatus.CREATED);
    }

    @GetMapping("/activation/{code}")
    public ResponseEntity<Void> activateUser(@PathVariable("code") String activationCode) {
        this.userService.activateUser(activationCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}