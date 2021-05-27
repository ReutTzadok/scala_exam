package users.services.validation

import users.model.Person
//todo should I get the validations? more SOLID

trait PersonValidator {
  def validate(person : Person) : Boolean
}
