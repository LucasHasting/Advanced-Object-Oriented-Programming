/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/9/2023
* Description: Prompt the user for 3 points on the cartesian plane, 
*              calculate the area of the triangle those 3 points make.
*/

//import scanner library for input
import java.util.Scanner;

public class AreaOfATriangle {
    /*
     * Prompt the user for 3 points on the cartesian plane,
     * calculate the area of the triangle those 3 points make.
     */
    public static void main(String[] args) {
        // prompt the user and create a scanner object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three points for a triangle: ");

        // gets points from input
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        // calculates the sides
        double sideA = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double sideB = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        double sideC = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));

        /*
         * checks if any of the sides are negative,
         * if so make them positive
         */
        if (sideA < 0)
            sideA = -sideA;
        if (sideB < 0)
            sideB = -sideB;
        if (sideC < 0)
            sideC = -sideC;

        // calculates the area
        double s = (sideA + sideB + sideC) / 2.0;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

        // display the results to the screen
        System.out.printf("The area of the triangle is %.2f.%n", area);
    }
}