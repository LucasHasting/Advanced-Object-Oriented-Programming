/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/3/2023
* Description: Exception for the compilation method in CodeBot
* File: CompilationException.java
*/

public class CompilationException extends Exception {
    /*
     * Class Implementation:
     * Used to throw a custom exception
     */

    // Method: Constructor
    public CompilationException(String errorMessage) {
        super(errorMessage);
    }
}