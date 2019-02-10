---
title:  Quick start
layout: page
---


## Load data from a file

Import the library:

```tut:silent
import edu.holycross.shot.courses._
```

Read a delimited text file to create a map of schedules by semester:


```tut:silent
val fName = "src/test/resources/courses-2017-2018.tsv"
val scheduleMap = ScheduleSource.fromFile(fName)
```

## Profiling a semester schedule

```tut:silent
val f17 = scheduleMap("F17")
// Semester schedules for each semester:
val f17sched = SemesterSchedule(Semester.F17, f17)
```

Profile an individual instructor:

```tut
f17sched.profileInstructor("Smith")
```

or all:

```tut
f17sched.profileInstructors
```

Profile a catalog rubric:

```tut
f17sched.profileRubric("LATN")
```

or all:

```tut
f17sched.profileRubrics
```

## Create ICS calendars

Course lists are available by semester code:

```tut:silent
val s18courses = scheduleMap("S18")
```

Create a SemesterSchedule, and use it to generate calendars you can load into apps like Apple Calendar.


```tut:silent
val s18Schedule = SemesterSchedule(Semester.S18, s18courses)
val latinCalendar =  s18Schedule.latin.ics
val greekCalendar =  s18Schedule.greek.ics
val classicsCalendar =  s18Schedule.classics.ics
```

Since the result is just a string, you can write it to a file you can open in your favorite calendar app, e.g.,

```tut:silent
import java.io.PrintWriter
new PrintWriter("s18-greek.ics") {write(greekCalendar);close;}
```
