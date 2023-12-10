/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/13/2023
* Description: Prompt the user for information about their payroll
*              and display a payroll statement
*/

//import scanner library for input
import java.util.Scanner;

public class PayrollConsole {
    /*
     * Class Description:
     * Prompt the user for information about their payroll
     * and display a payroll statement
     */
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // prompt the user for input and store each field
        System.out.print("Enter employee's name: ");
        String name = input.nextLine();

        System.out.print("Enter number of hours worked: ");
        double hours = input.nextDouble();

        System.out.print("Enter hourly pay rate: ");
        double pay = input.nextDouble();

        System.out.print("Enter federal tax withholding rate: ");
        double federalTaxWithholding = input.nextDouble();

        System.out.print("Enter state tax withholding rate: ");
        double stateTaxWithholding = input.nextDouble();

        // all calculations
        double gross = hours * pay;
        double federalWithheld = gross * federalTaxWithholding;
        double federalWithheldPercent = federalTaxWithholding * 100;
        double stateWithheld = gross * stateTaxWithholding;
        double stateWithheldPercent = stateTaxWithholding * 100;
        double totalDeduction = federalWithheld + stateWithheld;
        double netPay = gross - totalDeduction;

        // display the results to the screen
        System.out.println("\n");
        System.out.println("Employee Name: " + name);
        System.out.printf("Hours Worked: %,.2f%n", hours);
        System.out.printf("Pay Rate: $%,.2f%n", pay);
        System.out.printf("Gross Pay: $%,.2f%n", gross);
        System.out.println("Deductions:");
        System.out.printf(" Federal Withholding (%,.2f%%): $%,.2f%n", federalWithheldPercent, federalWithheld);
        System.out.printf(" State Withholding (%,.2f%%): $%,.2f%n", stateWithheldPercent, stateWithheld);
        System.out.printf(" Total Deduction: $%,.2f%n", totalDeduction);
        System.out.printf("Net Pay: $%,.2f%n", netPay);
    }
}