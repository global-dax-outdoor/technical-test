# Development

## Prerequisites

The project requires JDK 21 installed on your machine. If you need to install this, we recommend using
[SDKMAN!](https://sdkman.io/).

The project provides a [.sdkmanrc](.sdkmanrc) file containing the required
JDK version.

We also recommended using an IDE when working on this test, such as [IntelliJ IDEA](https://www.jetbrains.com/idea/).
If you do not have IntelliJ IDEA installed, we recommend installing the Community Edition.

## Building

The project uses the [Gradle](https://gradle.org/) build tool.

To build the project and run all tests, run the following command from the project root directory:

```shell
./gradlew clean build
```

To build and run tests for just one module, you can run the `build` task prepended with `:<module_name>`: 


```shell
./gradlew clean :core:build
```

## Running

Once built, the project provides two ways of running the Server application.

### IntelliJ Run Configuration

An IntelliJ run configuration called `Server` is provided within the project [here](.run/Server.run.xml).
IntelliJ should find this run configuration automatically.

### Spring Boot Plugin

The [Spring Boot Gradle Plugin](https://docs.spring.io/spring-boot/gradle-plugin/index.html) configured for the
[server](server/build.gradle) module provides the `bootRun` task to run the Spring Boot application.

To run this task, run the following command from the project root directory:

```shell
./gradlew bootRun
```

## Testing

### Unit / Integration Tests

The project provides tests for the two main classes:

* [ComicBookRepositoryTest](core/src/test/java/com/global/dax/core/ComicBookRepositoryTest.java)
* [ComicBookControllerTest](server/src/test/java/com/global/dax/server/web/ComicBookControllerTest.java)

You are welcome to structure your tests in whichever way you prefer.

### HTTP Request Collections

If you would like to test the application while it is running, you can use one of the following methods:

#### Postman

The project contains a [Postman](https://www.postman.com/) collection 
[here](testing/dax-technical-test.postman_collection.json).

To import the collection into Postman, you can drag the file onto the Postman application,
or import via `File`->`Import...`.

### Intellij HTTP Collection

The project contains an [Intellij HTTP Client](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)
collection [here](testing/dax-technical-test.http).

To use the IntelliJ HTTP Client, you must be using IntelliJ IDEA Ultimate.
