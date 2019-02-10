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

## Profiling a semester schedule

```scala
val f17 = scheduleMap("F17")
// Semester schedules for each semester:
val f17sched = SemesterSchedule(Semester.F17, f17)
```

Profile an individual instructor:

```scala
scala> f17sched.profileInstructor("Smith")
Smith (3):
	CLAS19901 Ancient Coins (F17), Prof. Smith
	GREK10101 Introduction to Greek 1 (F17), Prof. Smith
	GREK34001 Herodotus (F17), Prof. Smith
```

or all:

```scala
scala> f17sched.profileInstructors
Fr. Vodoklys (2):
	CLAS11201 Greek Myths in Literature (F17), Fr. Vodoklys
	CLAS11401 Discerning God & Discovering Self (F17), Fr. Vodoklys
Prof. Andrews (3):
	CLAS12001 Mythology (F17), Prof. Andrews
	LATN27501 Advanced Latin Workshop (F17), Prof. Andrews
	LATN34401 Catullus (F17), Prof. Andrews
Prof. Hamilton (2):
	CLAS22501 Power, Persuasion, & the Law (F17), Prof. Hamilton
	LATN32201 Cicero’s Speeches (F17), Prof. Hamilton
Prof. Joseph (1):
	GREK21301 Intermediate Greek 1 (F17), Prof. Joseph
Prof. Martin (2):
	CLAS10101 Women & Men in Greek Lit & Society (F17), Prof. Martin
	CLAS14101 Ancient Greece: Freedom & Slavery (F17), Prof. Martin
Prof. Perry (1):
	CLAS16001 Introduction to Classical Archaeology (F17), Prof. Perry
Prof. Seider (2):
	CLAS10201 Women & Men in Roman Lit & Society (F17), Prof. Seider
	LATN10102 Introduction to Latin 1 (F17), Prof. Seider
Prof. Smith (3):
	CLAS19901 Ancient Coins (F17), Prof. Smith
	GREK10101 Introduction to Greek 1 (F17), Prof. Smith
	GREK34001 Herodotus (F17), Prof. Smith
Prof. Swalec (3):
	LATN10101 Introduction to Latin 1 (F17), Prof. Swalec
	LATN10103 Introduction to Latin 1 (F17), Prof. Swalec
	LATN21301 Intermediate Latin 1 (F17), Prof. Swalec

Total courses: 19

```

Profile a catalog rubric:

```scala
scala> f17sched.profileRubric("LATN")

LATN (7)
	LATN10101 Introduction to Latin 1 (F17), Prof. Swalec
	LATN10102 Introduction to Latin 1 (F17), Prof. Seider
	LATN10103 Introduction to Latin 1 (F17), Prof. Swalec
	LATN21301 Intermediate Latin 1 (F17), Prof. Swalec
	LATN27501 Advanced Latin Workshop (F17), Prof. Andrews
	LATN32201 Cicero’s Speeches (F17), Prof. Hamilton
	LATN34401 Catullus (F17), Prof. Andrews
```

or all:

```scala
scala> f17sched.profileRubrics

CLAS (9)
	CLAS10101 Women & Men in Greek Lit & Society (F17), Prof. Martin
	CLAS10201 Women & Men in Roman Lit & Society (F17), Prof. Seider
	CLAS11201 Greek Myths in Literature (F17), Fr. Vodoklys
	CLAS11401 Discerning God & Discovering Self (F17), Fr. Vodoklys
	CLAS12001 Mythology (F17), Prof. Andrews
	CLAS14101 Ancient Greece: Freedom & Slavery (F17), Prof. Martin
	CLAS16001 Introduction to Classical Archaeology (F17), Prof. Perry
	CLAS19901 Ancient Coins (F17), Prof. Smith
	CLAS22501 Power, Persuasion, & the Law (F17), Prof. Hamilton

GREK (3)
	GREK10101 Introduction to Greek 1 (F17), Prof. Smith
	GREK21301 Intermediate Greek 1 (F17), Prof. Joseph
	GREK34001 Herodotus (F17), Prof. Smith

LATN (7)
	LATN10101 Introduction to Latin 1 (F17), Prof. Swalec
	LATN10102 Introduction to Latin 1 (F17), Prof. Seider
	LATN10103 Introduction to Latin 1 (F17), Prof. Swalec
	LATN21301 Intermediate Latin 1 (F17), Prof. Swalec
	LATN27501 Advanced Latin Workshop (F17), Prof. Andrews
	LATN32201 Cicero’s Speeches (F17), Prof. Hamilton
	LATN34401 Catullus (F17), Prof. Andrews

Total courses: 19

```

## Create ICS calendars

Course lists are available by semester code:

```scala
val s18courses = scheduleMap("S18")
```

Create a SemesterSchedule, and use it to generate calendars you can load into apps like Apple Calendar.


```scala
val s18Schedule = SemesterSchedule(Semester.S18, s18courses)
val latinCalendar =  s18Schedule.latin.ics
val greekCalendar =  s18Schedule.greek.ics
val classicsCalendar =  s18Schedule.classics.ics
```

Since the result is just a string, you can write it to a file you can open in your favorite calendar app, e.g.,

```scala
import java.io.PrintWriter
new PrintWriter("s18-greek.ics") {write(greekCalendar);close;}
```
