/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/23/2023
* Description: Test the Rectangle Class
* File: RectangleTest.java
*/

public class RectangleTest {
        public static void main(String[] args) {
                // Create rectangle object
                Rectangle rectangle = new Rectangle(40.0, 4.0);

                // Display its information
                System.out.println("Before the change: \n");
                System.out.printf("The rectangle's width is %.2f and its height is %.2f.%n", rectangle.getWidth(),
                                rectangle.getHeight());
                System.out.printf("Its area is %.2f and its perimeter is %.2f.%n", rectangle.getArea(),
                                rectangle.getPerimeter());

                // change the height and width
                rectangle.setWidth(35.90);
                rectangle.setHeight(3.5);

                // Display its information after the change
                System.out.println("\nAfter the change: \n");
                System.out.printf("The rectangle's width is %.2f and its height is %.2f.%n", rectangle.getWidth(),
                                rectangle.getHeight());
                System.out.printf("Its area is %.2f and its perimeter is %.2f.", rectangle.getArea(),
                                rectangle.getPerimeter());
        }
}
