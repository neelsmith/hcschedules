 import edu.holycross.shot.courses._
val f = "data/F19-S20.cex"
val scheduleMap = ScheduleSource.fromFile(f, "#")
val f19 = scheduleMap("F19")
val s20 = scheduleMap("S20")

val ay19_20 = f19 ++ s20


val f19sched = SemesterSchedule(Semester.F19, f19)
val s20sched = SemesterSchedule(Semester.S20, s20)


def titlesForInstructor(instructorName : String, courses: Vector[Course] = ay19_20) : Vector[String] = {
  courses.filter(_.instructor.name.contains(instructorName)).map(course => course.title + s" (${course.semesterCode})")
}

def profileProf(instructorName : String, courses: Vector[Course] = ay19_20) : Unit = {

  val titles = titlesForInstructor(instructorName, courses)
  println(instructorName + s" (${titles.size}):")
  for (course <- titles) { println("\t" + course) }
}

def profileAll(courses: Vector[Course] = ay19_20) : Unit = {
  val profs = ay19_20.map(_.instructor.name).distinct.sorted
  for (prof <- profs) {
    profileProf(prof, courses)
  }
  println("\nTotal courses: " + courses.size + "\n")
}

def profileRubric(rubric : String, allCourses: Vector[Course] = ay19_20) : Unit = {

  val courses = allCourses.filter(_.courseNum.startsWith(rubric))
  if (courses.nonEmpty) {
    println("\n" + rubric + s" (${courses.size})")
    for (course <- courses) {
      println("\t" + course.title)
    }
  }

}

def allRubrics(courses: Vector[Course] = ay19_20) : Unit = {
  val rubrics = ay19_20.map(_.courseNum.take(4)).distinct.sorted
  for (rubric <- rubrics) {
    profileRubric(rubric, courses)
  }
  println("\nTotal courses: " + courses.size + "\n")
}
