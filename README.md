# Java laboratory work

This repository contains laboratory works in Java. It includes simple examples such as calculating values using Taylor series expansion, finding matrix norms, and working with classes to study the basics of the language. It also features more complex projects involving `JavaFX` or `Spring`.

## [Сalculation of the Taylor series](https://github.com/Maksim-Kot/Java/tree/main/java_laba_1)
Implementated calculation of the natural logarithm using the Taylor series expansion. 
Added tests to verify the calculated values in comparison with the built-in `Math.log` function, as well as a `range()` function test to verify that the values are in the range from -1 to 1.

## Working with matrices
- [**Working with Matrixes Local minima:**](https://github.com/Maksim-Kot/Java/tree/main/java_laba_2/java_laba_2_local_min) Finding local matrix minima, defined as elements smaller than all their 4 neighbors (up, down, left, right).
- [**Matrix norm:**](https://github.com/Maksim-Kot/Java/tree/main/java_laba_2/java_laba_2_norm) Calculation of the matrix norm in terms of the maximum sum of elements in rows.
- [**Sorting by columns:**](https://github.com/Maksim-Kot/Java/tree/main/java_laba_2/java_laba_2_sorting_by_columns) Sorting the matrix by columns based on the minimum elements of each column (in ascending order).

Tests have been added for each task to verify the correctness of calculations.

## [Character statistics](https://github.com/Maksim-Kot/Java/tree/main/java_laba_3)
Implementation of counting the number of occurrences of characters in the text. Output of characters that are repeated the most number of times.

## [Student performance analysis](https://github.com/Maksim-Kot/Java/tree/main/java_laba_4)
Development of a program for analyzing students' academic performance. Data on the number of students, their full name, course, and group were accepted as input. Additional, information about subjects and grades was introduced. Data analysis has been implemented with the output of information on the number of sessions, exams and the determination of whether a student is an excellent student. Added sorting of students by various criteria.

## [Hotel search](https://github.com/Maksim-Kot/Java/tree/main/java_test_work)
Mini-test work. Implemented a search for hotels based on the specified parameters. The hotel data is downloaded from the file. Main methods have been tested to verify the correctness of the program.

## [Calculator](https://github.com/Maksim-Kot/Java/tree/main/calculator)
A basic calculator application was implemented with functions for addition, subtraction, multiplication, and division. Support for decimal numbers was added. The ability to delete the last entered character was included. The interface was developed using `JavaFX`.

## [Gift selection](https://github.com/Maksim-Kot/Java/tree/main/make_a_present)
Mini Application. A mini gift selection application was implemented with a `JavaFX` interface. It allows users to choose gifts from various stores and calculate the final cost. Additionally, users can order a concert. A discount for regular customers is applied. Store information is stored in an `SQLite` database.

## [H2 database](https://github.com/Maksim-Kot/Java/tree/main/database)
Implemented an H2 database with web access. Products are added to the database via a dedicated POST endpoint. CRUD functionality (Create, Read, Update, Delete) has been implemented for managing products.

## [Introduction to Spring Web](https://github.com/Maksim-Kot/Java/tree/main/spring_project)
A test project to explore the capabilities of `Spring Web`. The functionality is similar to the [Gift selection](#gift-selection) project, but now the cost calculation can be done through a web interface. Additionally, users can choose a list of stores from either a database or a text file.