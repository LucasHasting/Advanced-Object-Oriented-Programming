
/*
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/29/2023
* Description: Test the Person class and its sub classes
* File: PersonTest.java
*/
public class PersonTest {
    public static void main(String[] args) {
        // Create Each Reference Variable
        Person John = new Person("John Doe", "1960");
        Student Emily = new Student("Emily Zhang", "2007", "Finance");
        Instructor Paul = new Instructor("Paul Zhang", "1970", 50000);
        // Display all Information
        System.out.println(John.toString() + '\n');
        System.out.println(Emily.toString() + '\n');
        System.out.println(Paul.toString());
    }
}
