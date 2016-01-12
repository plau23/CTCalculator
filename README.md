 This application is designed to be a simple command-line calculator.
 It handles add, sub, mult and div arithmetic functions and each one take 2 arbitrary expressions.

 The "let" operator for assigning values to variables



 The application can be executed by using the following arguments

 Argument 0 to pass the whole expression in string
 ex. "add(5,10)"
 ex. "add(1,mult(2,3))"
 ex. "let(a,5,let(b,mult(a,10),add(b,a)))"

 Argument 1 to define the debug level in int
 Log_Level can be used to setup from the command line to display 3 levels of debug information
 Debug 0 - covers Info & Error & Debug
 Info  1 - covers Info & Error
 Error 2 - covers Error only
 Note. Info is the default debug level.

 ex. java -jar Calculator.jar "add(5,10)" 1
 ex. java -jar Calculator.jar "sub(10,2)" 0

