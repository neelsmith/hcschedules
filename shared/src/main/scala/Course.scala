package edu.holycross.shot.courses
import java.time._
import java.time.format._
import scala.util.Try

/**  An individual course.
*
* @param courseNum Holy Cross course number.
* @param title Course title.
* @param instructor Course instructor.
* @param areas Area requirements satisfied by course.
* @param courseSlot Weekly pattern of days course meets.
* @param hour Meeting time.
* @param capacity Maximum enrollment.
* @param semesterCode Semester offered, formatted as [FS]YY.
*/
case class Course(courseNum : String, title: String, instructor: Instructor,
  areas: String, courseSlot: Option[CourseDays], hour: String, capacity: Option[Int],
  semesterCode: String) {



    /** Add minutes to a class start time on a given day.
    *
    * @param hr Starting time in String `HHMM` (optionally including ":")
    * @param dayOne Day as String `YYYYMMDD`
    */
    def addMinutes(hr: String, dayOne: String, minn:  Int):  String = {

      val s = dayOne + "T" + fourDigit(hr) + "00"
      try {
        val asDateTime = LocalDateTime.parse(s.replaceAll(":",""), icsDayTimeFormatter)
        val endTime = asDateTime.plusMinutes(minn)
        s"${endTime.getHour()}${endTime.getMinute()}00"
      }  catch {
        case dtpe: DateTimeParseException => {
          throw new Exception( "unable to parse hr/day " + hr + ", " + dayOne + ".  " + dtpe)
        }
        case t: Throwable => {
          throw new Exception("Unrecognized exception: " + t)
        }

      }
    }

    /** Write ICS calendar entery for course.
    *
    * @param sem Semester to write entry for.
    */
    def ics(sem: Semester): String = {
      val firstDay = sem.icsFirstDay(courseSlot.get)

      val startTime = fourDigit(hour) + "00"


      val endTime = courseSlot.get match {
        // MWF courses always start on hour, end 50 minutes later
        case MWF => addMinutes(hour, firstDay, 50)

        // Twice-weekly courses start at various times and run 75 minutes.
        case MW =>  addMinutes(hour, firstDay, 75)
        case WF =>  addMinutes(hour, firstDay, 75)
        case TR => addMinutes(hour, firstDay, 75)

        case _ => "NOT IMPLEMENTED: " + courseSlot.get
      }

      s"BEGIN:VEVENT\nSUMMARY:${title}\nTZID:America/New_York\n" +
      s"DTSTART:${firstDay}T${startTime}\n" +
      s"DTEND:${firstDay}T${endTime}\n" +
      s"DTSTAMP:${icsDayTimeFormatter.format(Instant.now())}\n" +
      s"RRULE:FREQ=WEEKLY;UNTIL=${sem.icsUntil}\n" +
      "END:VEVENT\n"
      //LOCATION:Classroom assignment...
    }

  }


/** Factory object for creating [[Course]]s from a delimited text string.
* Each row should have the following columns in this sequence:
*
*  1. course number
*  2. course title
*  3. name of instructor
*  4. area requirements satisfied
*  5. cross listings
*  6. days course meets
*  7. meeting time
*  8. course capacity
*  9. semester code in format [FS]YY
*/
object Course {

  /** Create a [[Course]] object from a string of delimited data.
  *
  * @param row A single row of data representing one course.
  * @param sep String delimiting columns in a row of data.
  */
  def apply(row: String, sep: String = "\t") : Course = {
    val cols = row.split(sep)
    val courseNum = cols(0)
    val title = cols(1)
    val prof = Instructor(cols(2))
    val areas = cols(3)
    // for now, ignore column 4
    val slot = courseDaysFromString(cols(5))
    val hr = cols(6)
    val cap = Try(cols(7).toInt).toOption
    val semesterCode = cols(8)

    Course(courseNum, title, prof, areas,slot, hr, cap, semesterCode)
  }
}
