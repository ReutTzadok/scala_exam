package users.flow

import org.springframework.stereotype.Component
import users.model.{Request, User}
import users.services.filters.{RequestHandle, RequestHandleImpl}



@Component
class UserManager {
  //todo add annotations
  val readDate:ReadData = new ReadData
  val requestsManagement: RequestsManagement = new RequestsManagement


  def flow() : Unit = {
    val users: List[User] = readDate.gatValidUsers

    println(s"user manager ${users.size}")

    requestsManagement.manageRequests(users)

  }
}
