/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/30/2023
* Description: Extension of the Animal Class, 
               additionaly stores a lions name
* File: Lion.java
*/

public class Lion extends Animal {
    /*
     * Class Implementation:
     * adds name information and
     * information from the Animal class
     * sets traits of the animal class to a lion
     */

    // declares private name variable
    private String name;

    // Method: Constructor
    Lion(double weight, String name) {
        super("Panthera", "Leo");
        super.setTail(true);
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