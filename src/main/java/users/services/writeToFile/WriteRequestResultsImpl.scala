package users.services.writeToFile
import users.model.{Request, User}

import java.io.{File, FileWriter}

import java.time

class WriteRequestResultsImpl extends WriteRequestResults {

  val path = "data/requests results/"
  override def write(results: String, request: Request): Unit = {
    val fileName: String = time.LocalDateTime.now().toString.replace("T","_").replace("-","").replace(":","")
    val filePath = path + fileName + ".txt"

    val result: String = request.toString+"\n"+results

    val file = new File(filePath)

    val writer = new FileWriter(file)
    writer.write(result)
    writer.flush()
    writer.close()
  }
}
