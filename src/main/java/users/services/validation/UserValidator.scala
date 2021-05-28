package users.services.validation

import users.model.{User}

trait UserValidator {
  def validate(user : User) : Boolean
}
