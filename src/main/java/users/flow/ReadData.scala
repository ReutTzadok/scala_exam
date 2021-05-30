package users.flow

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import users.model.{Client, Person, User}
import users.services.adapters.Adapter._
import users.services.readFeomFiles.{ReadClientFromExcel, ReadClients, ReadPersons, ReadPersonsFromJson}
import users.services.validation.{UserValidator, UserValidatorImpl}

import scala.collection.mutable.ListBuffer


@Component
//class ReadData(@Value("${person_file_path}") val personFilePath: String) {
class ReadData {
  @Autowired
  val userValidator: UserValidator = null

  @Autowired
  val readPersons: ReadPersons = null

  @Autowired
  val readClients: ReadClients = null

//  @PropertySource("classpath:application.properties")
//  @PropertySource(ignoreResourceNotFound = true, value = Array("classpath:application.yml"))
//  @Value("${person_file_path}")
  val personFilePath: String = "data/persons.json"
  val clientFilePath: String = "data/client.xls"



  def gatValidUsers: List[User] = {
//    read persons
//todo use application.properties
    //todo move to a class?
    println(personFilePath)
    val people: ListBuffer[Person] = readPersons.read(personFilePath)
    val users: ListBuffer[User] = new ListBuffer[User]
    people.foreach(p => if (userValidator.validate(p)) users+=p)

    println(users.size)

//    read clients
    val clients: ListBuffer[Client] = readClients.read(clientFilePath)
    clients.foreach(c => if (userValidator.validate(c)) users+=c)

    println(users.size)

    users.toList
  }
}
