package edu.holycross.shot.courses
import org.scalatest.FlatSpec


class PackageSpec extends FlatSpec {

  "The package object"  should "convert strings to CourseDays objects" in {
    for (s <- Vector("MW", "MWF", "WF", "TR")) {
      val asObject = courseDaysFromString(s)
      asObject match {
        case opt : Option[CourseDays] => assert(true)
        case _ => fail("Should have created a CourseDays Option")
      }
    }
  }

  it should "recognize invalid valids for CourseDays" in {
    val nogo = courseDaysFromString("Some bogus string")
    nogo match {
      case None => assert(true)
      case _ => fail ("Should have created a None value")
    }

  }

  it should "format three-digit p.m. string patterns as four-digit strings" in {
    val shortList = "1:00"
    val expected = Some("1300")
    assert(fourDigit(shortList)  == expected)
  }

  it should "format three-digit a.m. string patters as four-digit strings" in {
    val shortList = "9:00"
    val expected = Some("0900")
    assert(fourDigit(shortList)  == expected)
  }

  it should "format four-digit a.m. string patterns as four-digit strings" in {
    val shortList = "10:00"
    val expected = Some("1000")
    assert(fourDigit(shortList)  == expected)
  }

  it should "preserve minutes in reformatting p.m. string patterns" in {
      val shortList = "1:30"
      val expected = Some("1330")
      assert(fourDigit(shortList)  == expected)
  }

  it should "preserve minutes in reformatting a.m. string patterns" in {
      val shortList = "9:30"
      val expected = Some("0930")
      assert(fourDigit(shortList)  == expected)
  }

}
