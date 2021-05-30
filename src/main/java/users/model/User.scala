package users.model


case class User(age: Int, name: String, gender: String, email:String, phone: String,
                maritalStatus: String = "unknown", numberOfChildren: Int = 0) {
}
