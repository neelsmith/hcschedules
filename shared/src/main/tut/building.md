---
title:  "Using, building, testing"
layout: page
---

The `courses`library is compiled for both the JVM using scala versions  2.11 and 2.12. Binaries for all platforms are available from jcenter.

If you are using sbt, include `Resolver.jcenterRepo` in your list of resolvers

    resolvers += Resolver.jcenterRepo

and add this to your library dependencies:

"edu.holycross.shot" %%% "courses" % VERSION


For maven, ivy or gradle equivalents, refer to https://bintray.com/neelsmith/maven/courses.

To build from source and test, use normal sbt commands (`compile`, `test` ...).
