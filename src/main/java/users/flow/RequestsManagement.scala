package users.flow

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Component
import users.model.{Request, User}
import users.services.filters.{RequestHandle, RequestHandleImpl}
import users.services.readFeomFiles.{ReadRequest, ReadRequestsFromJson}

@Component
class RequestsManagement {

  @Autowired
  val readRequest: ReadRequest = null

  @Autowired
  val requestHandle: RequestHandle = null

//  @Value("$results_path")
  val requestFilePath: String = "data/request.json"


  def manageRequests(users: List[User]): Unit = {
    //todo application.properties..
    val requests:List[Request]  = readRequest.read(requestFilePath)

    requests.foreach(request => requestHandle.filter(request, users))
  }

}
