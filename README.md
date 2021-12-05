# Java Class Browser

A class browser application, written in java.

Asks for a package name and a class name and displays the classes' data, i.e.
constructors, methods, fields, etc.

## Getting started

### Dependencies

* [Apache Maven](https://maven.apache.org/)
* Java Platform ([OpenJDK 17](https://jdk.java.net/17/))

### Installation

1. Download and install [dependencies](#Dependencies)
2. Navigate to the project root directory
3. Build the application jar file with maven:

```bash
$ mvn install
```

The jar file and build information is then written to the
newly created directory ```targets```.

### Usage

To run the application, use the maven exec command:

```bash
$ mvn exec:exec
```

If you don't want to use the same VM as maven, you can pass
the ```.jar``` file to the locally installed java runtime:

```bash
$ java -jar ./target/browser-1.0-SNAPSHOT.jar
```

### Documentation

To generate the JavaDoc HTML documentation files, run the maven
javadoc command:

```bash
$ mvn javadoc:javadoc
```

The generated files are accessible in the directory ```target/site/apidocs```.

### Tests

Currently, there are no tests for the application.
When writing unit tests, to execute them run the maven test command:

```bash
$ mvn test
```

The generated test results are accessible in the directory ```target/surefire-reports```.
