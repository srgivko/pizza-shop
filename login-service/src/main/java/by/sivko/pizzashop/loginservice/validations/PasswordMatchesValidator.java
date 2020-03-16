package by.sivko.pizzashop.loginservice.validations;

import by.sivko.pizzashop.loginservice.models.UserDTO;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDTO> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        return userDTO.getPassword().equals(userDTO.getMatchingPassword());
    }
}
