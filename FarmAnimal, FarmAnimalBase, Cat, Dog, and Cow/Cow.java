/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/7/2023
* Description: Class to hold information for the farm animal cow
* File: Cow.java
*/

public class Cow extends FarmAnimalBase {
    /*
     * Class Implementation:
     * can return what a cow says and stores its name
     */

    // Method: Constructor
    public Cow(String name) {
        super(name);
    }

    /*
     * Method: talk
     * Description: returns the noise a cow says
     */
    public String talk() {
        return "Moo! Moo!";
    }
}