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
}
