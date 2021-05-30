package users.flow

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Component
import users.model.{Request, User}
import users.services.filters.{RequestHandle, RequestHandleImpl}
import users.services.properties.Properties
import users.services.readFeomFiles.{ReadRequest, ReadRequestsFromJson}

@Component
class RequestsManagement {

  @Autowired
  val readRequest: ReadRequest = null

  @Autowired
  val requestHandle: RequestHandle = null

  @Autowired
  val properties: Properties = null




  def manageRequests(users: List[User]): Unit = {
    println("Start handle filter requests")
    val requestFilePath: String = properties.getProperty(properties.REQUEST_FILE_PATH)
    val requests:List[Request]  = readRequest.read(requestFilePath)
    requests.foreach(request => requestHandle.filter(request, users))

    println(s"All filter requests are done. you can see the results in ${properties.getProperty(properties.RESULTS_PATH)}")
  }

}
