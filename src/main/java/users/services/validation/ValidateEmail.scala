package users.services.validation

//todo could be better validation
trait ValidateEmail {
  def validate(email:String) : Boolean
}
