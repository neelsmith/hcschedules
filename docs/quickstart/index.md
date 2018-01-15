---
title:  Quick start
layout: page
---


## Load data from a file

Import the library:

```scala
import edu.holycross.shot.courses._
```

Read a delimited text file to create a map of schedules by semester:


```scala
val fName = "src/test/resources/courses-2017-2018.tsv"
val scheduleMap = ScheduleSource.fromFile(fName)
```


## Create ICS calendars

Course lists are available by semester code:

```scala
val s18courses = scheduleMap("S18")
```

Create a SemesterSchedule, and us it to generate calendars you can load into apps like Apple Calendar.


```scala
val s18Schedule = SemesterSchedule(Semester.S18, s18courses)
val latinCalendar =  s18Schedule.latin.ics
val greekCalendar =  s18Schedule.greek.ics
val classicsCalendar =  s18Schedule.classics.ics
```
