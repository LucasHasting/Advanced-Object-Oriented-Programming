/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/27/2023
* Description: Class used to store specefic information about each 
               candidiate for an election
* File: Candidate.java
*/

public class Candidate {
    /*
     * Class Implementation:
     * Used to store candiates for the Election Class
     */

    // declare private member variables
    private String firstName, lastName;
    private char party;
    private boolean trustworthy;

    // Method: Constructor
    public Candidate(String firstName, String lastName, char party, boolean trustworthy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.trustworthy = trustworthy;
    }

    /*
     * Method: getFirstName
     * Description: getter for the firstName Variable
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     * Method: getLastName
     * Description: getter for the lastName Variable
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * Method: getParty
     * Description: getter for the party Variable
     */
    public char getParty() {
        return party;
    }

    /*
     * Method: setParty
     * Description: setter for the party Variable
     */
    public void setParty(char party) {
        this.party = party;
    }

    /*
     * Method: getTrustworthy
     * Description: getter for the trustworthy Variable
     */
    public boolean getTrustworthy() {
        return trustworthy;
    }

    /*
     * Method: setTrustworthy
     * Description: setter for the trustworthy Variable
     */
    public void setTrustworthy(boolean trustworthy) {
        this.trustworthy = trustworthy;
    }
}