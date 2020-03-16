package by.sivko.pizzashop.loginservice.models;

import by.sivko.pizzashop.loginservice.validations.EmailMatches;
import by.sivko.pizzashop.loginservice.validations.PasswordMatches;
import by.sivko.pizzashop.loginservice.validations.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@PasswordMatches
@EmailMatches
public class UserDTO {

    @UniqueEmail
    @Email
    @NotBlank
    private final String email;
    private final String matchingEmail;

    @NotBlank
    private final String password;
    private final String matchingPassword;
}
