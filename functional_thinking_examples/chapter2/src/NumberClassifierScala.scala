import scala.util.Random

object NumberClassifierScala {

  def factorOfNumber(target : Int) : List[Int] = (1 until target).filter(target % _ == 0).toList

  def aliquotSumOfNumber(target : Int) : Int = factorOfNumber(target).sum

  def main(args: Array[String]): Unit = {
    for(_ <- (1 to 10)){
      val number = Random.nextInt(10000)
      println(number)
      println(aliquotSumOfNumber(number))
      println(factorOfNumber(number))
    }
  }
}
