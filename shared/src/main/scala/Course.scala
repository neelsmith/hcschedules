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
*
* @param row A single row of data representing one course.
* @param sep String delimiting columns in a row of data.
*/
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
