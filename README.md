# log4j12-json-layout

Support JSON logging for log4j version 1.2.

## Design Decisions

* JSON parser: [FasterXML/jackson-core](https://github.com/FasterXML/jackson-core/)  
  This project has been created for supporting JSON logging for
  Kafka and ZooKeeper. Both project already contain the required libraries.


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
