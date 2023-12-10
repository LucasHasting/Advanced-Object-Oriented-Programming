/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/30/2023
* Description: Class used to store an animals genus, species, 
*              weight, and if it has a tail or not
* File: Animal.java
*/

public class Animal {
    /*
     * Class Implementation:
     * Used to store an animals information
     * It is extended for more fields of information
     */

    // declare private member variables
    private String genus, species;
    private double weight;
    private boolean tail;

    // Method: Constructor
    Animal(String genus, String species) {
        this.genus = genus;
        this.species = species;
        tail = false;
        weight = 0.0;
    }

    /*
     * Method: getGenus
     * Description: getter for the genus Variable
     */
    public String getGenus() {
        return genus;
    }

    /*
     * Method: getSpecies
     * Description: getter for the species Variable
     */
    public String getSpecies() {
        return species;
    }

    /*
     * Method: getWeight
     * Description: getter for the weight Variable
     */
    public double getWeight() {
        return weight;
    }

    /*
     * Method: setWeight
     * Description: setter for the weight Variable
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
     * Method: getTail
     * Description: getter for the tail Variable
     */
    public boolean getTail() {
        return tail;
    }

    /*
     * Method: setTail
     * Description: setter for the tail Variable
     */
    public void setTail(boolean tail) {
        this.tail = tail;
    }
}