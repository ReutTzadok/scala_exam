package users.services.readFeomFiles
import users.model.Request
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods.parse
import org.springframework.stereotype.Component

import scala.io.Source


@Component
class ReadRequestsFromJson extends ReadRequest {
  implicit val formats: DefaultFormats.type = DefaultFormats

  override def read(filePath: String): List[Request] = {

    val file = Source.fromFile(filePath)
    val jsonRequests = file.getLines.mkString
    file.close()

    val requests = parse(jsonRequests).extract[List[Request]]

    println(s"there is ${requests.size} requests")
    println(s"first request is: \n${requests.head}")

    requests
  }
}
