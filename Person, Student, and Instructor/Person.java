
/*
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/29/2023
* Description: Class used to store a persons name
* and date of birth
* File: Person.java
*/
public class Person {
    /*
     * Class Implementation:
     * Used to store a persons information
     * It is extended for more fields of information
     */
    // declare private member variables
    private String name;
    private String yearOfBirth;

    // Method: Default Constructor
    public Person() {
        name = "";
        yearOfBirth = "";
    }

    // Method: Constructor
    public Person(String name, String yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    /*
     * Method: toString
     * Description: overides the toString method to support propper output
     */
    public String toString() {
        return ("Person Name: " + name + '\n' + "Person Birth Year: " +
                yearOfBirth);
    }
}
