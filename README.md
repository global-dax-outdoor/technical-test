# DAX Technical Test

The project contains an application to track a comic book collection.

The application is required to be able to:

- Add comic books to the collection, ensuring no duplicates
- List all comic books stored in the collection
- Search the comic book collection by series

The project is split into two modules:

- [core](core) - Core services and data model
- [server](server) - [Spring Boot](https://spring.io/projects/spring-boot) application providing a REST API

Each of these modules are currently unfinished. 

There are multiple `TODO` comments throughout each module describing what needs to be added (or fixed!).

The project also provides the [test-utils](test-utils) module, which contains [example data](test-utils/src/main/java/com/global/dax/testing/TestConstants.java) that can be used when
writing tests.

## Task

For this task, you will need to address each of the `TODO` comments, implementing the required feature or fix.

If you have addressed all the tasks marked with `TODO`, try and implement the following features:

- Search the comic book collection by any attribute
- Search the comic book collection by multiple attributes
- Search the comic book collection by which characters appear

If you have completed all the tasks above, add or document any other features you think may be useful.

Any notes you may wish to add can be added [here](NOTES.md).

We recommend spending __at most two hours__ on this task. If you find there are any changes or improvements
you would make given more time, please include them in your notes.

For detailed information on how to build and run the project, see the [development documentation](DEVELOPMENT.md).

## What you will be assessed on

Your submission will be assessed on the following areas:

* Correctness
  * Does the code adequately address the given requirements?
* Code quality
  * Is the provided code clear and concise?
* Testing
  * Is the provided code well tested, covering sufficient test cases?

## Feedback

If you would like to give us feedback on the technical test, please add it to your notes.
