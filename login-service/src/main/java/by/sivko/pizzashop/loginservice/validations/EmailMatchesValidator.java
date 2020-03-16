package by.sivko.pizzashop.loginservice.validations;

import by.sivko.pizzashop.loginservice.models.UserDTO;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailMatchesValidator implements ConstraintValidator<EmailMatches, UserDTO> {
    @Override
    public void initialize(EmailMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        return userDTO.getEmail().equals(userDTO.getMatchingEmail());
    }
}
