package users.services.adapters

import users.model.{Client, Person, User}

import scala.language.implicitConversions

//object PersonToUserAdapter {
object Adapter {
  implicit def adapter (p: Person) : User = {
    User(age=p.age, name= p.name, gender= p.gender, email=p.email, phone=p.phone)
  }

  implicit def adapter (c: Client) : User = {
    User(age=c.age, name= s"${c.firstName} ${c.lastName}", gender= c.gender, email=c.email, phone=c.phone,
      maritalStatus = c.maritalStatus, numberOfChildren = c.numberOfChildren)
  }
}
