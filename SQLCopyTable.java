/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/28/2023
* Description: Creates a table called Student1 and copys it over to Student2
* Source: Intro to Java Programming, Comprehensive Version (10th edition) by Daniel Liang
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SQLCopyTable {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        // store database, username, and password
        boolean auth = false;
        String[] fields = null;
        Connection connection = null;

        while (!auth) {
            try {
                // get the auth fields
                fields = getFields();

                // uses mysql version 8+
                connection = authenticate(fields[0], fields[1], fields[2]);

                // authentication successfull
                auth = true;
            } catch (SQLException e) {
                // try again
                System.out.println("Invalid options, try again.");
            }
        }

        // create the tables in the database
        createTables(connection);

        // fill the first student table
        fillStudentTable(connection);

        // copy Student1 to Student2
        copyTables(connection);

        // display the tables
        System.out.println("Student 1 Table:");
        displayTable(connection, "Student1", 3);
        System.out.println("\nStudent 2 Table:");
        displayTable(connection, "Student2", 5);

        // Close the connection
        connection.close();
    }

    /*
     * Method: getFields
     * Description: retrieves all fields for authentication
     */
    public static String[] getFields() {
        // declare varibales
        String username, password, database;
        Scanner input = new Scanner(System.in);

        // get username, password, and database
        System.out.println("Enter your MySQL Credentials: ");
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        System.out.print("Enter the database to connect to: ");
        database = input.nextLine();
        System.out.println();

        // return the fields
        return new String[] { database, username, password };
    }

    /*
     * Method: authenticate
     * Description: gets a connection to a database
     */
    public static Connection authenticate(String database, String user, String password)
            throws ClassNotFoundException, SQLException {
        // database url
        String DB_URL = "jdbc:mysql://localhost:3306/" + database
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to a database
        Connection connection = DriverManager.getConnection(DB_URL, user, password);

        // return the reference to the connection
        return connection;
    }

    /*
     * Method: displayTable
     * Description: display a table in a database
     */
    public static void displayTable(Connection connection, String table, int fields) throws SQLException {
        // Create a statement
        Statement statement = connection.createStatement();

        // select all from the table
        ResultSet resultSet = statement.executeQuery("select * from " + table);

        // display the table header
        displayTableHeader(connection, table);

        // Iterate through the result
        while (resultSet.next()) {
            for (int i = 0; i < fields; i++) {
                System.out.printf("%-15s", resultSet.getString(i + 1));
            }
            System.out.println();
        }
    }

    /*
     * Method: displayTableHeader
     * Description: Displays the column names for each table
     */
    public static void displayTableHeader(Connection connection, String table) throws SQLException {
        // Create a statement
        Statement statement = connection.createStatement();

        // get all the fields in the table
        ResultSet resultSet = statement.executeQuery("describe " + table);

        // Iterate through the result
        while (resultSet.next()) {
            System.out.printf("%-15s", resultSet.getString(1));
        }
        System.out.println();
    }

    /*
     * Method: createTables
     * Description: Creates the Student1 and Student2 tables
     */
    public static void createTables(Connection connection) throws SQLException {
        // store specefic commands as String variables
        String createStudent1 = "create table Student1 (" +
                "username varchar(50) not null," +
                "password varchar(50) not null," +
                "fullname varchar(200) not null," +
                "constraint pkStudent primary key (username));";

        String removeStudent1 = "drop table Student1";

        String createStudent2 = "create table Student2 (" +
                "username varchar(50) not null," +
                "password varchar(50) not null," +
                "firstname varchar(200) not null," +
                "mi varchar(200) not null," +
                "lastname varchar(200) not null," +
                "constraint pkStudent primary key (username));";

        String removeStudent2 = "drop table Student2";

        // create the tables
        createTablesHelper(connection, createStudent1, removeStudent1);
        createTablesHelper(connection, createStudent2, removeStudent2);
    }

    /*
     * Method: createTablesHelper
     * Description: helper function for createTable
     */
    public static void createTablesHelper(Connection connection, String create, String remove) throws SQLException {
        // create a statement
        Statement stmt = connection.createStatement();

        try {
            // try removing the table
            stmt.executeUpdate(remove);

            // re-create the table
            stmt.executeUpdate(create);
        } catch (SQLException e) {
            // create the table
            stmt.executeUpdate(create);
        }
    }

    /*
     * Method: fillStudentTable
     * Description: fills the Student1 table with test information
     */
    public static void fillStudentTable(Connection connection) throws SQLException {
        // create a preapred statement
        PreparedStatement stmt;

        // store values into the Student1 table
        stmt = connection.prepareStatement("insert into Student1 values (\"john\", \"password\", \"john doe\");");
        stmt.executeUpdate();

        stmt = connection
                .prepareStatement("insert into Student1 values (\"johnnay\", \"password\", \"john nay doe\");");
        stmt.executeUpdate();

        stmt = connection.prepareStatement("insert into Student1 values (\"lucas\", \"password\", \"Lucas Hasting\");");
        stmt.executeUpdate();
    }

    /*
     * Method: copyTables
     * Description: copys Student1 to Student2
     */
    public static void copyTables(Connection connection) throws SQLException {
        // Create a statement
        Statement statement = connection.createStatement();

        // select all values from Student1
        ResultSet resultSet = statement.executeQuery("select * from Student1");

        // Arraylist to store all the commands
        ArrayList<String> commands = new ArrayList<String>();

        // Iterate through the result and copy values from Student1 to Student2
        while (resultSet.next()) {
            // start the instert command
            String command = "insert into Student2 values (\"";

            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    // get fullname and declare first, last, and middle name
                    String fullName = resultSet.getString(3);
                    String firstName, lastName, middleName;

                    // split first name into first, last, and middle
                    try {
                        firstName = fullName.split(" ")[0];
                        middleName = fullName.split(" ")[1];
                        lastName = fullName.split(" ")[2];
                    } catch (IndexOutOfBoundsException e) {
                        firstName = fullName.split(" ")[0];
                        lastName = fullName.split(" ")[1];
                        middleName = " ";
                    }

                    // add the name fields
                    command += firstName + "\", \"";
                    command += middleName + "\", \"";
                    command += lastName + "\");";
                } else {
                    // add all other fields
                    command += resultSet.getString(i + 1) + "\", \"";
                }
            }

            // add the command
            commands.add(command);
        }

        // execute all the insert commands
        for (String command : commands) {
            PreparedStatement stmt = connection.prepareStatement(command);
            stmt.executeUpdate();
        }

    }
}