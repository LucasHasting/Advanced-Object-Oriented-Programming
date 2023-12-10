/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/29/2023
* Description: A matching game that uses basic math equations
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Math_Matching_Game {
    public static void main(String[] args) {
        // declare scanner for input
        Scanner input = new Scanner(System.in);

        // start with a valid choice
        int choice = 1;

        // repeatCnt used to repeat the amount of -
        int repeatCnt = 0;

        // The game itself
        while (choice > 0) {
            /* START */

            // get input from user
            int[] rowsCols = start(input);

            // determine the amount of -
            repeatCnt = rowsCols[1] * 20;

            // declare grids
            String[][] equations = new String[rowsCols[0]][rowsCols[1]];
            double[][] solutions = new double[rowsCols[0]][rowsCols[1]];
            boolean[][] solved = new boolean[rowsCols[0]][rowsCols[1]];
            boolean[][] solvedShuffled = new boolean[rowsCols[0]][rowsCols[1]];

            // initilize values
            fillGrid(equations);
            fillEquations(equations, solutions);
            fillBoolean(solved);
            fillBoolean(solvedShuffled);

            // shuffle solutions
            double[][] solutionsShuffled = solutions.clone();
            List<double[]> rows = Arrays.asList(solutionsShuffled);
            Collections.shuffle(rows);
            solutionsShuffled = rows.toArray(solutionsShuffled);

            // seperate output
            System.out.println("-".repeat(repeatCnt));

            while (!solved(solved)) {
                /* GAME */

                // declare row and col variables to be used with ID numbers
                int row, row2, col, col2;
                row = row2 = col = col2 = 0;

                // isValid determins if the loop will continue
                boolean isValid = false;

                while (!isValid) {
                    // display the first grid
                    displayGrid(equations, solved);
                    System.out.println("-".repeat(repeatCnt));

                    // get the equation ID
                    System.out.print("Please enter an equation ID: ");
                    int ID = input.nextInt();
                    System.out.println("-".repeat(repeatCnt));

                    // convert that ID to row and col
                    row = (ID - 1) / rowsCols[1];
                    col = (ID - 1) % rowsCols[1];

                    // check if the ID has been solved, if so repeat
                    if (solved[row][col]) {
                        System.out.println("Choice has already been selected, please try a different option");
                        System.out.println("-".repeat(repeatCnt));
                        continue;
                    }

                    // the program can now go on
                    isValid = true;
                }

                // reset the isValid variable
                isValid = false;

                while (!isValid) {
                    // display the second grid
                    displayGrid(solutionsShuffled, solvedShuffled);
                    System.out.println("-".repeat(repeatCnt));

                    // get the equation ID
                    System.out.print("Please enter a Solution ID: ");
                    int ID2 = input.nextInt();
                    System.out.println("-".repeat(repeatCnt));

                    // convert that ID to row and col
                    row2 = (ID2 - 1) / rowsCols[1];
                    col2 = (ID2 - 1) % rowsCols[1];

                    // check if the ID has been solved, if so repeat
                    if (solvedShuffled[row2][col2]) {
                        System.out.println("Choice has already been selected, please try a different option");
                        System.out.println("-".repeat(repeatCnt));
                        continue;
                    }

                    // the program can now go on
                    isValid = true;
                }

                // check if the IDs are the same
                if (solutions[row][col] == solutionsShuffled[row2][col2]) {
                    solved[row][col] = true;
                    solvedShuffled[row2][col2] = true;
                    System.out.println("That was correct!");
                } else {
                    System.out.println("That was incorrect!");
                }
                System.out.println("-".repeat(repeatCnt));
            }

            // call the end function
            choice = end(input, repeatCnt);
            System.out.println("-".repeat(50));
        }
    }

    /*
     * Method: start
     * Description: gets the rows and columns for the game
     */
    public static int[] start(Scanner input) {
        // get number of rows
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();

        // get number of columns
        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt();

        return new int[] { rows, cols };
    }

    /*
     * Method: end
     * Description: wraps up the game and validates the users choice
     */
    public static int end(Scanner input, int repeatCnt) {
        // let the user know they won
        System.out.println("Congratulations you have beaten this game!");
        System.out.println("-".repeat(50));

        // declare choice
        int choice = -1;

        // validate and get choice from user
        while (choice < 0 || choice > 1) {
            System.out.println("Enter 1 to try another game and 0 to quit");
            System.out.print("Enter: ");
            choice = input.nextInt();
            if (choice < 0 || choice > 1) {
                System.out.println("Invalid option");
                System.out.println("-".repeat(50));
            }
        }

        return choice;
    }

    /*
     * Method: solved
     * Description: checks to see if the game has been solved
     */
    public static boolean solved(boolean[][] solved) {
        for (int r = 0; r < solved.length; r++) {
            for (int c = 0; c < solved[0].length; c++) {
                if (!solved[r][c])
                    return false;
            }
        }
        return true;
    }

    /*
     * Method: displayGrid
     * Description: displays the String grid
     */
    public static void displayGrid(String[][] equations, boolean[][] solved) {
        int ID = 1;
        for (int r = 0; r < equations.length; r++) {
            for (int c = 0; c < equations[0].length; c++) {
                if (solved[r][c])
                    System.out.printf("%s: %-20s", ID, "X");
                else
                    System.out.printf("%s: %-20s", ID, equations[r][c]);
                ID++;
            }
            System.out.println();
        }
    }

    /*
     * Method: displayGrid
     * Description: displays the double grid
     */
    public static void displayGrid(double[][] equations, boolean[][] solved) {
        int ID = 1;
        for (int r = 0; r < equations.length; r++) {
            for (int c = 0; c < equations[0].length; c++) {
                if (solved[r][c])
                    System.out.printf("%s: %-20s", ID, "X");
                else
                    System.out.printf("%d: %-20.2f", ID, equations[r][c]);
                ID++;
            }
            System.out.println();
        }
    }

    /*
     * Method: fillEquations
     * Description: fills a double array with solutions to a String array of
     * equations
     */
    public static void fillEquations(String[][] equations, double[][] solutions) {
        for (int r = 0; r < solutions.length; r++) {
            for (int c = 0; c < solutions[0].length; c++) {
                // get the nuumbers from the equation
                double numberOne = Double.parseDouble(equations[r][c].split(" ")[0]);
                double numberTwo = Double.parseDouble(equations[r][c].split(" ")[2]);

                // calculate the equation
                double solution = calculate(numberOne, numberTwo, equations[r][c].split(" ")[1]);

                // store the solution
                solutions[r][c] = solution;
            }
        }
    }

    /*
     * Method: fillGrid
     * Description: fills a String array with equations
     */
    public static void fillGrid(String[][] equations) {
        for (int r = 0; r < equations.length; r++) {
            for (int c = 0; c < equations[0].length; c++) {
                equations[r][c] = generateEquation();
            }
        }
    }

    /*
     * Method: fillBoolean
     * Description: fills a bollean array with false values
     */
    public static void fillBoolean(boolean[][] solved) {
        for (int r = 0; r < solved.length; r++) {
            for (int c = 0; c < solved[0].length; c++) {
                solved[r][c] = false;
            }
        }
    }

    /*
     * Method: generateEquation
     * Description: generates a random equation in the form of a String
     */
    public static String generateEquation() {
        Random rand = new Random();
        String operator = "";

        // generate numbers
        int numberOne = rand.nextInt(101);
        int numberTwo = rand.nextInt(101);

        // generate operator
        int operatorSelctor = rand.nextInt(4);

        // decide which operator to choose
        switch (operatorSelctor) {
            case 0:
                operator = "+";
                break;
            case 1:
                operator = "-";
                break;
            case 2:
                operator = "*";
                break;
            case 3:
                operator = "/";
                break;
        }

        // return the equation
        return String.valueOf(numberOne) + " " + operator + " " + String.valueOf(numberTwo);
    }

    /*
     * Method: calculate
     * Description: will calculate an equation based on a string operator
     */
    public static double calculate(double numberOne, double numberTwo, String operator) {
        if (operator.charAt(0) == '+')
            return numberOne + numberTwo;
        else if (operator.charAt(0) == '-')
            return numberOne - numberTwo;
        else if (operator.charAt(0) == '*')
            return numberOne * numberTwo;
        else if (numberTwo == 0)
            return 0;
        else
            return numberOne / numberTwo;

    }
}