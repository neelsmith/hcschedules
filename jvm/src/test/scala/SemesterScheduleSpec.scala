package edu.holycross.shot.courses
import org.scalatest.FlatSpec



class SemesterScheduleSpec extends FlatSpec {

  val fName = "jvm/src/test/resources/courses-S18.tsv"
  val courses = CourseVectorSource(fName)


  "A SemesterSchedule"  should "have a label" in {
    val schedule = SemesterSchedule(Semester.S18, courses)
    val expected = "Course schedule: S18"
    assert (schedule.label == expected)
  }

  it should "throw an exception if given an empty list of courses" in {
    val courses = Vector.empty[Course]
    try {
      val schedule = SemesterSchedule(Semester.S18, courses)
    } catch {
      case iae:  IllegalArgumentException => assert(true)
      case t: Throwable => fail ("Should have thrown an IllegalArgumentException:  " + t)
    }
  }

  it should "report the number of courses scheduled" in {
    val schedule = SemesterSchedule(Semester.S18, courses)
    val expected = 37
    assert (schedule.size == expected)
  }

  it should "be able to select only Latin courses" in {
    val schedule = SemesterSchedule(Semester.S18, courses)
    println(schedule.latin.size + " Latin courses\n\n" +  schedule.latin.mkString("\n"))

  }



}
