package edu.holycross.shot.courses
import scala.io.Source


/**  Factory object for reading data about courses from local files.
*/
object SemesterScheduleSource {


  /** Read data from a local delimited-text file into a Vector of [[Course]]s.
  *
  * @param fName Name of file to read.
  * @param sep Delimiting string.
  */
  def apply(fName: String, sep: String = "\t") : Vector[Course] = {
    def lines = Source.fromFile(fName).getLines.toVector
    // drop header line:
    for (l <- lines.tail) yield {
      Course(l, sep)
    }
  }
}
