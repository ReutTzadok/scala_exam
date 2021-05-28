package users.services

import users.model.{Client, Person, User}
import users.services.adapters.Adapter._
import users.services.readFeomFiles.{ReadClientFromExcelImpl, ReadClientsFromExcel, ReadPersonsFromJson, ReadPersonsFromJsonImpl}

import scala.collection.mutable.ListBuffer
import users.services.validation.{UserValidator, UserValidatorImpl}

class ReadData {

  val userValidator: UserValidator = new UserValidatorImpl
  val readPersons: ReadPersonsFromJson = new ReadPersonsFromJsonImpl
  val readClients: ReadClientsFromExcel = new ReadClientFromExcelImpl

  def gatValidUsers: List[User] = {
//    reas persons
//todo use application.properties
    //todo move to a class?
    val people: ListBuffer[Person] = readPersons.read("data/persons.json")//.toList
    val users: ListBuffer[User] = new ListBuffer[User]
    people.foreach(p => if (userValidator.validate(p)) users+=p)

    println(users.size)

//    read clients
    val clients: ListBuffer[Client] = readClients.read("blabla")
    clients.foreach(c => if (userValidator.validate(c)) users+=c)

    println(users.size)

    users.toList
  }
}
