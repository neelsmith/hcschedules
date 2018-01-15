package edu.holycross.shot.courses


/**  Allowed patterns of course days in Holy Cross academic calendar. */
sealed trait CourseDays

/** Monday-Wednesday course pattern. */
case object MW extends CourseDays

/** Monday-Wednesday-Friday course pattern. */
case object MWF extends CourseDays

/** Wednesday-Friday course pattern. */
case object WF extends CourseDays

/** Tuesday-Thursday course pattern. */
case object TR extends CourseDays
