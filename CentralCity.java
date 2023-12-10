/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/21/2023
* Description: Given a set of points, find the central city
*/

//import scanner library for input
import java.util.Scanner;

public class CentralCity {
    /*
     * Class Description:
     * Given a set of points, find the central city
     */
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // get amount of cities
        System.out.print("Enter the number of cities: ");
        int cities = input.nextInt();

        // Create 2D array for city locations
        double[][] cityLocations = new double[cities][2];

        // get all points
        System.out.print("Enter the coordinates of the cities: ");
        for (int i = 0; i < cities; i++) {
            cityLocations[i][0] = input.nextDouble();
            cityLocations[i][1] = input.nextDouble();
        }

        // get information about the central city
        double[] information = centralCity(cityLocations);

        // get the toal distance of the city
        double distance = information[2];

        // get the cordinates of the central city
        double[] city = { information[0], information[1] };

        // get the distance
        System.out.printf("The central city is at (%,.2f, %,.2f).%n", city[0], city[1]);
        System.out.printf("The total distance from the central city to all other cities is %,.2f.%n", distance);

    }

    /*
     * Method: distance
     * Description: calculates the distance between two cities
     */
    public static double distance(double[] c1, double[] c2) {
        return Math.sqrt((c2[0] - c1[0]) * (c2[0] - c1[0]) + (c2[1] - c1[1]) * (c2[1] - c1[1]));
    }

    /*
     * Method: totalDistance
     * Description: Calculates the total distance from a city to all other cities
     */
    public static double totalDistance(double[][] cities, int i) {
        double total = 0;
        for (int j = 0; j < cities.length; j++) {
            if (i == j)
                continue;
            total += distance(cities[i], cities[j]);
        }
        return total;
    }

    /*
     * Method: centralCity
     * Description: Finds and returns information on the central city
     */
    public static double[] centralCity(double[][] cities) {
        // create an array to hold all distances
        double[] distances = new double[cities.length];

        // get all total distances for each city
        for (int i = 0; i < cities.length; i++) {
            distances[i] = totalDistance(cities, i);
        }

        // finds the minimum total distance and its index
        int minIndex = 0;
        double min = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] < min) {
                min = distances[i];
                minIndex = i;
            }
        }

        // returns the central city's points and total distance
        return new double[] { cities[minIndex][0], cities[minIndex][1], min };

    }
}