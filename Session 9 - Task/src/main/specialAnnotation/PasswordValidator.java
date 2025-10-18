package main.specialAnnotation;

import main.model.Employee;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ConfirmPassword, Employee> {

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        if (employee == null) {
            return true;
        }

        String password = employee.getPassword();
        String confirmPassword = employee.getConfirmPassword();


        if (password == null || confirmPassword == null) {
            return true;
        }

        boolean match = password.equals(confirmPassword);

        if (!match) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password do not match")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return match;
    }
}
