package edu.holycross.shot.courses

import java.time._
import java.time.format._


/** Information about scheduling of a specific semester.
*
* @param startDate First day of classes.
* @param endDate Last day of classes.
*/
case class Semester(label: String, startDate: LocalDate, endDate: LocalDate) {

  /** Find ICS String for last date of classes this semester.
  */
  def icsUntil : String = {
    // classes end by 4:00 pm:
    endDate.format(icsDayFormatter) + "T160000"
  }

  /** Find ICS String for first class day of semester for a given [[CourseDays]]
  *  pattern.  Creates base ICS string for day only:  specific hours can be
  *  appended in format TDDDDDD
  *
  * @param courseDays Pattern of scheduled meetings.
  */
  def icsFirstDay(courseDays: CourseDays) : String = {
    courseDays match {
      case MW => {
        val wed = startDate.`with`(DayOfWeek.WEDNESDAY)
        wed.format(icsDayFormatter)
      }
      case MWF => {
        val wed = startDate.`with`(DayOfWeek.WEDNESDAY)
        wed.format(icsDayFormatter)
      }
      case WF => {
        val wed = startDate.`with`(DayOfWeek.WEDNESDAY)
        wed.format(icsDayFormatter)
      }
      case TR => {
        val tues = startDate.`with`(DayOfWeek.TUESDAY)
        tues.format(icsDayFormatter)
      }
    }
  }
}

/** Factory object for retrieving predefined semesters according to published Holy Cross Academic Calendars.
*/
object Semester {
  val F17 = Semester("F17", LocalDate.parse("2018-08-30"),LocalDate.parse("2018-12-08"))
  val S18 = Semester("S18", LocalDate.parse("2018-01-23"),LocalDate.parse("2018-05-07"))
  val F18 = Semester("F18", LocalDate.parse("2018-08-29"),LocalDate.parse("2018-12-07"))
  val S19 = Semester("S19", LocalDate.parse("2018-01-22"),LocalDate.parse("2018-05-06"))

  val semesters = Vector(F17, S18, F18, S19)

  /** Find all [[Semester]]s with a label matching
  * a given string.
  *
  * @param code Stringto match.
  */
  def forCode(code: String): Vector[Semester] = {
    semesters.filter(_.label.contains(code) )
  }

}
