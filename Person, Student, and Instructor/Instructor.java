
/*
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/29/2023
* Description: Extension of the Person Class,
additionaly stores an instructos salary
* File: Instructor.java
*/
public class Instructor extends Person {
    /*
     * Class Implementation:
     * adds salary information and
     * information from the Person class
     */
    // declare private member variable salary
    private double salary;

    // Method: Default Constructor
    public Instructor() {
        super();
        salary = 0.0;
    }

    // Method: Constructor
    public Instructor(String name, String yearOfBirth, double salary) {
        super(name, yearOfBirth);
        this.salary = salary;
    }

    /*
     * Method: toString
     * Description: overides the toString method to support propper output
     */
    public String toString() {
        return (super.toString() + '\n' + "Instructor Salary: $" +
                String.format("%,.2f", salary));
    }
}
