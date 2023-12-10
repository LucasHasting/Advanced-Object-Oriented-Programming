/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/7/2023
* Description: Class to hold information for the farm animal dog
* File: Dog.java
*/

public class Dog extends FarmAnimalBase {
    /*
     * Class Implementation:
     * can return what a dog says and stores its name
     */

    // Method: Constructor
    public Dog(String name) {
        super(name);
    }

    /*
     * Method: talk
     * Description: returns the noise a dog says
     */
    public String talk() {
        return "Arf! Arf!";
    }
}