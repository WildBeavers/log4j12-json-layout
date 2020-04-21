# log4j12-json-layout

A JSON layout for Log4J (v1.2). This project is based on
the GitHub project [thmshmm/log4j-json-layout](https://github.com/thmshmm/log4j-json-layout/)
but uses more recent version of Java, Maven and dependent libraries.

## Output format
```json
{"timestamp":"<DATE>","level":"<LEVEL>","logger":"<LOGGER>","thread":"<THREAD>","message":"<MESSAGE>","stacktrace":"<STACKTRACE>"}
```
The "stacktrace" item is optional and will only be in the JSON object if the log message has a trace message.

## Example log4j.properties

```text
log4j.appender.myAppender=org.apache.log4j.DailyRollingFileAppender
log4j.appender.myAppender.File=/var/log/my.log
log4j.appender.myAppender.layout=com.github.wildbeavers.log4j12jsonlayout.JsonLayout
log4j.appender.myAppender.layout.DatePattern=yyyy-MM-dd HH:mm:ss,SSS
```

## Layout configuration
| Name | Options | Default |
|------|---------|---------|
| DatePattern | all valid SimpleDateFormat patterns | yyyy-MM-dd HH:mm:ss,SSS |


## Design Decisions

* JSON parser: [FasterXML/jackson-core](https://github.com/FasterXML/jackson-core/)  
  This project has been created for supporting JSON logging for
  Kafka and ZooKeeper. Both projects already contain the required libraries.
* JAVA Version: 11  
  * a long supported Java version has to be selected => LTS version required
  * a recent but not bleeding edge version is required

## Building

1.  The [pom.xml](pom.xml) contains at the beginning a list of properties
    with the versions of the dependent libraries. Update these values
    to match with the Kafka / ZooKeeper version (always choose the smaller
    version when they are different)
1.  Local build:

            mvn package

1.  Release build

    1.  Update version at [pom.xml](pom.xml)
    1.  Build JAR inside a Docker container

            docker build . -t log4j12-json-layout:latest

    1.  Copy the JAR to the local filesystem:

            docker run -v ${PWD}:/local log4j12-json-layout:latest bash -c "cp /target/log4j12-json-layout-*.jar /local/ && chmod ugo+w /local/*"

    1.  Create new release at Github and attach JAR

## Similar projects

There are several projects with a similar scope:

* [log4j-json](https://github.com/michaeltandy/log4j-json/)
  * last release _Nov 28, 2012_ / commit _Mar 27, 2015_ 
  * depends on [google/gson](https://github.com/google/gson/)
* [log4j-json-layout](https://github.com/thmshmm/log4j-json-layout/)
  * last release `none` / commit _Dec 1, 2017_
  * depends on [FasterXML/jackson-core](https://github.com/FasterXML/jackson-core/)
* [log4j-jsonevent-layout](https://github.com/logstash/log4j-jsonevent-layout)
  * last release _Sep 9, 2014_ / last commit _Sep 9, 2014_
  * depends on [json-smart](https://netplex.github.io/json-smart/)
