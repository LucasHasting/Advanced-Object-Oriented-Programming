/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/7/2023
* Description: Tests the FarmAnimalBase class and its subclasses
* File: FarmAnimalTest.java
*/

import java.util.ArrayList;

public class FarmAnimalTest {
    public static void main(String[] args) {
        // Store the animals in an array list
        ArrayList<FarmAnimal> farmAnimals = new ArrayList<FarmAnimal>();
        farmAnimals.add(new Cat("Missy"));
        farmAnimals.add(new Dog("Lassy"));
        farmAnimals.add(new Cow("Nossy"));

        // display each animals name and voice
        for (FarmAnimal farmAnimal : farmAnimals) {
            System.out.print(farmAnimal.getName() + ": " + farmAnimal.talk() + '\n');
        }

        // removes the last \n
        System.out.print('\b');
    }
}