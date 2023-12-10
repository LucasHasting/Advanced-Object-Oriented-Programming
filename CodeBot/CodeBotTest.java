/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/3/2023
* Description: Test the CodeBot class 
* File: CodeBotTest.java
*/

public class CodeBotTest {
    public static void main(String[] args) throws CompilationException {
        // Decalre CodeBot reference
        CodeBot bot = new CodeBot();

        // compile the code bot
        bot.compile();

        // seperate output
        System.out.println();

        // create another code bot that will compile incorrectly
        CodeBot bot2 = new CodeBot("Hello2",
                "public class { public static void main(String[] args) {System.out.println(\"hello, world\");}}");

        // compile the second code bot
        bot2.compile();
    }
}