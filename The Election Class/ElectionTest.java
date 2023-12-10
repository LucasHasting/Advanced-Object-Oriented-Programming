/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/27/2023
* Description: Test the Election class
* File: ElectionTest.java
*/

public class ElectionTest {
    public static void main(String[] args) {
        /*
         * use createElection to create and store a reference variable to an election
         * object
         */
        Election election = createElection();

        // display all candidates for the election
        election.displayAllCandidates();
    }

    /*
     * Method: createElection
     * Description: Create an election refernce object with all candidates
     * information
     */
    private static Election createElection() {
        // Create Election Object
        Election election = new Election();

        // Create and add Republican Candidates to the election
        election.addACandidate(new Candidate("Donald", "Trump", 'R', true));
        election.addACandidate(new Candidate("Ben", "Carson", 'R', false));
        election.addACandidate(new Candidate("Jeb", "Bush", 'R', false));

        // Create and add Democrat Candidates to the election
        election.addACandidate(new Candidate("Hillary", "Clinton ", 'D', true));
        election.addACandidate(new Candidate("Bernie", "Sanders", 'D', false));
        election.addACandidate(new Candidate("Jim", "Webb", 'D', false));

        // return reference variable
        return election;
    }
}