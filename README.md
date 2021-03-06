# DB-project2

## Description:

This project is part of a number of projects to be used during a Java training. The specific scope of this project is to become familiar with XML.<br>
The application will do the following:
* It will create a database
* It will open an XML file (a file with a number of employees)
* It will parse the XML file (unmarshal)
* It will import the employees
* remark 1: no XSD is being used (rootelement annotation has been added manually)
* remark 2: cucumber has been added as plugin

## To emphasize:
* JAXB stands for Java Architecture for XML Binding
* no additional libraries needed (clean pom) as of Java 1.6 !!!
* 2 be.ictdynamic.training.domain objects : Employees vs DatabaseEmployee
* Explain how to run a unit test from within IntelliJ
* usage of inner class. make inner class non-static and run again
* certain fields are null
* date : specific format !!!
* usage of altova xml spy when creating very complex XML files
* data-integrity problems: if we would include depts and employees, it should not be possible to create an employee with an invalid dept
* JSON -> see poc-customer-dna-service

* first example of BDD and cucumber has been added : run CucumberTests

## Webpages to read:
* https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html