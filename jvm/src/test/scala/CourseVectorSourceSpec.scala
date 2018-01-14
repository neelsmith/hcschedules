package edu.holycross.shot.courses
import org.scalatest.FlatSpec



class CourseVectorSourceSpec extends FlatSpec {

  "A CourseVectorSource"  should "construct a Vector from a local file" in {
    val fName = "jvm/src/test/resources/courses-S18.tsv"
    val courses = CourseVectorSource(fName)
    val expectedCourses = 37
    assert(courses.size == expectedCourses)
  }


}
