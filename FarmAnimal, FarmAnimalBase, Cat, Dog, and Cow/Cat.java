/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/7/2023
* Description: Class to hold information for the farm animal cat
* File: Cat.java
*/

public class Cat extends FarmAnimalBase {
    /*
     * Class Implementation:
     * can return what a cat says and stores its name
     */

    // Method: Constructor
    public Cat(String name) {
        super(name);
    }

    /*
     * Method: talk
     * Description: returns the noise a cat says
     */
    public String talk() {
        return "Meow! Meow!";
    }
}