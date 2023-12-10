/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/1/2023
* Description: Class to that adds hourly rate to the Employee class
* File: Consultant.java
*/

//same package as the EmployeeTest Class
package cis315.exam1;

public class Consultant extends Employee {
    /*
     * Class Implementation:
     * Used to store consultant information
     */

    // declare private member variable hourlyRate
    private double hourlyRate;

    // Method: Constructor
    public Consultant(int badgeNumber, String firstName, String lastName, Department department) {
        super(badgeNumber, firstName, lastName, department);
        hourlyRate = 0.0;
    }

    // Method: Constructor
    public Consultant(int badgeNumber, String firstName, String lastName, Department department, double hourlyRate) {
        super(badgeNumber, firstName, lastName, department);
        this.hourlyRate = hourlyRate;
    }

    /*
     * Method: getHourlyRate
     * Description: getter for the hourlyRate variable
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /*
     * Method: setHourlyRate
     * Description: setter for the hourlyRate variable
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /*
     * Method: toString
     * Description: displays output for the Consultant class
     */
    public String toString() {
        return super.toString() + " " + this.hourlyRate;
    }

    /*
     * Method: equals
     * Description: checks if an Consultant class is equal to another
     */
    public boolean equals(Object consultant) {
        boolean hourlyRate = this.hourlyRate == ((Consultant) consultant).getHourlyRate();
        return hourlyRate && super.equals(consultant);
    }
}