object TheCompanyProcessScala {

  def cleanWords(input: List[String]) : String = {
    // capitalize: 首字母大写
    // mkString也行，用reduce _ + "," + _也行

    input.filter(_.size > 1).map(_.capitalize).mkString(",")
  }

  def main(args: Array[String]): Unit = {
    val employees = List("neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan",
      "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack")
    println(cleanWords(employees))
  }
}
