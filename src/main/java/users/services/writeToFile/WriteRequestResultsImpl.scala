package users.services.writeToFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import users.model.Request
import users.services.properties.Properties

import java.io.{File, FileWriter}
import java.time

@Component
class WriteRequestResultsImpl extends WriteRequestResults {
  @Autowired
  val properties: Properties = null


  override def write(results: String, request: Request): Unit = {
    val resultsPath:String = properties.getProperty(properties.RESULTS_PATH)
    val fileName: String = time.LocalDateTime.now().toString
      .replace("T","_")
      .replace("-","")
      .replace(":","")
    val filePath = resultsPath + fileName + ".txt"

    val result: String = request.toString+"\n"+results

    val file = new File(filePath)
    val writer = new FileWriter(file)
    writer.write(result)
    writer.flush()
    writer.close()
  }
}
