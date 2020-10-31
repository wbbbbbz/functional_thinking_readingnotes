import scala.collection.IndexedSeqView
import scala.io.Source

object Palindromes {

  def isPalindrome(x: String) = x == x.reverse
  def findPalindromeIndexed(s: IndexedSeqView[String]) = s.find(isPalindrome)
  def findPalindrome(s: Seq[String]) = s.find(isPalindrome)

  def main(args: Array[String]): Unit = {
    lazy val words = Source.fromFile("resources\\pride-and-prejudice.txt").mkString.split("\\s+").filter(_.matches("\\w+"))
//    println(words.mkString(", "))

    val startTime2 = System.nanoTime()
    findPalindrome(words take 100)
    val endTime2 = System.nanoTime()
    val startTime1 = System.nanoTime()
    findPalindromeIndexed(words.view take 100)
    val endTime1 = System.nanoTime()
    println(s"Time1: ${(endTime1 - startTime1) / math.pow(10, 6)}ms, Time2: ${(endTime2 - startTime2) / math.pow(10, 6)}ms")
  }
}
