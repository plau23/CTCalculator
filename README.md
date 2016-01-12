Description
==========================================================================
 This application is designed to be a simple command-line calculator.
 It handles add, sub, mult and div arithmetic functions and each one take 2 arbitrary expressions.

 The "let" operator for assigning values to variables


 The application can be executed by using the following arguments

 Argument 0 to pass the whole expression in string
 ex. "add(5,10)"
 ex. "add(1,mult(2,3))"
 ex. "let(a,5,let(b,mult(a,10),add(b,a)))"

 Argument 1 to define the debug level in string
 Log_Level can be used to setup from the command line to display 3 levels of debug information
 debug - covers Info & Error & Debug
 info  - covers Info & Error
 error - covers Error only
 Note. Info is the default debug level.

 ex. java -jar CTCalculator-1.0.jar "add(5,10)" debug
 ex. java -jar CTCalculator-1.0.jar "sub(10,2)" info


 Usage
 ==========================================================================
 This application is built with gradle build system.

 To run with all the test, you can run:

 ./gradlew test

 Replace ./gradlew with gradlew.bat in the above example if you're on Windows.
