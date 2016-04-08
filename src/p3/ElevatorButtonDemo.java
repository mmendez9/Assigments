package p3;

/*
 * Created by mmendez9 on 4/5/2016.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ElevatorButtonDemo extends Application{
    // Create an array of buttons
    private int numOfButtons = 10;
    private Button[] buttonsArray = new Button[numOfButtons];
    private Button test = new Button("Test");
    private Button clear = new Button("Clear");

    @Override
    public void start(Stage primaryStage) {
        // Get the pane for the scene
        primaryStage.setScene(new Scene(getPane(), 200, 300));

        // Setup the stage
        primaryStage.setTitle("Elevator Buttons");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Pane getPane() {
        Pane pane = new VBox(10);
        VBox vBox1 = new VBox(10);
        VBox vBox2 = new VBox(10);
        pane.setPadding(new Insets(20));

        for (int i = numOfButtons - 2; i >= 0; i -= 2) {
            // Set the button number as text for the button
            buttonsArray[i] = new Button(Integer.toString(i + 1));

            // Set preferred width and style with a light gray background
            buttonsArray[i].setShape(new Circle(50));
            buttonsArray[i].setPrefWidth(60);
            buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");


            // Add the button to the pane and set the handler
            vBox1.getChildren().addAll(buttonsArray[i]);
            buttonsArray[i].setOnAction(ButtonHandler);
        }
        for (int j = numOfButtons - 1; j >= 0; j -= 2) {
            // Set the button number as text for the button
            buttonsArray[j] = new Button(Integer.toString(j + 1));

            // Set preferred width and style with a light gray background
            buttonsArray[j].setShape(new Circle(50));
            buttonsArray[j].setPrefWidth(60);
            buttonsArray[j].setStyle("-fx-font: 22 arial; -fx-base: LightGray");


            // Add the button to the pane and set the handler
            vBox2.getChildren().addAll(buttonsArray[j]);
            buttonsArray[j].setOnAction(ButtonHandler);
        }

        // Create a HBox for the odd and even buttons
        HBox hBox = new HBox(25);
        hBox.getChildren().addAll(vBox1, vBox2);

        // Set preferred width and style
        test.setPrefWidth(60);
        test.setShape(new Circle(50));
        test.setStyle("-fx-font: 14 arial; -fx-base: LightGray");
        clear.setPrefWidth(60);
        clear.setShape(new Circle(50));
        clear.setStyle("-fx-font: 14 arial; -fx-base: LightGray");

        // Create another HBox for the test and clear buttons
        HBox hBox1 = new HBox(25);
        hBox1.getChildren().addAll(test, clear);
        test.setOnAction(TestEvent);
        clear.setOnAction(ClearEvent);

        // Add the HBoxes and to the pane
        pane.getChildren().addAll(hBox, hBox1);
        return pane;
    }

    // Build an event handler for the buttons
    private EventHandler<ActionEvent> ButtonHandler = e -> {
        // Identify the object that caused the event
        Button b = (Button)e.getSource();

        // Read the text field of the object and convert it to an integer
        int i = Integer.parseInt(b.getText());

        // Check the background of the button to a dark red
        buttonsArray[i-1].setStyle("-fx-font: 22 arial; -fx-base: DarkRed");
    };

    // Build an event for the test button
    private EventHandler<ActionEvent> TestEvent = e -> {
        for (Button each : buttonsArray) {
            each.setStyle("-fx-font: 22 arial; -fx-base: DarkRed");
        }
    };

    // Build an event for the clear button
    private EventHandler<ActionEvent> ClearEvent = e -> {
      for (Button each : buttonsArray) {
          each.setStyle("-fx-font: 22 arial; -fx-base: LightGray");
      }
    };
}
