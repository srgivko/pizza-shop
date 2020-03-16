package by.sivko.pizzashop.loginservice.services;

import by.sivko.pizzashop.loginservice.entitites.Role;
import by.sivko.pizzashop.loginservice.entitites.User;
import by.sivko.pizzashop.loginservice.exceptions.BadCredentionalsException;
import by.sivko.pizzashop.loginservice.exceptions.NotActivatedException;
import by.sivko.pizzashop.loginservice.exceptions.NotFoundException;
import by.sivko.pizzashop.loginservice.repositories.RoleRepository;
import by.sivko.pizzashop.loginservice.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findUserByEmailAndCheckPassword(String email, String password) throws BadCredentionalsException, NotActivatedException {
        log.debug("Find user with email [{}] and password [{}]", email, password);
        final User user = this.userRepository.findByEmail(email).orElseThrow(BadCredentionalsException::new);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentionalsException();
        }
        if (user.getActivationCode() != null) {
            throw new NotActivatedException();
        }
        log.debug("User with email [{}] was found", user.getEmail());
        return user;
    }

    @Override
    public boolean isExists(String email) {
        return this.userRepository.findByEmail(email).isPresent();
    }

    @Transactional
    @Override
    public User createUserWithUserRole(User user) throws NotFoundException {
        log.debug("Creat new user with data [{}]", user);
        final Role userRole = this.roleRepository.findByName("ROLE_USER").orElseThrow(NotFoundException::new);
        HashSet<Role> hashSet = new HashSet<>();
        hashSet.add(userRole);
        user.setRoles(hashSet);
        user.setActivationCode(UUID.randomUUID().toString());
        this.userRepository.save(user);
        log.debug("User with email [{}] was created", user.getEmail());
        return user;
    }

    @Transactional
    @Override
    public User activateUser(String activationCode) throws NotFoundException {
        log.debug("Activate user with userCode [{}]", activationCode);
        final User user = this.userRepository.findByActivationCode(activationCode).orElseThrow(NotFoundException::new);
        user.setActivationCode(null);
        this.userRepository.save(user);
        log.debug("User with email [{}] was activated", activationCode);
        return user;
    }

}
