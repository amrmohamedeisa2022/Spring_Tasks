package main.specialAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPassword {

    String message() default "Password must match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
