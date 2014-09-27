package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if(c == 0 || c == r) 1 else pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def inner(count: Int, chars: List[Char]): Int = {
      if(chars.isEmpty) count
      else if(chars.head == '(' && count >= 0) inner(count+1, chars.tail)
      else if(chars.head == ')') inner(count-1, chars.tail)
      else inner(count, chars.tail)
    }
    inner(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def inner(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else inner(money, coins.tail) + inner(money - coins.head, coins)
    }
    inner(money, coins.sortWith(_ > _))
  }
}
