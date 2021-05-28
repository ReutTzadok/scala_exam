//package users.services.validation
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.core.io.Resource
//import org.springframework.stereotype.{Component, Service}
//import users.model.Person
//
//import scala.beans.BeanProperty
//
//@Service
//class PersonValidatorImpl extends PersonValidator {
//  //todo add annotations
////  @BeanProperty
////  @Autowired
////  var validateAge: ValidateAge = null
////
////  @BeanProperty
////  @Autowired(required = false)
////  val validateEmail: ValidateEmail = null
////
////  @BeanProperty
////  @Autowired(required = false)
////  val validatePhone: ValidatePhone = null
//
//  val validateAge: ValidateAge = new ValidateAgeImpl
//
//  val validateEmail: ValidateEmail = new ValidateEmailImpl
//
//  val validatePhone: ValidatePhone = new ValidatePhoneImpl
//
//  //todo more validations
//  //todo test validator
//  def validate(person : Person) : Boolean = {
//    val answer = person match {
//      case Person(age,_,_,_,_,_,_) if (!validateAge.validate(age)) => false
//      case Person(_,_,_,_,email,_,_) if (!validateEmail.validate(email)) => false
//      case Person(_,_,_,_,_,phone,_) if (!validatePhone.validate(phone)) => false
//      case _ => true
//    }
//
//    return answer
//  }
//
//}
//
