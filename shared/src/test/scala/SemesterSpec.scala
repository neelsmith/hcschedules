package edu.holycross.shot.courses
import org.scalatest.FlatSpec
import java.time._
import java.time.format._

class SemesterSpec extends FlatSpec {

  val s18 = Semester.S18

  "A Semester"  should "provide an ICS string for ending course repeats" in {
    val expected = "20180507T160000"
    assert (s18.icsUntil == expected)
  }


  it should "find the first day of a MWF course in ICS format" in {
    val expectedString = "20180124T080000"
    assert(s18.icsFirstDay(MWF) == expectedString)
  }

}
