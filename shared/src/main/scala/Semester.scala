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
    endDate.format(icsDayFormatter) + "T160000"
  }

  /** Find ICS String for first class day of semester for a given [[CourseDays]] pattern.
  *
  * @param courseDays Pattern of scheduled meetings.
  */
  def icsFirstDay(courseDays: CourseDays) : String = {
    courseDays match {
      case MW => {
        val wed = startDate.`with`(DayOfWeek.WEDNESDAY)
        wed.format(icsDayFormatter) + "T080000"
      }
      case MWF => {
        val wed = startDate.`with`(DayOfWeek.WEDNESDAY)
        wed.format(icsDayFormatter) + "T080000"
      }
      case WF => {
        val wed = startDate.`with`(DayOfWeek.WEDNESDAY)
        wed.format(icsDayFormatter) + "T080000"
      }
      case TR => {
        val tues = startDate.`with`(DayOfWeek.TUESDAY)
        tues.format(icsDayFormatter) + "T080000"
      }
    }
  }
}

/** Factory object for retrieving predefined semesters according to published Holy Cross Academic Calendars.
*/
object Semester {
  val S18 = Semester("S18", LocalDate.parse("2018-01-23"),LocalDate.parse("2018-05-07"))
  val F18 = Semester("F18", LocalDate.parse("2018-08-29"),LocalDate.parse("2018-12-07"))
  val S19 = Semester("S19", LocalDate.parse("2018-01-22"),LocalDate.parse("2018-05-06"))
}
