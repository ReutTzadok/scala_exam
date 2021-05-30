package users.flow

import users.model.{Request, User}
import users.services.filters.{RequestHandle, RequestHandleImpl}
import users.services.readFeomFiles.{ReadRequest, ReadRequestsFromJson}


class RequestsManagement {
  val readRequest: ReadRequest = new ReadRequestsFromJson
  val requestHandle: RequestHandle = new RequestHandleImpl

  def manageRequests(users: List[User]): Unit = {
    //todo application.properties..
    val requests:List[Request]  = readRequest.read("data/request.json")

    requests.foreach(request => requestHandle.filter(request, users))
  }

}
