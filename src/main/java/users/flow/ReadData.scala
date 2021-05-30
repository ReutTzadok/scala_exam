package users.flow

import users.model.{Client, Person, User}
import users.services.adapters.Adapter._
import users.services.readFeomFiles.{ReadClientFromExcel, ReadClients, ReadPersons, ReadPersonsFromJson}
import users.services.validation.{UserValidator, UserValidatorImpl}

import scala.collection.mutable.ListBuffer

class ReadData {

  val userValidator: UserValidator = new UserValidatorImpl
  val readPersons: ReadPersons = new ReadPersonsFromJson
  val readClients: ReadClients = new ReadClientFromExcel

  def gatValidUsers: List[User] = {
//    read persons
//todo use application.properties
    //todo move to a class?
    val people: ListBuffer[Person] = readPersons.read("data/persons.json")//.toList
    val users: ListBuffer[User] = new ListBuffer[User]
    people.foreach(p => if (userValidator.validate(p)) users+=p)

    println(users.size)

//    read clients
    val clients: ListBuffer[Client] = readClients.read("data/client.xls")
    clients.foreach(c => if (userValidator.validate(c)) users+=c)

    println(users.size)

    users.toList
  }
}
