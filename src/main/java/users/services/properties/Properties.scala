package users.services.properties

import org.springframework.stereotype.Component

import scala.io.Source

//I know This isn't the best way to use application.properties, but @Value doesn't work
// and I don't have time to figure out what is the problem..



@Component
class Properties {
  val PERSON_FILE_PATH = "person_file_path"
  val CLIENT_FILE_PATH = "client_file_path"
  val REQUEST_FILE_PATH = "request_file_path"
  val RESULTS_PATH = "results_path"


  private val appProperties= Source.fromFile("src/main/resources/application.properties")
  private val properties = appProperties.getLines().map(_.split("=")).map(arr => Tuple2(_1 = arr(0), _2 = arr(1))).toArray.toMap


  def getProperty(property: String): String = properties(property)

}
