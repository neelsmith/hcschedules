package edu.holycross.shot



/** A library for working with course scheduling data.
*
* ==Overview==
* A library for working with course scheduling data.
*
*/
package object courses {

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
