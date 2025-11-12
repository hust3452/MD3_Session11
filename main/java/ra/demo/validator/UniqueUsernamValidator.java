package ra.demo.validator;

import ra.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernamValidator implements ConstraintValidator<UniqueUsername,String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username !=null && !userService.checkUsernameExisted(username);
    }
}
