package edu.holycross.shot.courses
import org.scalatest.FlatSpec



class SemesterScheduleSpec extends FlatSpec {

  val fName = "jvm/src/test/resources/courses-S18.tsv"
  val scheduleMap = ScheduleSource.fromFile(fName)
  val s18courses = scheduleMap("S18")

  "A SemesterSchedule"  should "have a label" in {
    val schedule = SemesterSchedule(Semester.S18, s18courses)
    val expected = "Course schedule: S18"
    assert (schedule.label == expected)
  }

  it should "throw an exception if given an empty list of courses" in {
    val courses = Vector.empty[Course]
    try {
      val schedule = SemesterSchedule(Semester.S18, s18courses)
    } catch {
      case iae:  IllegalArgumentException => assert(true)
      case t: Throwable => fail ("Should have thrown an IllegalArgumentException:  " + t)
    }
  }

  it should "report the number of courses scheduled" in {
    val schedule = SemesterSchedule(Semester.S18, s18courses)
    val expected = 18
    assert (schedule.size == expected)
  }

  it should "be able to select only Latin courses" in {
    val schedule = SemesterSchedule(Semester.S18, s18courses)
    val expected = 6
    assert(schedule.latin.size == expected)
  }

  it should "be able to select only Greek courses" in {
    val schedule = SemesterSchedule(Semester.S18, s18courses)
    val expected = 3
    assert(schedule.greek.size == expected)
  }

  it should "be able to select only Classics courses" in {
    val schedule = SemesterSchedule(Semester.S18, s18courses)
    val expected = 9
    assert(schedule.classics.size == expected)
  }


  it should "create ICS calendars" in {

    val schedule = SemesterSchedule(Semester.S18, s18courses)
    val icsCal = schedule.ics
    println("test " + icsCal)
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
