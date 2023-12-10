/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 7/20/2023
* Description: Animate Radix Sort
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RadixSortAnimation extends Application {
    /*
     * Class Implementation:
     * Displays the GUI
     */

    /*
     * Method: start
     * Description: starts the GUI
     */
    public void start(Stage primaryStage) {
        // Create array object to hold information about the array
        Array array = new Array();

        // Create VBox object to hold everythin on screen
        VBox screen = new VBox();

        // Add all the components of the screen
        screen.getChildren().addAll(displayArray(array.getArr()), displayBucket(array.getBuckets()),
                displayBucketLabels(),
                addButtons(array, screen));

        // Create scene object based on screen
        Scene scene = new Scene(screen, 920, 400);

        // Set the title of the window
        primaryStage.setTitle("Radix Sort Animation");

        // Set the scene
        primaryStage.setScene(scene);

        // Show the scene
        primaryStage.show();
    }

    /*
     * Method: displayBucket
     * Description: Creates the bucket placement for the GUI
     */
    public HBox displayBucket(List<List<Integer>> buckets) {
        // Create HBox to store all buckets
        HBox bucketBox = new HBox();

        // Allign buckets
        bucketBox.setAlignment(Pos.TOP_CENTER);
        bucketBox.setPadding(new Insets(20));
        bucketBox.setSpacing(30);

        // loop for every bucket
        for (int r = 0; r < buckets.size(); r++) {
            // Create empty label
            Label label = new Label("");

            // Declare border
            Border border = new Border(new javafx.scene.layout.BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, null, new BorderWidths(1)));

            // Set the background of the label
            label.setStyle("-fx-background-color: white;");

            // Add the border
            label.setBorder(border);

            // Set the size of the label
            label.setPrefSize(60, 200);

            // Add the label
            bucketBox.getChildren().add(label);
        }

        // Return the HBox (reference) holding the buckets
        return bucketBox;
    }

    /*
     * Method: displayBucketLabels
     * Description: Creates the bucket label placement for the GUI
     */
    public HBox displayBucketLabels() {
        // Create HBox to store all bucket labels
        HBox bucketBox = new HBox();

        // Allign bucket labels
        bucketBox.setAlignment(Pos.TOP_CENTER);
        bucketBox.setSpacing(30);

        // loop for every bucket
        for (int i = 0; i < 10; i++) {
            // create and add the label
            Label label = new Label("bucket[" + i + "]");
            label.setAlignment(Pos.CENTER);
            label.setPrefSize(60, 10);
            bucketBox.getChildren().add(label);
        }

        // Return the HBox (reference) holding the bucket labels
        return bucketBox;
    }

    /*
     * Method: displayArray
     * Description: Creates the array placement for the GUI
     */
    public VBox displayArray(int[] arr) {
        // Create HBox to store all elements of an array
        HBox arrayBox = new HBox();

        // Create VBox to store the top label and HBox array
        VBox top = new VBox();

        // Allign the top label
        top.setAlignment(Pos.TOP_CENTER);

        // Create the top label
        Label finalLabel = new Label("");

        // Add the top label
        top.getChildren().add(finalLabel);

        // Allgin the array
        arrayBox.setAlignment(Pos.TOP_CENTER);
        arrayBox.setPadding(new Insets(20));

        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            // Create label for the array element
            Label label = new Label(" " + arr[i]);

            // Create the border for the label
            Border border = new Border(new javafx.scene.layout.BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, null, new BorderWidths(1)));

            // Set a white background to label
            label.setStyle("-fx-background-color: white;");

            // Add the border to the label
            label.setBorder(border);

            // Set the size of the label
            label.setPrefSize(30, 20);

            // Add the label
            arrayBox.getChildren().add(label);
        }

        // Add the HBox to the VBox
        top.getChildren().add(arrayBox);

        // Return the VBox (reference) holding the top label and Array HBox
        return top;
    }

    /*
     * Method: addButtons
     * Description: Creates the button placement for the GUI
     */
    public HBox addButtons(Array array, VBox screen) {
        // Create HBox to store the buttons
        HBox buttonBox = new HBox();

        // Allgin buttons
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(20));

        // Create a step button and assign it a listener
        Button step = new Button("Step");
        step.setOnAction(new StepListener(array, screen));

        // Create a reset button and assign it a listener
        Button reset = new Button("Reset");
        reset.setOnAction(new ResetListener(array, screen));

        // add the buttons
        buttonBox.getChildren().addAll(step, reset);

        // Return the HBox (reference) holding the buttons
        return buttonBox;
    }

    class StepListener implements EventHandler<ActionEvent> {
        /*
         * Class Implementation:
         * Listener for the step button
         */

        // Create private variables
        private Array array;
        private VBox screen;

        // Method: Constructor
        StepListener(Array array, VBox screen) {
            this.array = array;
            this.screen = screen;
        }

        /*
         * Method: handel
         * Description: Method is called when a button is pressed
         */
        @Override
        public void handle(ActionEvent e) {
            // Get the first VBox from screen to be able to change the text of the top label
            VBox box = (VBox) screen.getChildren().get(0);

            // If the array is sorted, change the top label to let the user know
            if (array.isFinished()) {
                ((Labeled) box.getChildren().get(0)).setText("The array is already sorted!");
                return;
            }

            // Do one step of the bucket sort, which is used for radix sort
            boolean moveOn = bucketSortStep(array.getArr(), array.getElementIndex(), array.getExp(),
                    array.getBuckets());
            array.setElementIndex(array.getElementIndex() + 1);

            // If we can move onto the next itteration of the radix sort
            if (moveOn) {
                // exp *= 10;
                array.setExp(array.getExp() * 10);

                // elementIndex = 0;
                array.setElementIndex(0);
            }

            // update the array and buckets
            array.update(screen);
        }

        /*
         * Method: copyFromBucket
         * Description: Copy the elements from the buckets back into the original array
         */
        private int[] copyFromBucket(int[] arr, List<List<Integer>> buckets) {
            int index = 0;
            for (int i = 0; i < 10; i++) {
                List<Integer> bucket = buckets.get(i);
                for (int num : bucket) {
                    arr[index++] = num;
                }
            }
            return arr;
        }

        /*
         * Method: bucketSortStep
         * Description: Do one step of the bucket sort
         */
        private boolean bucketSortStep(int[] arr, int elementIndex, int exp, List<List<Integer>> buckets) {
            // If All elements have been put into the buckets or the array is sorted
            if (elementIndex >= arr.length || array.isFinished()) {
                // Copy from buckets to the array
                copyFromBucket(arr, buckets);

                // Clear the buckets
                array.clearBuckets();

                // Move onto the next itteration
                return true;
            }

            // Itteration of bucket sort
            int digit = (arr[elementIndex] / exp) % 10;
            buckets.get(digit).add(arr[elementIndex]);

            // Continue
            return false;
        }

    }

    class ResetListener implements EventHandler<ActionEvent> {
        /*
         * Class Implementation:
         * Listener for the reset button
         */

        // Create private variables
        private Array array;
        private VBox screen;

        // Method: Constructor
        ResetListener(Array array, VBox screen) {
            this.array = array;
            this.screen = screen;
        }

        /*
         * Method: handel
         * Description: Method is called when a button is pressed
         */
        @Override
        public void handle(ActionEvent e) {
            // Get the first VBox from the screens VBox
            VBox box = (VBox) screen.getChildren().get(0);

            // Reset the top label
            ((Labeled) box.getChildren().get(0)).setText("");

            // Reset the array and buckets
            array.reset(screen);
        }

    }

    public class Array {
        /*
         * Class Implementation:
         * Object to store all information about an array for radix sort
         */

        // declare private variables
        private int[] arr = new int[20];
        private int elementIndex;
        private int exp;
        private int max;
        private List<List<Integer>> buckets;

        // Method: Constructor
        public Array() {
            exp = 1;
            elementIndex = 0;

            // randomize array
            randomize();

            // set the max variable
            getMax(arr, arr.length);

            // create the buckets
            createBuckets();
        }

        /*
         * Method: getArr
         * Description: getter for the arr Variable
         */
        public int[] getArr() {
            return arr;
        }

        /*
         * Method: getExp
         * Description: getter for the exp Variable
         */
        public int getExp() {
            return exp;
        }

        /*
         * Method: setExp
         * Description: setter for the exp Variable
         */
        public void setExp(int exp) {
            this.exp = exp;
        }

        /*
         * Method: getElementIndex
         * Description: getter for the elementIndex Variable
         */
        public int getElementIndex() {
            return elementIndex;
        }

        /*
         * Method: setElementIndex
         * Description: setter for the elementIndex Variable
         */
        public void setElementIndex(int elementIndex) {
            this.elementIndex = elementIndex;
        }

        /*
         * Method: getBuckets
         * Description: getter for the buckets Variable
         */
        public List<List<Integer>> getBuckets() {
            return buckets;
        }

        /*
         * Method: randomize
         * Description: randomize the values in an array
         */
        public void randomize() {
            Random rand = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(1000);
            }
        }

        /*
         * Method: isFinished
         * Description: checks if the sort is finsihed
         */
        public boolean isFinished() {
            return max / exp <= 0;
        }

        /*
         * Method: getMax
         * Description: sets the max variable
         */
        public void getMax(int arr[], int n) {
            int mx = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > mx)
                    mx = arr[i];
            max = mx;
        }

        /*
         * Method: createBuckets
         * Description: create the buckets variable
         */
        // Description: Create 10 buckets
        public void createBuckets() {
            buckets = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }
        }

        /*
         * Method: clearBuckets
         * Description: reset the buckets variable
         */
        public void clearBuckets() {
            buckets = null;
            createBuckets();
        }

        /*
         * Method: reset
         * Description: resets the objects values
         */
        public void reset(VBox screen) {
            // reset all values
            randomize();
            exp = 1;
            elementIndex = 0;
            getMax(arr, arr.length);
            clearBuckets();

            // updates the screen
            update(screen);
        }

        /*
         * Method: updateArray
         * Description: updates the array on screen
         */
        public void updateArray(VBox screen) {
            // Get first VBox to retrieve the array
            VBox box = (VBox) screen.getChildren().get(0);

            // Get the HBox which has all array element variables
            HBox arrayBox = (HBox) box.getChildren().get(1);
            for (int i = 0; i < arr.length; i++) {
                // Checks if the element needs to be red
                if (i == elementIndex - 1) {
                    // Make the label red and change the text if it has been changed
                    ((Labeled) arrayBox.getChildren().get(i))
                            .setStyle("-fx-text-fill: red; -fx-background-color: white;");
                    ((Labeled) arrayBox.getChildren().get(i)).setText(" " + arr[i]);
                } else {
                    // Make the label white and change the text if it has been changed
                    ((Labeled) arrayBox.getChildren().get(i))
                            .setStyle("-fx-text-fill: black; -fx-background-color: white;");
                    ((Labeled) arrayBox.getChildren().get(i)).setText(" " + arr[i]);
                }
            }
        }

        /*
         * Method: updateBuckets
         * Description: updates the buckets on screen
         */
        public void updateBuckets(VBox screen) {
            // Get the HBox holding the buckets
            HBox bucketBox = (HBox) screen.getChildren().get(1);

            for (int r = 0; r < 10; r++) {
                // Create a VBox to hold a graphic for the label
                VBox vbox = new VBox();

                // Allign Label
                vbox.setPadding(new Insets(10));
                vbox.setSpacing(5);

                // Text array list to hold all Text objects
                ArrayList<Text> labelText = new ArrayList<Text>();

                for (int c = 0; c < buckets.get(r).size(); c++) {
                    // Checks if the Text needs to be red
                    if (arr[elementIndex - 1] == buckets.get(r).get(c)) {
                        // Create and add a red Text object
                        Text text = new Text(buckets.get(r).get(c) + "\n");
                        text.setFill(Color.RED);
                        labelText.add(text);
                    } else {
                        // Create and add a default Text object
                        labelText.add(new Text(buckets.get(r).get(c) + "\n"));
                    }
                }

                // Loop through the Text array list
                for (Text text : labelText) {
                    // Set a label to the VBox
                    Label label = new Label();
                    label.setText(text.getText());
                    label.setTextFill(text.getFill());
                    vbox.getChildren().add(label);
                }

                // Set the VBox as a graphic for the Label
                ((Labeled) bucketBox.getChildren().get(r)).setGraphic(vbox);
            }
        }

        /*
         * Method: update
         * Description: updates the array and buckets on screen
         */
        public void update(VBox screen) {
            updateArray(screen);
            updateBuckets(screen);
        }
    }

    // Method: main driver
    public static void main(String[] args) {
        launch(args);
    }
}