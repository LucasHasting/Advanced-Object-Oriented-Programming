/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/27/2023
* Description: Class used to hold candidates for an election and 
*              display their information
* File: Election.java
*/

public class Election {
    /*
     * Class Implementation:
     * Used to store and display information about an election
     */

    // declare private candidate array
    private Candidate[] candidates;

    // Method: Default Constructor
    public Election() {
        candidates = new Candidate[0];
    }

    /*
     * Method: addACandidate
     * Description: Add a candidate to the array
     */
    public void addACandidate(Candidate candidate) {
        // create a reference to the current cadidate array
        Candidate[] candidatesOld = candidates;

        // create a new candidate array
        candidates = new Candidate[candidates.length + 1];

        // copy the old candidate array to the new array, delete the old array
        Copy(candidatesOld);

        // add the new candidate to the array
        candidates[candidates.length - 1] = candidate;
    }

    /*
     * Method: displayAllCandidates
     * Description: displays all the candidates in the array
     */
    public void displayAllCandidates() {
        // display the cateogries of candidacy
        System.out.printf("%-15s %-12s %-8s %-11s%n", "First Name", "Last Name", "Party", "Trustworthy");

        // display the line seperator
        System.out.println("-".repeat(49));

        // diplay information about each candidate
        for (Candidate candidate : candidates) {
            System.out.printf("%-15s %-12s %-8s %-11s%n", candidate.getFirstName(), candidate.getLastName(),
                    candidate.getParty(), candidate.getTrustworthy());
        }

        // delete the last \n
        System.out.print('\b');
    }

    /*
     * Method: Copy
     * Description: copys a candidate array to another candidate array,
     * then deletes the array
     */
    private void Copy(Candidate[] candidates) {
        // copies the array
        for (int i = 0; i < candidates.length; i++) {
            this.candidates[i] = candidates[i];
        }

        // deletes the old array
        candidates = null;
    }
}