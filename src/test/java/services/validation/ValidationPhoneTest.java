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


//for validate email:

//    val t1:String = "reut.b1212@gmail.com"
//    val t2:String = "reut.b1212gmail.com"
//    val t3:String = "reut@gmail"
//    val t4:String = "reut.com@.com"
//    val t5:String = "reut@sd.comdf"

//    println(s"$t1 is ${ValidateEmail(t1)}")
//    println(s"$t2 is ${ValidateEmail(t2)}")
//    println(s"$t3 is ${ValidateEmail(t3)}")
//    println(s"$t4 is ${ValidateEmail(t4)}")
//    println(s"$t5 is ${ValidateEmail(t5)}")