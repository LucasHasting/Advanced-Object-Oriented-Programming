
/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/3/2023
* Description: create a "code" bot that will write a java file and "compile" it 
* File: CodeBot.java
*/
import java.io.IOException;

public class CodeBot {
    /*
     * Class Implementation:
     * Used to write and "compile" a java file
     */

    // declare private member variable major
    private String className;
    private String code;

    // Method: Default Constructor
    public CodeBot() {
        className = "Hello";
        code = "public class Hello { public static void main(String[] args) {System.out.println(\"hello, world\");}}";
        saveCode();
    }

    // Method: Constructor
    public CodeBot(String className, String code) {
        this.className = className;
        this.code = code;
        saveCode();
    }

    /*
     * Method: saveCode
     * Description: saves the code to a java file
     */
    private void saveCode() {
        // create the file
        String fileName = this.className + ".java";
        java.io.File file = new java.io.File("./" + fileName);

        // check if the file exists, if so exit the program
        if (file.exists()) {
            System.out.println("File " + fileName + " already exists.");
            System.exit(0);
        }
        try (
                // Create an output file
                java.io.PrintWriter output = new java.io.PrintWriter(file);) {
            // Write code to the file
            output.print(code);
        } catch (IOException ex) {
            System.out.println("Unable to make file");
        }
    }

    /*
     * Method: compile
     * Description: checks to see if the code is "compilable"
     */
    public void compile() throws CompilationException {
        // split the code by space
        String[] codeSegments = this.code.split(" ");

        // check if the class name exists, if it does not throw a compilation error
        if (codeSegments[1].equals(this.className) || codeSegments[2].equals(this.className)) {
            System.out.print("The program Hello.java has compiled successfully.");
        } else {
            throw new CompilationException("Class name must be found in code.");
        }
    }
}