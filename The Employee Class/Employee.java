/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/24/2023
* Description: Class to hold an employees first/last name
*              and monthly salary
* File: Employee.java
*/

public class Employee {
    /*
     * Class Implementation:
     * Used to store employee information
     */

    // declare private member variables
    private String firstName, lastName;
    private double monthlySalary;

    // Method: Default Constructor
    Employee() {
        firstName = "";
        lastName = "";
        monthlySalary = 0.0;
    }

    // Method: Constructor
    Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    /*
     * Method: getFirstName
     * Description: getter for the firstName Variable
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     * Method: setFirstName
     * Description: setter for the firstName Variable
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
     * Method: getLastName
     * Description: getter for the lastName Variable
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * Method: setLastName
     * Description: setter for the lastName Variable
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * Method: getMonthlySalary
     * Description: getter for the monthlySalary Variable
     */
    public double getMonthlySalary() {
        return monthlySalary;
    }

    /*
     * Method: setMonthlySalary
     * Description: setter for the monthlySalary Variable
     */
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}