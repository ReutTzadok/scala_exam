package users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import users.flow.UserManager



@SpringBootApplication
class Application

object Main {

  def main(args: Array[String]): Unit = {
    val context = new AnnotationConfigApplicationContext("users")

    context.getBean(classOf[UserManager]).flow()
  }
}
