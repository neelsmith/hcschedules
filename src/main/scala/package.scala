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


  /** Represent hour String as four digits.
  *
  * @param hr Source string, possibly omitting leading 0s.
  */
  def fourDigit(hr: String): Option[String] = {
    //println("FORMATTING " + hr + " ....")
    val timePattern = "^[0-9]?[0-9]:?[0-9][0-9]$"
    if (hr.matches(timePattern)) {
      val raw = hr.replaceAll(":","")
      raw.size match {
        case 4 =>  Some(raw)
        case 3 => {
          val hr = raw.dropRight(2).toInt
          if (hr < 8) {
            val pm = hr + 12
            Some(s"${pm}${raw.slice(1,3)}")
          } else {
            Some(s"0${hr}${raw.drop(1)}")
          }
        }
      }
    } else {
      None
    }
  }
}
