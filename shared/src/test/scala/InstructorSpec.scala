package edu.holycross.shot.courses
import org.scalatest.FlatSpec

class InstructorSpec extends FlatSpec {

  "An Instructor"  should "have a name" in {
    val instructor = Instructor("Professor X")
    assert(instructor.name == "Professor X")
  }


}
