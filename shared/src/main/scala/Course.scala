package edu.holycross.shot.courses


case class Course(courseNum : String, title: String, instructor: Instructor,
  courseSlot: Option[CourseDays], hour: String)


  object Course {

    def apply(row: String, sep: String = "\t") : Course = {
      val cols = row.split(sep)
      val courseNum = cols(0)
      val title = cols(1)
      val prof = Instructor(cols(2))
      // for now, ignore columns 3

      val slot = courseDaysFromString(cols(4))
      val hr = cols(5)
      Course(courseNum, title, prof, slot, hr)
    }
  }
