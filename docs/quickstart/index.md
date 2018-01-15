---
title:  Quick start
layout: page
---


Import the library:

```scala
import edu.holycross.shot.courses._
```

Read a delimited text file to create a map of schedules by semester:


```scala
val fName = "jvm/src/test/resources/courses-S18.tsv"
val scheduleMap = ScheduleSource.fromFile(fName)
```

Course lists are available by semester code:

```scala
val s18courses = scheduleMap("S18")
```
