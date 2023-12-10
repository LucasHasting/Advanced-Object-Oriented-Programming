/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/7/2023
* Description: The Base for the Farm Animal interface
* File: FarmAnimalBase.java
*/

abstract class FarmAnimalBase implements FarmAnimal {
    /*
     * Class Implementation:
     * abstract class used for farm animals cat, dog, and cow
     */

    // declare instance variable name
    private final String name;

    // Method: Constructor
    public FarmAnimalBase(String name) {
        this.name = name;
    }

    /*
     * Method: getName
     * Description: getter for the name Variable
     */
    public String getName() {
        return name;
    }

}