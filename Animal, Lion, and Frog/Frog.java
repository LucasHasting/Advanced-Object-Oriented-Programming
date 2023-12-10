/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/30/2023
* Description: Extension of the Animal Class, 
               additionaly stores a frogs name
* File: Frog.java
*/

public class Frog extends Animal {
    /*
     * Class Implementation:
     * adds name information and
     * information from the Animal class
     * sets traits of the animal class to a frog
     */

    // declares private name variable
    private String name;

    // Method: Constructor
    Frog(double weight, String name) {
        super("Lithobates", "Catesbeianus");
        super.setTail(false);
        super.setWeight(weight);
        this.name = name;
    }

    /*
     * Method: getName
     * Description: getter for the name Variable
     */
    public String getName() {
        return name;
    }

    /*
     * Method: setName
     * Description: setter for the name Variable
     */
    public void setName(String name) {
        this.name = name;
    }
}