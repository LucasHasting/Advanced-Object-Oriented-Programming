/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/11/2023
* Description: Prompts the user for a date and 
               ouputs the day of the week for that date
*/

//import scanner library for input
import java.util.Scanner;

public class DayOfTheWeek {
    /*
     * Class Description:
     * Prompts the user for a date and
     * ouputs the day of the week for that date
     */
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // initilize variable to store the day of the week
        String dayOfTheWeek = "";

        // prompt the user for the year and save the input
        System.out.print("Enter the year (e.g., 2020): ");
        int year = input.nextInt();

        // prompt the user for the month and save the input
        System.out.print("Enter the month (i.e., 1-12): ");
        int month = input.nextInt();

        // change Janurary from 1 to 13 and subtract the year by 1
        if (month == 1) {
            month = 13;
            year--;
        }

        // change Feburary from 2 to 14 and subtract the year by 1
        else if (month == 2) {
            month = 14;
            year--;
        }

        // prompt the user for the day and save the input
        System.out.print("Enter the day of the month (i.e., 1-31): ");
        int day = input.nextInt();

        // calculate zero-based century and the year of the century
        int zeroBasedCentury = year / 100;
        int yearOfCentury = year % 100;

        // get the position of the day of the week
        int dayPosition = day + 26 * (month + 1) / 10;
        dayPosition += yearOfCentury + yearOfCentury / 4;
        dayPosition += zeroBasedCentury / 4 + 5 * zeroBasedCentury;
        dayPosition %= 7;

        // decide the day of the week
        switch (dayPosition) {
            case 0:
                dayOfTheWeek = "Saturday";
                break;
            case 1:
                dayOfTheWeek = "Sunday";
                break;
            case 2:
                dayOfTheWeek = "Monday";
                break;
            case 3:
                dayOfTheWeek = "Tuesday";
                break;
            case 4:
                dayOfTheWeek = "Wednesday";
                break;
            case 5:
                dayOfTheWeek = "Thursday";
                break;
            case 6:
                dayOfTheWeek = "Friday";
                break;
            default:
                System.out.println("Invalid Solution");
                return;
        }

        // display the results to the screen
        System.out.println("Day of the week is " + dayOfTheWeek + ".");
    }
}