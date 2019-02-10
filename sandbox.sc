import edu.holycross.shot.courses._

// current draft of data:
val f = "data/F19-S20.cex"
val scheduleMap = ScheduleSource.fromFile(f, "#")

// course lists for individual semesters:
val f19 = scheduleMap("F19")
val s20 = scheduleMap("S20")

// all courses for AY '19-'20
val ay19_20 = f19 ++ s20

// Semester schedules for each semester:
val f19sched = SemesterSchedule(Semester.F19, f19)
val s20sched = SemesterSchedule(Semester.S20, s20)
