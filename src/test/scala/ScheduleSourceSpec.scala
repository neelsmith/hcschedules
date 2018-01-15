package edu.holycross.shot.courses
import org.scalatest.FlatSpec



class ScheduleSourceSpec extends FlatSpec {

  val fName = "jvm/src/test/resources/courses-2017-2018.tsv"
  val scheduleMap = ScheduleSource.fromFile(fName)

  "A ScheduleSourceSpec"  should "construct a map of schedules from a local file" in  {
    val expectedSemesters = 2
    assert(scheduleMap.size == expectedSemesters)
  }

  it should "key the map by valid and unique semester codes" in {
    val expectedKeys = Set("F17", "S18")
    assert(scheduleMap.keySet == expectedKeys)

    for (k <- scheduleMap.keySet) {
      assert(Semester.forCode(k).size == 1)
    }
  }


}
