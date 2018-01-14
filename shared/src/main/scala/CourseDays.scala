package edu.holycross.shot.courses


/**  Allowed patterns of course days in Holy Cross academic calendar. */
sealed trait CourseDays


case object MW extends CourseDays
case object MWF extends CourseDays
case object WF extends CourseDays
case object TR extends CourseDays
