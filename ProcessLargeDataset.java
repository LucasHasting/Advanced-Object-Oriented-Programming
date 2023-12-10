/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/5/2023
* Description: Do calculations on a large data set
*/

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessLargeDataset {
    public static void main(String[] args) {
        // save the url for data gathering
        String url = "http://liveexample.pearsoncmg.com/data/Salary.txt";

        // get the data into an array list
        ArrayList<String> data = getData(url);

        // display where the data was gethered from
        System.out.println("Data were retrieved from\n" + url + '\n');

        // get the total salarys for all types
        double totalAssistant = getTotal("assistant", data);
        double totalAssociate = getTotal("associate", data);
        double totalFull = getTotal("full", data);
        double total = totalAssistant + totalAssociate + totalFull;

        // display the total salary for all types
        System.out.printf("Total salary for assistant professors is $%,.2f%n", totalAssistant);
        System.out.printf("Total salary for associate professors is $%,.2f%n", totalAssociate);
        System.out.printf("Total salary for full professors is $%,.2f%n", totalFull);
        System.out.printf("Total salary for all professors is $%,.2f%n%n", total);

        // get the average salarys for all types
        double averageAssistant = getAverage("assistant", totalAssistant, data);
        double averageAssociate = getAverage("associate", totalAssociate, data);
        double averageFull = getAverage("full", totalFull, data);
        double average = (totalAssistant + totalAssociate + totalFull) / data.size();

        // display the average salary for all types
        System.out.printf("Average salary for assistant professors is $%,.2f%n", averageAssistant);
        System.out.printf("Average salary for associate professors is $%,.2f%n", averageAssociate);
        System.out.printf("Average salary for full professors is $%,.2f%n", averageFull);
        System.out.printf("Average salary for all professors is $%,.2f", average);
    }

    /*
     * Method: getData
     * Description: gather data from a url
     */
    public static ArrayList<String> getData(String data) {
        // create an array list for storeing the data
        ArrayList<String> totalText = new ArrayList<>();

        // open the url and add each line to the array list
        try {
            URL url = new URL(data);
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                totalText.add(input.nextLine());
            }
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("No such file exists");
        }

        // return the array list with all the data
        return totalText;
    }

    /*
     * Method: getTotal
     * Description: get the total salray based on a search criteria and data
     */
    public static double getTotal(String searchCriteria, ArrayList<String> data) {
        // declare variable to store the total
        double total = 0.0;

        // loop through the data
        for (String i : data) {

            // if the data has our search criteria
            if (i.contains(searchCriteria)) {

                // get the value of the search criteria
                double value = Double.valueOf(i.split(" ")[3]);

                // add the search criteria to total
                total += value;
            }
        }

        return total;
    }

    /*
     * Method: getAverage
     * Description: get the average salray based on a search criteria and data
     */
    public static double getAverage(String searchCriteria, double total, ArrayList<String> data) {
        // declare cariable to store the amount of items in out search criteria
        int amount = 0;

        // loop through the data
        for (String i : data) {

            // if the data has our search criteria add 1 to ammount
            if (i.contains(searchCriteria)) {
                amount++;
            }
        }

        // return the average
        return total / amount;
    }
}