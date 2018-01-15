package edu.holycross.shot.courses
import org.scalatest.FlatSpec

class CourseSpec extends FlatSpec {

  "A Course entry"  should "be constructable from a delimited string" in {

    val delimited = "CLAS10101\tWomen & Men in Greek Lit & Society\tProf. Martin\tLIT\t\tT R\t11:00\t28\tF17"
    val course = Course(delimited)
    assert (course.courseNum ==  "CLAS10101")
    assert(course.title == "Women & Men in Greek Lit & Society")
    assert(course.instructor.name == "Prof. Martin")
    assert(course.courseSlot.get == TR)
    assert(course.hour == "11:00")
  }


  it  should "accept a specified delimited in the  constructor" in {

    val delimited = "CLAS10101#Women & Men in Greek Lit & Society#Prof. Martin#LIT##T R#11:00#28#F17"
    val course = Course(delimited, "#")
    assert (course.courseNum ==  "CLAS10101")
    assert(course.title == "Women & Men in Greek Lit & Society")
    assert(course.instructor.name == "Prof. Martin")
    assert(course.courseSlot.get == TR)
    assert(course.hour == "11:00")
  }

  it should "have an optional capacity" in {
    val delimited = "CLAS10101#Women & Men in Greek Lit & Society#Prof. Martin#LIT##T R#11:00#28#F17"
    val course = Course(delimited, "#")
    val expected = 28
    assert(course.capacity.get == expected)
  }

  it should "generate an ICS calendar entry with two VEVENTs for a TR course" in {
    val delimited = "CLAS10101#Women & Men in Greek Lit & Society#Prof. Martin#LIT##T R#11:00#28#F17"
    val course = Course(delimited, "#")
    val ics = course.ics(Semester.S18)
    val eventLines = ics.split("\n").filter(_.contains("BEGIN:VEVENT"))
    assert(eventLines.size == 2)
  }

  it should "generate an ICS calendar entry with three VEVENTs for a MWF course" in {
    val delimited = "CLAS10201#Women & Men in Roman Lit & Society#Prof. Seider#LIT##M W F#11:00#28#F17"
    val course = Course(delimited, "#")
    val ics = course.ics(Semester.S18)
    val eventLines = ics.split("\n").filter(_.contains("BEGIN:VEVENT"))
    assert(eventLines.size == 3)
  }

  it should "generate an ICS calendar entry with two VEVENTs for a MW course" in {
    val delimited = "LATN34401#Catullus#Prof. Andrews#LANG or LIT##M W#3:00#15#F17"
    val course = Course(delimited, "#")
    val ics = course.ics(Semester.S18)
    val eventLines = ics.split("\n").filter(_.contains("BEGIN:VEVENT"))
    assert(eventLines.size == 2)
  }

  it should "generate an ICS calendar entry with two VEVENTs for a WF course" in {
    val delimited = "CLAS19901#Ancient Coins#Prof. Smith#ARTS#Vis Arts-Hist#W F#12:30#15#F17"
    val course = Course(delimited, "#")
    val ics = course.ics(Semester.F17)
    val eventLines = ics.split("\n").filter(_.contains("BEGIN:VEVENT"))
    assert(eventLines.size == 2)
  }


}
