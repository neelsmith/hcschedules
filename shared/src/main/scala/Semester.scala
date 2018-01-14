package edu.holycross.shot.courses

import java.time._
import java.time.format._


/// Like course schedule lib, get first M,T or W for start week, provide
// DTSTART and DTEND base strings for VEVENTs
// provide UNTIL string for ics repeats
//
/** Information about scheduling of a specific semester.
*
* @param startDate First day of classes.
* @param endDate Last day of classes.
*/
case class Semester(startDate: LocalDate, endDate: LocalDate) {


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
      //"First day of class for " +courseDays + " in week of "+ startDate  + " is " +
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
      //"First day of class for " +courseDays + " in week of "+ startDate  + " is " + startDate.`with`(DayOfWeek.WEDNESDAY)
      case v: CourseDays => "Not yet implemenbted: " + v
    }
    //case object MWF extends CourseDays
    //case object WF extends CourseDays
    //case object TR



  }
}

/** Factory object for retrieving predefined semesters according to published Holy Cross Academic Calendars.
*/
object Semester {
  val S18 = Semester(LocalDate.parse("2018-01-23"),LocalDate.parse("2018-05-07"))
  val F18 = Semester(LocalDate.parse("2018-08-29"),LocalDate.parse("2018-12-07"))
  val S19 = Semester(LocalDate.parse("2018-01-22"),LocalDate.parse("2018-05-06"))
}
