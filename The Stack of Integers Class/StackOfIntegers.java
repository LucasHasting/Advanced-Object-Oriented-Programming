/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/26/2023
* Description: A Stack data structure for integers
* File: StackOfIntegers.java
*/

public class StackOfIntegers {
    /*
     * Class Implementation:
     * Used to store integers. allows the use of pushing and popping
     */

    // declare private member variables
    private int[] elements;
    private int size;

    // Method: Default Constructor
    public StackOfIntegers() {
        elements = new int[16];
        size = 0;
    }

    // Method: Constructor
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    /*
     * Method: empty
     * Description: checks if the stack is empty
     */
    public boolean empty() {
        return size == 0;
    }

    /*
     * Method: peek
     * Description: returns the integer at the top of the stack
     */
    public int peek() {
        // checks if the stack is empty, return -1 if true
        if (empty()) {
            System.out.println("No Numbers in the stack");
            return -1;
        }

        return elements[size - 1];
    }

    /*
     * Method: push
     * Description: pushes an integer to the stack
     */
    public void push(int value) {
        // checks if the stack is full, if true do not push
        if (size == elements.length) {
            System.out.println("No More Space");
            return;
        }
        elements[size++] = value;
    }

    /*
     * Method: pop
     * Description: pops an integer from the stack and returns that number
     */
    public int pop() {
        // checks if the stack is empty, return -1 if true and do not pop
        if (empty()) {
            System.out.println("No Numbers in the stack");
            return -1;
        }

        int value = elements[--size];
        elements[size] = 0;
        return value;
    }

    /*
     * Method: getSize
     * Description: getter for the size Variable
     */
    public int getSize() {
        return size;
    }
}