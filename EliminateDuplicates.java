/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/24/2023
* Description: Enter in a set of values and remove all duplicate values
*/

//import scanner library for input
import java.util.Scanner;

public class EliminateDuplicates {
    /*
     * Class Description:
     * Enter in a set of values and remove all duplicate values
     */
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // decalre array values
        int[] values = new int[10];

        // prompt the user
        System.out.print("Enter 10 integers: ");

        // get input into the array
        for (int i = 0; i < 10; i++)
            values[i] = input.nextInt();

        // Store the array address with no duplicates
        int[] noDuplicates = eliminateDuplicates(values);

        // display to the screen
        System.out.print("The distinct numbers are: ");
        printArray(noDuplicates);
    }

    /*
     * Method: eliminateDuplicates
     * Description: takes in an array and eliminates and duplicate elements
     */
    public static int[] eliminateDuplicates(int[] list) {
        // create an array of distinct elements
        int[] distinct = new int[list.length];

        // store the first value of the array into the first element of distinct
        distinct[0] = list[0];

        // start the index at 1 since the first index (0) has been used
        int distinctIndex = 1;

        // get all distinct values
        for (int i = 1; i < list.length; i++) {
            // if the element is in the distinct array, continue to the next itteration
            if (isIn(distinct, list[i]))
                continue;

            // store the element in the latest distinct element
            distinct[distinctIndex] = list[i];

            // increase the distinctIndex
            distinctIndex++;
        }

        // Creates a new distinct array to hold exactly the amount of elements
        int[] distinctArray = new int[distinctIndex];

        // copy from distinct to distinctArray
        for (int i = 0; i < distinctIndex; i++) {
            distinctArray[i] = distinct[i];
        }

        // return the address of the distinctArray
        return distinctArray;
    }

    /*
     * Method: isIn
     * Description: checks if an element is in an array
     */
    public static boolean isIn(int[] list, int element) {
        for (int i = 0; i < list.length; i++) {
            if (element == list[i])
                return true;
        }
        return false;
    }

    /*
     * Method: printArray
     * Description: print all elements of an array
     */
    public static void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
