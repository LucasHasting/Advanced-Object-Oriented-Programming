/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/8/2023
* Description:Test the Octagon Class
* File: OctagonTest.java
*/

public class OctagonTest {
    public static void main(String[] args) {
        // Create octagon reference
        Octagon o1 = new Octagon(5.00);

        // display information
        System.out.printf("Area of the octagon with side value %.2f is %,.2f\n", o1.getSide(), o1.getArea());
        System.out.printf("Perimeter of the octagon with side value %.2f is %,.2f\n", o1.getSide(), o1.getPerimeter());

        // clone the object to a different reference
        Octagon o2 = (Octagon) (o1.clone());

        // display if the result
        System.out.printf("Comparison result between an octagon and its clone: %d", o1.compareTo(o2));
    }
}
