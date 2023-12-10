/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/23/2023
* Description: Generate hash codes from strings
* Source: Paul Zhang
*/

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class HashCodeForString {
    public static void main(String[] args) {
        // Create a hash set
        Set<String> set = new HashSet<>();

        // Add strings to the set
        set.add("CIS 315");
        set.add("Java");
        set.add("Programming");
        set.add("Lucas Hasting");
        ArrayList<String> myArrayList = setToList(set);

        // Display the hash code for each element in the array list
        for (String str : myArrayList) {
            System.out.println("The hash code for \"" + str + "\" = " +
                    hashCodeForString(str));
        }
    }

    /*
     * Method: hashCodeForString
     * Description: Return a hash code for a string
     */
    public static int hashCodeForString(String s) {
        return s.hashCode();
    }

    /*
     * Method: setToList
     * Description: Return an ArrayList from a set
     */
    public static <E> ArrayList<E> setToList(Set<E> s) {
        return new ArrayList<E>(s);
    }
}