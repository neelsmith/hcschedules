package edu.holycross.shot.courses

import java.time._
import java.time.format._


/** Schedule of classes for a spcific semester.
*
*  @param semester
*/
case class SemesterSchedule(semester: Semester, courses: Vector[Course]) {

  require(courses.size > 0, "Cannot create schedule with no courses.")

  /** Number of courses in this schedule.*/
  def size: Integer = courses.size

  /** Label for semester schedule. */
  def label: String = { "Course schedule: " + semester.label}

  /** Select Latin courses. */
  def latin:  Vector[Course] = courses.filter(_.courseNum.startsWith("LA"))

  /** Select Greek courses. */
  def greek = courses.filter(_.courseNum.startsWith("GR"))

  /** Select Classics courses. */
  def classics = courses.filter(_.courseNum.startsWith("CL"))

  /** Select courses outside Classics department. */
  def extra = courses diff latin diff greek diff classics

}

/** Factory object creates [[SemesterSchedule]]  object
* from semester code and course vector.
*/
object SemesterSchedule {


  /**  Creates [[SemesterSchedule]]  object
  * from semester code and course vector.
  *
  * @param key Unique key identifying semester.
  * @param courses Vector of courses.
  */
  def apply(key: String, courses: Vector[Course]) : SemesterSchedule = {
    val semesters = Semester.forCode(key)
    require (semesters.size == 1, "Semester key " + key + " was not a valid unique value.")
    SemesterSchedule(semesters(0), courses)
  }
}
