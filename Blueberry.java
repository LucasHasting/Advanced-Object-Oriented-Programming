/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/15/2023
* Description: Demonstrate while, do-while and for loops using Blueberrys.
*/

//import scanner library for input
import java.util.Scanner;

public class Blueberry {
    /*
     * Class Description:
     * Demonstrate while, do-while and for loops using Blueberrys.
     */
    public static void main(String[] args) {
        // keep count of the counter, blues, berrys, and blueberrys
        int counter = 1;
        int blueBerry = 0;
        int blue = 0;
        int berry = 0;

        // find blues, berrys, and blueberrys using a while loop
        System.out.println("The following is from a while loop:");
        while (counter <= 100) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.printf("%3d Blueberry%n", counter);
                blueBerry++;
            } else if (counter % 3 == 0) {
                System.out.printf("%3d Blue%n", counter);
                blue++;
            } else if (counter % 5 == 0) {
                System.out.printf("%3d Berry%n", counter);
                berry++;
            } else {
                System.out.printf("%3d%n", counter);
            }
            counter++;
        }
        // display the amount of blues, berrys, and blueberrys
        displayResults(blue, berry, blueBerry);
        System.out.println();

        // reset the count
        counter = 1;
        blueBerry = 0;
        blue = 0;
        berry = 0;

        // find blues, berrys, and blueberrys using a for loop
        System.out.println("The following is from a for loop:");
        for (; counter <= 100; counter++) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.printf("%3d Blueberry%n", counter);
                blueBerry++;
            } else if (counter % 3 == 0) {
                System.out.printf("%3d Blue%n", counter);
                blue++;
            } else if (counter % 5 == 0) {
                System.out.printf("%3d Berry%n", counter);
                berry++;
            } else {
                System.out.printf("%3d%n", counter);
            }
        }
        // display the amount of blues, berrys, and blueberrys
        displayResults(blue, berry, blueBerry);
        System.out.println();

        // reset the count
        counter = 1;
        blueBerry = 0;
        blue = 0;
        berry = 0;

        // find blues, berrys, and blueberrys using a do-while loop
        System.out.println("The following is from a do...while loop:");
        do {
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.printf("%3d Blueberry%n", counter);
                blueBerry++;
            } else if (counter % 3 == 0) {
                System.out.printf("%3d Blue%n", counter);
                blue++;
            } else if (counter % 5 == 0) {
                System.out.printf("%3d Berry%n", counter);
                berry++;
            } else {
                System.out.printf("%3d%n", counter);
            }
            counter++;
        } while (counter <= 100);
        // display the amount of blues, berrys, and blueberrys
        displayResults(blue, berry, blueBerry);
    }

    /*
     * Method: displayResults
     * Description: displays the amount of blues, berrys, and blueberrys
     */
    public static void displayResults(int blue, int berry, int blueBerry) {
        System.out.println("There are " + blue + " Blues");
        System.out.println("There are " + berry + " Berrys");
        System.out.print("There are " + blueBerry + " Blueberrys\n");
    }
}