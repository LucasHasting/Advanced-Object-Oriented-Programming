/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/1/2023
* Description: Class to that adds annual salary to the Employee class
* File: SalariedEmployee.java
*/

//same package as the EmployeeTest Class
package cis315.exam1;

public class SalariedEmployee extends Employee {
    /*
     * Class Implementation:
     * Used to store salaried employee information
     */

    // declare private member variable annualSalary
    private double annualSalary;

    // Method: Constructor
    public SalariedEmployee(int badgeNumber, String firstName, String lastName, Department department) {
        super(badgeNumber, firstName, lastName, department);
        annualSalary = 0.0;
    }

    // Method: Constructor
    public SalariedEmployee(int badgeNumber, String firstName, String lastName, Department department,
            double annualSalary) {
        super(badgeNumber, firstName, lastName, department);
        this.annualSalary = annualSalary;
    }

    /*
     * Method: getAnnualSalary
     * Description: getter for the annualSalary variable
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /*
     * Method: setAnnualSalary
     * Description: setter for the annualSalary variable
     */
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    /*
     * Method: toString
     * Description: displays output for the SalariedEmployee class
     */
    public String toString() {
        return super.toString() + " " + this.annualSalary;
    }

    /*
     * Method: equals
     * Description: checks if an SalariedEmployee class is equal to another
     */
    public boolean equals(Object salariedEmployee) {
        boolean annualSalary = this.annualSalary == ((SalariedEmployee) salariedEmployee).getAnnualSalary();
        return annualSalary && super.equals(salariedEmployee);
    }
}