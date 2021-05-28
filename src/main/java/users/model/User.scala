package users.model


//todo handle the optional
//case class User(age: Int, name: String, gender: String, email:String, phone: String,
//                maritalStatus: Optional[String] = java.util.Optional.empty, numberOfChildren:Optional[Int] = Optional.empty)


case class User(age: Int, name: String, gender: String, email:String, phone: String,
                maritalStatus: String = "unknown", numberOfChildren: Int = 0) {

}
