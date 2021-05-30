package users.flow

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import users.model.User




@Component
class UserManager {
  @Autowired
  val readDate:ReadData = null

  @Autowired
  val requestsManagement: RequestsManagement = null


  def flow() : Unit = {
    val users: List[User] = readDate.gatValidUsers

    println(s"user manager ${users.size}")

    requestsManagement.manageRequests(users)

  }
}
