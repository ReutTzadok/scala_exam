package users.services

import org.springframework.stereotype.Component
import users.model.{Client, Person}
import users.services.readFeomFiles.{ReadPersonsFromJson, ReadPersonsFromJsonImpl}
import users.services.validation.{PersonValidator, PersonValidatorImpl}

import scala.collection.mutable.ListBuffer


@Component
class UserManager {
  //todo add annotations
  val readPresons : ReadPersonsFromJson = new ReadPersonsFromJsonImpl
  val personValidator: PersonValidator = new PersonValidatorImpl

  def flow() : Unit = {
    //todo use application.properties
    var people : ListBuffer[Person] = readPresons.read("data/persons.json")
    println(people.size)

    //todo 2 move to a class remover
    var notValidPeople: ListBuffer[Person] = new ListBuffer[Person]()
    people.foreach(person => if (!personValidator.validate(person)) notValidPeople.+=(person))
    notValidPeople.foreach(person => people.remove(people.indexOf(person)))


    //todo 1 the same as people
    var clients : ListBuffer[Client] = new ListBuffer[Client]()

    //todo 3 create one list (using implicit method)

    //todo 4 create filtering classes and filter management

//    val t1:String = "reut.b1212@gmail.com"
//    val t2:String = "reut.b1212gmail.com"
//    val t3:String = "reut@gmail"
//    val t4:String = "reut.com@.com"
//    val t5:String = "reut@sd.comdf"

//    println(s"$t1 is ${ValidateEmail(t1)}")
//    println(s"$t2 is ${ValidateEmail(t2)}")
//    println(s"$t3 is ${ValidateEmail(t3)}")
//    println(s"$t4 is ${ValidateEmail(t4)}")
//    println(s"$t5 is ${ValidateEmail(t5)}")
  }
}
