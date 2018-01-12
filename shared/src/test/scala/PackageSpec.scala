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


}
