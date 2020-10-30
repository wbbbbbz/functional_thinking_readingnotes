object FirstIndexOfAny {

  def firstIndexOfAny(input : String, searchChars : Seq[Char]) : Option[Int] =  {

    val indexedInput = (0 until input.size).zip(input)
    // 使用Scala的for comprehension首先查看待搜索字符的集合，然后取出索引集合中的索引字符对。由于Scala允许快捷访问集合的元素，所以我可以直接将当前搜索的字符与集合的第二个元素进行比较
    val result = for(i <- indexedInput; j <- searchChars; if (j == i._2)) yield (i._1)

    // null的存在是Java语言的一大混乱来源：它到底是一个有效的返回值，还是表明返回值缺失了？
    // 包括Scala在内的很多函数式语言通过Option类来避免这种语义上的含混，其取值要么是表示没有返回值的None，要么是容纳了返回值的Some。
    if (result.isEmpty)
      None
    else
      return Some(result.head)
  }

  def indexOfAny(input : String, searchChars : Seq[Char]) : Option[Seq[Int]] =  {

    val indexedInput = (0 until input.size).zip(input)
    // 使用Scala的for comprehension首先查看待搜索字符的集合，然后取出索引集合中的索引字符对。由于Scala允许快捷访问集合的元素，所以我可以直接将当前搜索的字符与集合的第二个元素进行比较
    val result = for(i <- indexedInput; j <- searchChars; if (j == i._2)) yield (i._1)

    if (result.isEmpty)
      None
    else
      return Some(result)
  }

  def main(args: Array[String]): Unit = {
    println(firstIndexOfAny("fawehglaksjhlawjeflajg", Seq('g', 'e')))
    println(indexOfAny("fawehglaksjhlawjeflajg", Seq('g')))
  }

}
