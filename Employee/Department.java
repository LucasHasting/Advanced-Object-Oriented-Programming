/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/1/2023
* Description: Class to hold a departments badge name and building number
* File: Department.java
*/

//same package as the EmployeeTest Class
package cis315.exam1;

public class Department {
    /*
     * Class Implementation:
     * Used to store department information
     */

    // declare private member variables
    private String name;
    private int buildingNumber;

    // Method: Constructor
    public Department(String name, int buildingNumber) {
        this.name = name;
        this.buildingNumber = buildingNumber;
    }

    /*
     * Method: getName
     * Description: getter for the name variable
     */
    public String getName() {
        return name;
    }

    /*
     * Method: setName
     * Description: setter for the name variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Method: getBuildingNumber
     * Description: getter for the buildingNumber variable
     */
    public int getBuildingNumber() {
        return buildingNumber;
    }

    /*
     * Method: setBuildingNumber
     * Description: setter for the buildingNumber variable
     */
    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    /*
     * Method: toString
     * Description: displays output for the Department class
     */
    public String toString() {
        return this.name + " " + this.buildingNumber;
    }

    /*
     * Method: equals
     * Description: checks if an Department class is equal to another
     */
    public boolean equals(Department department) {
        boolean name = this.name.equals(((Department) department).getName());
        boolean buildingNumber = this.buildingNumber == ((Department) department).getBuildingNumber();
        return name && buildingNumber;
    }
}