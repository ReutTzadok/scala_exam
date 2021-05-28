package users.services.validation
import users.model.{User}

class UserValidatorImpl extends UserValidator {
  //todo add annotations
  //  @BeanProperty
  //  @Autowired
  //  var validateAge: ValidateAge = null
  //
  //  @BeanProperty
  //  @Autowired(required = false)
  //  val validateEmail: ValidateEmail = null
  //
  //  @BeanProperty
  //  @Autowired(required = false)
  //  val validatePhone: ValidatePhone = null

  val validateAge: ValidateAge = new ValidateAgeImpl

  val validateEmail: ValidateEmail = new ValidateEmailImpl

  val validatePhone: ValidatePhone = new ValidatePhoneImpl

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
