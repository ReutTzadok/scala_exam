package users.services.validation

import org.springframework.stereotype.Component

@Component
class ValidateEmailImpl extends ValidateEmail {
  override def validate(email: String): Boolean = {
    email.contains('@') && email.endsWith(".com")
  }
}
