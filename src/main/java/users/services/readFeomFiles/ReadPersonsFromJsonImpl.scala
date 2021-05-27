package users.services.readFeomFiles
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods.parse
import org.springframework.stereotype.Component
import users.model.Person

import scala.collection.mutable.ListBuffer
import scala.io.Source


@Component
class ReadPersonsFromJsonImpl extends ReadPersonsFromJson {
  implicit val formats: DefaultFormats.type = DefaultFormats

  override def read(filePath: String): ListBuffer[Person] = {

    val file = Source.fromFile(filePath)
    val jsonPeople = file.getLines.mkString
    file.close()

    val people = parse(jsonPeople).extract[List[Person]]

    //todo remove
    println(people.size)

    val tmp = new ListBuffer[Person]()
    people.foreach(p => tmp+=p)
//    return new ListBuffer[Person]()

//    people.to

//    return people.to(ListBuffer)
    println(tmp.size)
    return tmp

  }
}
