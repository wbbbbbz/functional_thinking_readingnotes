object ComplexNumberScala {

  final class Complex(val real: Int, val imaginary: Int) extends Ordered[Complex] {

    def +(operand: Complex) = new Complex(this.real + operand.real, this.imaginary + operand.imaginary)

    def +(operand: Int) = new Complex(this.real + operand, this.imaginary)

    def -(operand: Complex) = new Complex(this.real - operand.real, this.imaginary - operand.imaginary)

    def -(operand: Int) = new Complex(this.real - operand, this.imaginary)

    def *(operand: Complex) = {
      new Complex((this.real * operand.real) - (this.imaginary * operand.imaginary)
        , (this.real * operand.imaginary) + (this.imaginary + operand.real))
    }

    override def toString: String = real + (if (imaginary < 0) "" else "+") + imaginary + "i"

    override def equals(that: Any): Boolean = that match {
      case other: Complex => other.real == this.real && other.imaginary == this.imaginary
      case other: Int => this.imaginary == 0 && other == this.real
      case _ => false
    }

    override def hashCode(): Int = 41 * ((41 + real) + imaginary)

    // Compare the magnitude of both complex numbers
    override def compare(that: Complex): Int = {
      def myMagnitude = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2))
      def thatMagnitude = Math.sqrt(Math.pow(that.real, 2) + Math.pow(that.imaginary, 2))
//      println((myMagnitude - thatMagnitude).round.toInt)
      (myMagnitude - thatMagnitude).round.toInt
    }
  }


  def main(args: Array[String]): Unit = {

    val f = new {
      val a = new Complex(1, 2)
      val b = new Complex(30, 40)
    }
    val z = f.a + f.b
    assert(1 + 30 == z.real)
    assert(f.a < f.b)
    assert(new Complex(1, 2) <= new Complex(3, 4))
    assert(new Complex(1, 1) < new Complex(2, 2))
    assert(new Complex(-10, -10) > new Complex(1, 1))
    assert(new Complex(1, 2) >= new Complex(1, 2))
    assert(new Complex(1, 2) <= new Complex(1, 2))
  }

}
