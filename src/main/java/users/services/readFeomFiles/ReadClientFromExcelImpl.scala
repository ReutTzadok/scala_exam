package users.services.readFeomFiles
import users.model.Client

import scala.collection.mutable.ListBuffer

//todo !!!!!!!!!!!!!!!!!!!!!
class ReadClientFromExcelImpl extends ReadClientsFromExcel {
  override def read(filePath: String): ListBuffer[Client] = {
    var tmp = new ListBuffer[Client]
    tmp+=Client("fname", "lname","s", 10, "s", "s", "s", "d", 1200, "d", 0)
    tmp+=Client("Reut", "Tzadok","female", 26, "reut.b1212@gmail.com", "313-1234-12", "s", "d", 1200, "married", 1)
    tmp+=Client("fname", "Tzadok","male", 30, "omer@gmail.com", "313-1234-12", "s", "d", 1200, "married", 1)
    tmp+=Client("fname", "Tzadok","male", 3, "s", "s", "s", "313-1234-12", 1200, "single", 0)
  }
}
