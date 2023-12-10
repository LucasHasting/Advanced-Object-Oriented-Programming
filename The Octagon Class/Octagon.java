/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/8/2023
* Description: Class stores information for an Octagon
* File: Octagon.java
*/

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    /*
     * Class Implementation:
     * - used to store information for an octogon
     * - extends the GeometricObject class
     * - implements the comparable and cloneable interfaces
     */

    // declare private member variable side
    private double side;

    // Method: Default Constructor
    public Octagon() {
        super();
        side = 0;
    }

    // Method: Constructor
    public Octagon(double side) {
        super();
        this.side = side;
    }

    /*
     * Method: getPerimeter
     * Description: Calculates the perimeter of the octagon
     */
    public double getPerimeter() {
        return side * 8;
    }

    /*
     * Method: getArea
     * Description: Calculates the area of the octagon
     */
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    /*
     * Method: getSide
     * Description: getter for the side Variable
     */
    public double getSide() {
        return side;
    }

    /*
     * Method: compareTo
     * Description: Overides the compareTo method from the Comparable interface
     */
    public int compareTo(Octagon o) {
        // if o.getSide() == this.getSide() {return 0}
        // else if o.getSide() > this.getSide() {return 1}
        // else {return -1}
        return o.getSide() == this.getSide() ? 0 : (o.getSide() > this.getSide() ? 1 : -1);
    }

    /*
     * Method: clone
     * Description: Overides the clone method from the Cloneable interface
     */
    public Object clone() {
        // Store empty octogon reference
        Octagon octagon = null;

        // copy the object
        try {
            octagon = (Octagon) super.clone();
        } catch (CloneNotSupportedException e) {
            octagon = new Octagon(this.getSide());
        }

        // return the new reference
        return octagon;
    }
}