package users.services.validation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import users.model.User


@Component
class UserValidatorImpl extends UserValidator {
    @Autowired
    var validateAge: ValidateAge = null

    @Autowired
    val validateEmail: ValidateEmail = null

    @Autowired
    val validatePhone: ValidatePhone = null



  //todo more validations
  //todo test validator
  def validate(user: User) : Boolean = {
    val answer = user match {
      case User(age, _, _, _, _, _, _) if (!validateAge.validate(age)) => false
      case User(_, _, _, email, _, _, _) if (!validateEmail.validate(email)) => false
      case User(_, _, _, _, phone, _, _) if (!validatePhone.validate(phone)) => false
      case _ => true
    }

    answer
  }
}
