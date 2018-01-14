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
