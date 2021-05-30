package users.services.writeToFile
import org.springframework.stereotype.Component
import users.model.Request

import java.io.{File, FileWriter}
import java.time

@Component
class WriteRequestResultsImpl extends WriteRequestResults {

  //todo application.properties
  val resultsPath = "data/requests results/"


  override def write(results: String, request: Request): Unit = {
    val fileName: String = time.LocalDateTime.now().toString.replace("T","_").replace("-","").replace(":","")
    val filePath = resultsPath + fileName + ".txt"

    val result: String = request.toString+"\n"+results

    val file = new File(filePath)

    val writer = new FileWriter(file)
    writer.write(result)
    writer.flush()
    writer.close()
  }
}
