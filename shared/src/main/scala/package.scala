package edu.holycross.shot
import java.time._
import java.time.format._


/** A library for working with course scheduling data in the Holy Cross academic calendar.
*
* ==Overview==
* A library for working with course scheduling data.
*
*/
package object courses {

  /** Format single day as ICS String.*/
  val icsDayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd").withZone( ZoneId.systemDefault() )

  /** Format date-time as ICS String.*/
  val icsDayTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss").withZone( ZoneId.systemDefault() )

  /** Convert string value to [[CourseDays]].
  * @param s String value to convert.
  */
  def courseDaysFromString(s: String) : Option[CourseDays] = {
    s.toUpperCase.replaceAll(" ","") match {
      case "MW" => Some(MW)
      case "MWF" => Some(MWF)
      case "WF" => Some(WF)
      case "TR" => Some(TR)
      case _ => {
        println("Failed to convert " + s);
        None
      }
    }
  }
}
