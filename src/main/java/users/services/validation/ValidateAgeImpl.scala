package users.services.validation

import org.springframework.stereotype.{Component, Service}

@Component
class ValidateAgeImpl extends ValidateAge {
  override def validate(age: Int): Boolean = {
    age > 0
  }
}
