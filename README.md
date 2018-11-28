# eo-jsonp-impl

[![Build Status](https://travis-ci.org/amihaiemil/eo-jsonp-impl.svg?branch=master)](https://travis-ci.org/amihaiemil/eo-jsonp-impl)
[![Coverage Status](https://coveralls.io/repos/github/amihaiemil/eo-jsonp-impl/badge.svg?branch=master)](https://coveralls.io/github/amihaiemil/eo-jsonp-impl?branch=master)

[![DevOps By Rultor.com](http://www.rultor.com/b/amihaiemil/eo-jsonp-impl)](http://www.rultor.com/p/amihaiemil/eo-jsonp-impl)
[![We recommend IntelliJ IDEA](http://amihaiemil.github.io/images/intellij-idea-recommend.svg)](https://www.jetbrains.com/idea/)


An elegant, object-oriented, implementation of the [JSON-P specification (JSR 374)](https://javaee.github.io/jsonp/).

From the user's point of view, this implementation should be no different than others (it's supposed to respect the API, after all). However, it has a better internal design, bigger test coverage, easier extensibility etc. It will also provide a few proprietary classes to give the user more power especially when it comes to Polymorphism.

### Maven dependency

The library comes as a maven dependency:

```
<dependency>
    <groupId>com.amihaiemil.web</groupId>
    <artifactId>eo-jsonp-impl</artifactId>
    <version>not-yet-released</version>
</dependency>
```

If you are not using Maven, you can also download the <a href="#">fat</a> jar.

### Contributing 

If you would like to contribute, just open an issue or a PR.

Make sure the maven build:

``$mvn clean install -Pcheckstyle``

passes before making a PR. [Checkstyle](http://checkstyle.sourceforge.net/) will make sure
you're following our code style and guidlines.

