
/*
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/29/2023
* Description: Extension of the Person Class,
additionaly stores a students major
* File: Student.java
*/
public class Student extends Person {
    /*
     * Class Implementation:
     * adds major information and
     * information from the Person class
     */
    // declare private member variable major
    private String major;

    // Method: Default Constructor
    public Student() {
        super();
        major = "";
    }

    // Method: Constructor
    public Student(String name, String yearOfBirth, String major) {
        super(name, yearOfBirth);
        this.major = major;
    }

    /*
     * Method: toString
     * Description: overides the toString method to support propper output
     */
    public String toString() {
        return (super.toString() + '\n' + "Student Major: " + major);
    }
}
