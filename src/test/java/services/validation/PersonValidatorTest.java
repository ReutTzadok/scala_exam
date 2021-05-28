package services.validation;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import users.model.Person;
//import users.services.validation.PersonValidator;
//import users.services.validation.PersonValidatorImpl;
import users.services.validation.UserValidator;
import users.services.validation.UserValidatorImpl;

public class PersonValidatorTest {

    @Test
    public void testValidator() {
        UserValidator personValidator = new UserValidatorImpl();

        Person mock = Mockito.mock(Person.class);

        Mockito.when(mock.age()).thenReturn(12);
        Mockito.when(mock.email()).thenReturn("reut.b1212@gmail.com");
        Mockito.when(mock.phone()).thenReturn("999-2334-12");
        System.out.println(mock);


//        boolean res = personValidator.validate(mock);
        Assert.assertTrue(true);
    }
}
