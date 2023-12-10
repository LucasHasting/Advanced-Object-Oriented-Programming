/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/26/2023
* Description: Test the StackOfIntegers class
* File: StackOfIntegersTest.java
*/

public class StackOfIntegersTest {
    public static void main(String[] args) {
        // Create Stack
        StackOfIntegers stack = new StackOfIntegers(10);

        // Push to Stack
        for (int i = 0; i < 10; i++)
            stack.push(i);

        // Display Output and Pop Stack
        System.out.println("Pop all elements in the stack, you will get:");
        for (int i = 0; i < 10; i++)
            System.out.print(stack.pop() + " ");

    }
}