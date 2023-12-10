/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/28/2023
* Description: Client to send weight and height and receive the bmi and weight type
* Source: Intro to Java Programming, Comprehensive Version (10th edition) by Daniel Liang
*/

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise31_02Client extends Application {
  // IO streams
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;

  // Buttons and text fields for user input
  private Button btRegister = new Button("Submit");
  private TextField weight = new TextField();
  private TextField height = new TextField();

  // Text area to display contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    // Panel for text field, set up GUI
    GridPane paneForTextField = new GridPane();
    paneForTextField.setPadding(new Insets(5, 5, 5, 5));
    paneForTextField.setStyle("-fx-border-color: green");
    paneForTextField.add(new Label("Weight in Pounds"), 0, 0);
    paneForTextField.add(weight, 1, 0);
    paneForTextField.add(new Label("Height in Inches"), 0, 1);
    paneForTextField.add(height, 1, 1);
    paneForTextField.add(btRegister, 2, 1);
    GridPane.setHalignment(btRegister, HPos.RIGHT);

    // main pane
    BorderPane mainPane = new BorderPane();

    // set up GUI
    mainPane.setCenter(new ScrollPane(ta));
    mainPane.setTop(paneForTextField);

    // set button handler
    btRegister.setOnAction(new ButtonListener());

    // Create a scene and place it in the stage
    Scene scene = new Scene(mainPane, 450, 200);
    primaryStage.setTitle("Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /** Handle button action */
  class ButtonListener implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      try {
        // get weight and height
        double weightValue = Double.parseDouble(weight.getText().trim());
        double heightValue = Double.parseDouble(height.getText().trim());

        // Establish connection with the server
        Socket socket = new Socket("localhost", 8000);

        // Create an output/input stream to the server
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        // send weight and height
        toServer.writeDouble(weightValue);
        toServer.writeDouble(heightValue);
        toServer.flush();

        // get BMI and weight type
        double bmi = fromServer.readDouble();
        String weightType = fromServer.readUTF();

        // display results
        ta.appendText("Weight: " + weightValue + "\n");
        ta.appendText("Height: " + heightValue + "\n");
        ta.appendText(String.format("BMI is: %.2f. %s%n", bmi, weightType));

        // close streams and socket
        toServer.close();
        fromServer.close();
        socket.close();

      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}