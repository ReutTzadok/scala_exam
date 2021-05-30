package users.services.readFeomFiles

import users.model.Client
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.stereotype.Component

import java.io.File
import scala.collection.convert.ImplicitConversions.`iterable AsScalaIterable`
import scala.collection.mutable.ListBuffer

@Component
class ReadClientFromExcel extends ReadClients {
  val FIRST_NAME = 0
  val LAST_NAME = 1
  val GENDER = 2
  val AGE = 3
  val EMAIL = 4
  val PHONE = 5
  val EDUCATION = 6
  val OCCUPATION = 7
  val SALARY = 8
  val MARITAL_STATUS = 9
  val NUMBER_OF_CHILDREN = 10


  override def read(filePath: String): ListBuffer[Client] = {
    val f = new File(filePath)
    val workbook = WorkbookFactory.create(f)
    val sheet = workbook.getSheetAt(0)
    sheet.removeRow(sheet.getRow(0))

    val clients =
    sheet.map(row => Client(firstName = row.getCell(FIRST_NAME).getStringCellValue, lastName = row.getCell(LAST_NAME).getStringCellValue,
      gender = row.getCell(GENDER).getStringCellValue, age = row.getCell(AGE).getNumericCellValue.toInt, email = row.getCell(EMAIL).getStringCellValue,
      phone = row.getCell(PHONE).getStringCellValue, education = row.getCell(EDUCATION).getStringCellValue,
      occupation = row.getCell(OCCUPATION).getStringCellValue, salary = row.getCell(SALARY).getNumericCellValue.toInt,
      maritalStatus = row.getCell(MARITAL_STATUS).getStringCellValue, numberOfChildren = row.getCell(NUMBER_OF_CHILDREN).getNumericCellValue.toInt))
      .toList

    val clientsBuffer = new ListBuffer[Client]()
    clients.foreach(c => clientsBuffer+=c)

    println("Reading all clients")


    clientsBuffer
  }
}
