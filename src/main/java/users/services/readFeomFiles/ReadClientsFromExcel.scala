package users.services.readFeomFiles

import users.model.Client

import scala.collection.mutable.ListBuffer

//todo
trait ReadClientsFromExcel {

  def read(filePath: String): ListBuffer[Client]

//  def read(): Unit
//  = {
    //    val fis: FileInputStream = new FileInputStream(new File("data/client.xls"))
    //    val wb: HSSFWorkbook = new HSSFWorkbook(fis)
    //    val sheet: HSSFSheet = wb.getSheetAt(0)
    //    print(StreamSupport.stream(sheet.spliterator, false).count())
//  }


}
