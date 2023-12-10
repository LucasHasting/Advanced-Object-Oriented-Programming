/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/28/2023
* Description: Server to calculate the bmi based on weight and height recieved from a client
* Source: Intro to Java Programming, Comprehensive Version (10th edition) by Daniel Liang
*/

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class BMI_Server extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Text area for displaying contents
    TextArea ta = new TextArea();

    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
    primaryStage.setTitle("Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    new Thread(() -> {
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        Platform.runLater(() -> ta.appendText("Server started at " + new Date() + '\n'));

        // Listen for a connection request
        Socket socket = serverSocket.accept();
        ta.appendText("Connected to a client at " + new Date() + '\n');

        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
            socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
            socket.getOutputStream());

        while (true) {
          // Receive weight and height from the client
          double weight = inputFromClient.readDouble();
          double height = inputFromClient.readDouble();

          // calculate bmi
          double kilo = weight * 0.45359237;
          double meters = height * 0.0254;
          double bmi = kilo / (meters * meters);

          // get the wight type based on bmi
          String weightType = findWeightType(bmi);

          // Send bmi and weight type back to the client
          outputToClient.writeDouble(bmi);
          outputToClient.writeUTF(weightType);

          // display the weeight, height, bmi, and weight type
          Platform.runLater(() -> {
            ta.appendText("Weight: " + weight + "\n");
            ta.appendText("Height: " + height + "\n");
            ta.appendText(String.format("BMI is: %.2f. %s%n", bmi, weightType));
          });

          // close socket
          serverSocket.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }

  /*
   * Method: findWeightType
   * Description: finds the weight type based on bmi
   */
  public static String findWeightType(double bmi) {
    if (bmi < 18.5)
      return "Underweight";
    else if (bmi < 25)
      return "Normal";
    else if (bmi < 30)
      return "Overweight";
    else
      return "Obese";
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}