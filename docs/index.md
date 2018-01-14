---
title:  Course scheduling library
layout: page
---


A library to help manage data about class schedules on the Holy Cross academic calendar.  It includes functions for working with delimited text data in local files, selecting and manipulating course data on various criteria, and formatting variously including in `.ics` format for use with calendar apps.


## API docs

Available [here](https://neelsmith.github.io/hcschedules/api/edu/holycross/shot/courses/index.html).

## Delimited file format

A delimited file should have a header row.

Each subsequent data row should have the following columns in this sequence:

1. course number
2. course title
3. name of instructor
4. area requirements satisfied
5. cross listings
6. days course meets
7. meeting time
8. course capacity
9. semester (abbreviated [SF]YY)
