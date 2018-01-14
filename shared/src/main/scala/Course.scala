package edu.holycross.shot.courses


/**  An individual course.
*
* @param courseNum Holy Cross course number.
* @param title Course title.
* @param instructor Course instructor.
* @param areas Area requirements satisfied by course.
* @param courseSlot Weekly pattern of days course meets.
* @param hour Meeting time.
*/
case class Course(courseNum : String, title: String, instructor: Instructor,
  areas: String,
  courseSlot: Option[CourseDays], hour: String)


  object Course {

    def apply(row: String, sep: String = "\t") : Course = {
      val cols = row.split(sep)
      val courseNum = cols(0)
      val title = cols(1)
      val prof = Instructor(cols(2))
      val areas = cols(3)
      // for now, ignore column 4

      val slot = courseDaysFromString(cols(5))
      val hr = cols(6)

      Course(courseNum, title, prof, areas,slot, hr)
    }
  }
