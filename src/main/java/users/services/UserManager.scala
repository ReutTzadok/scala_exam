package users.services

import org.springframework.stereotype.Component
import users.model.{Client, Person, User}
import users.services.readFeomFiles.{ReadClientFromExcelImpl, ReadClientsFromExcel, ReadPersonsFromJson, ReadPersonsFromJsonImpl}
import users.services.validation.{UserValidator, UserValidatorImpl}

import scala.collection.mutable.ListBuffer
import users.services.adapters.Adapter._



@Component
class UserManager {
  //todo add annotations
  val readPersons : ReadPersonsFromJson = new ReadPersonsFromJsonImpl
  val readClients: ReadClientsFromExcel = new ReadClientFromExcelImpl
  val userValidator: UserValidator = new UserValidatorImpl
  val readDate:ReadData = new ReadData


  def flow() : Unit = {
    val users: List[User] = readDate.gatValidUsers

    println(s"user manager ${users.size}")


    //todo 4 create filtering classes and filter management

  }
}
