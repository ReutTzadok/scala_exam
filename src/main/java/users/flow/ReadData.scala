package users.flow

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import users.model.{Client, Person, User}
import users.services.adapters.Adapter._
import users.services.properties.Properties
import users.services.readFeomFiles.{ReadClients, ReadPersons}
import users.services.validation.UserValidator

import scala.collection.mutable.ListBuffer


@Component
class ReadData {
  @Autowired
  val userValidator: UserValidator = null

  @Autowired
  val readPersons: ReadPersons = null

  @Autowired
  val readClients: ReadClients = null

  @Autowired
  val properties: Properties = null



  def gatValidUsers: List[User] = {
    val personFilePath: String = properties.getProperty(properties.PERSON_FILE_PATH)
    val clientFilePath: String = properties.getProperty(properties.CLIENT_FILE_PATH)

    val people: ListBuffer[Person] = readPersons.read(personFilePath)
    val clients: ListBuffer[Client] = readClients.read(clientFilePath)
    val users: ListBuffer[User] = new ListBuffer[User]

    //todo move to a new class?
    people.foreach(p => if (userValidator.validate(p)) users += p)
    clients.foreach(c => if (userValidator.validate(c)) users += c)

    println(s"There is ${users.size} valid users")

    users.toList
  }
}
