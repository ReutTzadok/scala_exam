package users.services.validation

import org.springframework.stereotype.Component

@Component
class ValidatePhoneImpl extends ValidatePhone {
  override def validate(phone: String): Boolean = {
    phone.matches("^\\+\\d\\s\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}|(\\d{3}\\-\\d{4}\\-\\d{2})$")
  }
}
