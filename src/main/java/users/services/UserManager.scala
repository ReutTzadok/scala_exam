package users.services

import org.springframework.stereotype.Component
import users.model.{Client, Person, Request, User}
import users.services.readFeomFiles.{ReadClientFromExcelImpl, ReadClientsFromExcel, ReadPersonsFromJson, ReadPersonsFromJsonImpl}
import users.services.validation.{UserValidator, UserValidatorImpl}

import scala.collection.mutable.ListBuffer
import users.services.adapters.Adapter._
import users.services.filters.{FilterManagement, FilterManagementImpl}



@Component
class UserManager {
  //todo add annotations
//  val readPersons : ReadPersonsFromJson = new ReadPersonsFromJsonImpl
//  val readClients: ReadClientsFromExcel = new ReadClientFromExcelImpl
//  val userValidator: UserValidator = new UserValidatorImpl
  val readDate:ReadData = new ReadData
  val filterUsers: FilterManagement = new FilterManagementImpl


  def flow() : Unit = {
    val users: List[User] = readDate.gatValidUsers

    println(s"user manager ${users.size}")


    val request: Request = Request(minAge= 25, maxAge= 27, gender= "sdd", prefixName= "Reut", maritalStatus= "sdf", NumberOfChildren=1)

    val filteredUsers = filterUsers.filter(request, users)

    println(s"after filter there is ${filteredUsers.size} users")
  }
}
