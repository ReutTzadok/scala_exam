package users.services.readFeomFiles

import users.model.Client
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.stereotype.Component

import java.io.File
import collection.JavaConversions._
import scala.collection.mutable.ListBuffer

@Component
class ReadClientFromExcel extends ReadClients {
  override def read(filePath: String): ListBuffer[Client] = {
    val f = new File(filePath)
    val workbook = WorkbookFactory.create(f)
    val sheet = workbook.getSheetAt(0)
    sheet.removeRow(sheet.getRow(0))

    val clients =
    sheet.map(row => Client(firstName = row.getCell(0).getStringCellValue, lastName = row.getCell(1).getStringCellValue, gender = row.getCell(2).getStringCellValue,
    age = row.getCell(3).getNumericCellValue.toInt, email = row.getCell(4).getStringCellValue, phone = row.getCell(5).getStringCellValue,
    education = row.getCell(6).getStringCellValue, occupation = row.getCell(7).getStringCellValue, salary = row.getCell(8).getNumericCellValue.toInt,
      maritalStatus = row.getCell(9).getStringCellValue, numberOfChildren = row.getCell(10).getNumericCellValue.toInt))
      .toList

    val clientsBuffer = new ListBuffer[Client]()
    clients.foreach(c => clientsBuffer+=c)

    println(s"there is ${clientsBuffer.size} clients")
    println(s"first client is: \n${clientsBuffer.head}")

    clientsBuffer
  }
}
