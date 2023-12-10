/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/24/2023
* Description: Test the Employee class
* File: EmployeeTest.java
*/

public class EmployeeTest {
        public static void main(String[] args) {
                // Create Employee Objects
                Employee employee1 = new Employee("John", "Doe", 3000);
                Employee employee2 = new Employee("Jane", "Doe", 4000);

                // Display their information
                System.out.println("Before the 10% salary increase: \n");
                System.out.printf(
                                employee1.getFirstName() + " " + employee1.getLastName()
                                                + "'s monthly salary is $%,.0f and his yearly salary is $%,.0f.%n",
                                employee1.getMonthlySalary(), employee1.getMonthlySalary() * 12);
                System.out.printf(
                                employee2.getFirstName() + " " + employee2.getLastName()
                                                + "'s monthly salary is $%,.0f and her yearly salary is $%,.0f.%n",
                                employee2.getMonthlySalary(), employee2.getMonthlySalary() * 12);

                // Give both employees a 10% Salary increasse
                employee1.setMonthlySalary(employee1.getMonthlySalary() + (employee1.getMonthlySalary() * 0.1));
                employee2.setMonthlySalary(employee2.getMonthlySalary() + (employee2.getMonthlySalary() * 0.1));

                // Display their information after the increased salary
                System.out.println("\nAfter the 10% salary increase: \n");
                System.out.printf(
                                employee1.getFirstName() + " " + employee1.getLastName()
                                                + "'s monthly salary is $%,.0f and his yearly salary is $%,.0f.%n",
                                employee1.getMonthlySalary(), employee1.getMonthlySalary() * 12);
                System.out.printf(
                                employee2.getFirstName() + " " + employee2.getLastName()
                                                + "'s monthly salary is $%,.0f and her yearly salary is $%,.0f.",
                                employee2.getMonthlySalary(), employee2.getMonthlySalary() * 12);
        }
}
