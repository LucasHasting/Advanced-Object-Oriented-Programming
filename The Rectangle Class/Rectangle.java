/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/23/2023
* Description: Class to hold a rectangles width, 
               height, area and perimeter
* File: Rectangle.java
*/

public class Rectangle {
    /*
     * Class Implementation:
     * Used to represent a rectangle
     */

    // declare private member variables
    private double width, height;

    // Method: Default Constructor
    public Rectangle() {
        width = 2.0;
        height = 1.0;
    }

    // Method: Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /*
     * Method: getWidth
     * Description: getter for the width Variable
     */
    public double getWidth() {
        return width;
    }

    /*
     * Method: setWidth
     * Description: setter for the width Variable
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /*
     * Method: getHeight
     * Description: getter for the height Variable
     */
    public double getHeight() {
        return height;
    }

    /*
     * Method: setHeight
     * Description: setter for the height Variable
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /*
     * Method: getArea
     * Description: calculates and returns the area of a rectangle
     */
    public double getArea() {
        return width * height;
    }

    /*
     * Method: getPerimeter
     * Description: calculates and returns the perimeter of a rectangle
     */
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }
}