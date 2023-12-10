/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/7/2023
* Description: Prompts the user to enter two numbers and will display the numbers 
* arithmetic, geometric, and harmonic mean.
*/

//import scanner library for input
import java.util.Scanner;

public class ThreeMeans {
    /*
     * Class Description: Prompts the user to enter two numbers and will display
     * the arithmetic, geometric, and harmonic mean.
     */

    public static void main(String[] args) {
        // prompt the user and create a scanner object
        System.out.print("Enter two positive floating-point numbers: ");
        Scanner input = new Scanner(System.in);

        // gets both numbers from input
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();

        // calculates the arithmetic, geometric, and harmonic mean.
        double arithmeticMean = (number1 + number2) / 2.0;
        double geometricMean = Math.sqrt(number1 * number2);
        double harmonicMean = (2.0 * number1 * number2) / (number1 + number2);

        // display the results to the screen
        System.out.printf("The arithmetic mean is: %,.2f%n", arithmeticMean);
        System.out.printf("The geometric mean is: %,.2f%n", geometricMean);
        System.out.printf("The harmonic mean is: %,.2f%n", harmonicMean);
    }
}