package edu.holycross.shot.courses
import scala.io.Source



  object CourseVectorSource {

    def apply(fName: String, sep: String = "\t") : Vector[Course] = {
      def lines = Source.fromFile(fName).getLines.toVector
      for (l <- lines) yield {
        Course(l, sep)
      }
    }
  }
