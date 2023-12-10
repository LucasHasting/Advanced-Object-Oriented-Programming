/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/17/2023
* Description: Prompt the user for a number and 
*              displays its reverse and if it is a palindrome
*/

//import scanner library for input
import java.util.Scanner;

public class PalindromeInteger {
    /*
     * Class Description:
     * Prompt the user for a number and
     * displays its reverse and if it is a palindrome
     */
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // prompt the user for a number and save the input
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // display the results to the screen
        System.out.println("The number " + number + " in reverse order is " + reverse(number) + ".");
        if (isPalindrome(number))
            System.out.println("The number " + number + " is a palindrome.");
        else
            System.out.println("The number " + number + " is not a palindrome.");
    }

    /*
     * Method: reverse
     * Description: creates the reverse of a number
     */
    public static int reverse(int number) {
        // placeholder number which will be the reverse number
        int reverseNumber = 0;

        // create a copy of the number but in string form
        String numberString = number + "";

        // get the length of the string to get the amount of places
        int places = numberString.length();

        // put the number in reverse using / and %
        for (; number > 0; number /= 10, places--)
            reverseNumber += (number % 10) * Math.pow(10, places - 1);

        // return the reverse number
        return reverseNumber;
    }

    /*
     * Method: isPalindrome
     * Description: Checks is a number is a palindrome
     */
    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }
}