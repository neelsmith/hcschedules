import scala.io.Source
val f = "courses-S18.tsv"
val lines = Source.fromFile(f).getLines.toVector.drop(1)


sealed trait CourseDays
case object MW extends CourseDays
case object MWF extends CourseDays
case object WF extends CourseDays
case object TR extends CourseDays


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
case class Professor(name: String)


case class Course(courseNum : String, title: String, instructor: Professor,
  courseSlot: Option[CourseDays], hour: String)

object Course {

  def apply(row: String, sep: String = "\t") : Course = {
    val cols = row.split(sep)
    val courseNum = cols(0)
    val title = cols(1)
    val prof = Professor(cols(2))
    val slot = courseDaysFromString(cols(5))
    val hr = cols(6)
    Course(courseNum, title, prof, slot, hr)
  }
}

val courses = for (l <- lines) yield {
  Course(l)
}
