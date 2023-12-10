/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/30/2023
* Description: Test the Animal class and its sub classes
* File: AnimalTest.java
*/

import java.util.ArrayList;

public class AnimalTest {
    public static void main(String[] args) {
        // Create array list to store all objects
        ArrayList<Animal> list = createList();

        // loop through the list to display all animals weight
        for (Animal animal : list) {
            System.out.printf("%.2f lbs%n", animal.getWeight());
        }

        // loop through the list to display all animals names
        for (Animal animal : list) {
            if (animal instanceof Lion)
                System.out.println(((Lion) animal).getName());
        }
    }

    /*
     * Method: createList
     * Description: Create the array list that holds all the animals
     */
    private static ArrayList createList() {
        // create array list to store all animals
        ArrayList<Animal> list = new ArrayList<Animal>();

        // add all the animals
        list.add(new Lion(530, "Leo I"));
        list.add(new Lion(560, "Leo II"));
        list.add(new Lion(590, "Leo III"));
        list.add(new Frog(7, "Freddie"));

        // return array list reference variable
        return list;
    }
}