package edu.holycross.shot.courses
import org.scalatest.FlatSpec



class SemesterScheduleSpec extends FlatSpec {

  val fName = "src/test/resources/courses-2017-2018.tsv"
  val scheduleMap = ScheduleSource.fromFile(fName)
  val s18courses = scheduleMap("S18")
  val s18Schedule = SemesterSchedule(Semester.S18, s18courses)

  "A SemesterSchedule"  should "have a label" in {
    val expected = "Course schedule: S18"
    assert (s18Schedule.label == expected)
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
    val expected = 18
    assert (s18Schedule.size == expected)
  }

  it should "be able to select only Latin courses" in {
    val expected = 6
    assert(s18Schedule.latin.size == expected)
  }

  it should "be able to select only Greek courses" in {
    val expected = 3
    assert(s18Schedule.greek.size == expected)
  }

  it should "be able to select only Classics courses" in {
    val expected = 9
    assert(s18Schedule.classics.size == expected)
  }


  it should "create ICS calendars" in {
    val latinCal = s18Schedule.latin.ics.split("\n")
    val eventLabels = latinCal.filter(_.contains("BEGIN:VEVENT"))
    assert(eventLabels.size == 16)
  }



  "Its factory object" should "make a SemesterSchedule from a key and vector of courses" in {

     try {
       val schedule = SemesterSchedule("S18", s18courses)
     } catch {
       case iae:  IllegalArgumentException => assert(true)
       case t: Throwable => fail ("Should have thrown an IllegalArgumentException:  " + t)
     }
  }
}
