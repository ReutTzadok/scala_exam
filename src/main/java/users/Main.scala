package users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import users.services.UserManager



//todo last - create better test with scala's library



@SpringBootApplication
class Application

object Main {

  def main(args: Array[String]): Unit = {

    val context: ConfigurableApplicationContext = SpringApplication.run(classOf[Application], args: _*)
    val userManager: UserManager = context.getBean(classOf[UserManager])

    userManager.flow()
  }
}
