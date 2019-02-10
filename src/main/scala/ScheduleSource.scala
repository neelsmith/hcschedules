package edu.holycross.shot.courses
import scala.io.Source


/**  Factory object for reading data about courses from local files.
*/
object ScheduleSource {


  /** Read data from a local delimited-text file into a Vector of [[Course]]s.
  *
  * @param fName Name of file to read.
  * @param sep Delimiting string.
  */
  def fromFile(fName: String, sep: String = "\t")  : Map[String, Vector[Course]] = {
    def lines = Source.fromFile(fName).getLines.toVector
    // drop header line:
    val prs = for (l <- lines.tail) yield {

      val columns = l.split(sep)
      if (columns.size != 9) {
        println(s"Wrong number of columns (${columns.size}) in " + l)
      }
      val code = columns(8)
      val semesterVector = Semester.forCode(code)
      require(semesterVector.size == 1, "Could not find unique semester for code " + code)
      (semesterVector(0).label, Course(l, sep))
    }
    val labelMap = prs.groupBy(_._1)
    val coursesOnly = for (k <- labelMap.keySet) yield {
      (k, labelMap(k).map{case (k,c) => c})
    }

    coursesOnly.toMap
  }
}
