package services.validation;

import org.junit.Assert;
import org.junit.Test;
import users.services.validation.ValidatePhone;
import users.services.validation.ValidatePhoneImpl;

public class ValidationPhoneTest {

    @Test
    public void testValidatePhone() {
        ValidatePhone validatePhone = new ValidatePhoneImpl();
        String number = "999-2334-12";
        boolean current = validatePhone.validate(number);
        Assert.assertTrue(current);
    }
}
