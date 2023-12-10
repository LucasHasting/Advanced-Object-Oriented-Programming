/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/1/2023
* Description: Class to hold an employees badge number, first/last name,
*              and department
* File: Employee.java
*/

//same package as the EmployeeTest Class
package cis315.exam1;

public class Employee {
    /*
     * Class Implementation:
     * Used to store employee information
     */

    // declare private member variables
    private int badgeNumber;
    private String firstName, lastName;
    private Department department;

    // Method: Constructor
    public Employee(int badgeNumber, String firstName, String lastName, Department department) {
        this.badgeNumber = badgeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    /*
     * Method: getBadgeNumber
     * Description: getter for the badgeNumber variable
     */
    public int getBadgeNumber() {
        return badgeNumber;
    }

    /*
     * Method: setBadgeNumber
     * Description: setter for the badgeNumber variable
     */
    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    /*
     * Method: getFirstName
     * Description: getter for the firstName variable
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     * Method: setFirstName
     * Description: setter for the firstName variable
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
     * Method: getLastName
     * Description: getter for the lastName variable
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * Method: setLastName
     * Description: setter for the lastName variable
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * Method: getDepartment
     * Description: getter for the department variable
     */
    public Department getDepartment() {
        return department;
    }

    /*
     * Method: setDepartment
     * Description: setter for the department variable
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /*
     * Method: toString
     * Description: displays output for the Employee class
     */
    public String toString() {
        return this.badgeNumber + " " + this.firstName + " " + this.lastName + " " + this.department.toString();
    }

    /*
     * Method: equals
     * Description: checks if an Employee class is equal to another
     */
    public boolean equals(Object employee) {
        boolean badgeNumber = this.badgeNumber == ((Employee) employee).getBadgeNumber();
        boolean firstName = this.firstName.equals(((Employee) employee).getFirstName());
        boolean lastName = this.lastName.equals(((Employee) employee).getLastName());
        boolean department = this.department.equals(((Employee) employee).getDepartment());
        return badgeNumber && firstName && lastName && department;
    }
}