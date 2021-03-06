package by.sivko.pizzashop.loginservice.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailMatchesValidator.class)
@Documented
public @interface EmailMatches {
    String message() default "Emails don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
