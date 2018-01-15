---
title:  Quick start
layout: page
---


Import the library:

```tut:silent
import edu.holycross.shot.courses._
```

Read a delimited text file to create a map of schedules by semester:


```tut:silent
val fName = "jvm/src/test/resources/courses-S18.tsv"
val scheduleMap = ScheduleSource.fromFile(fName)
```

Course lists are available by semester code:

```tut:silent
val s18courses = scheduleMap("S18")
```
