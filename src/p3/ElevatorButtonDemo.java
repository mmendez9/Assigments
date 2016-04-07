package p3;

/*
 * Created by Aryam Ayala on 4/5/2016.
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
import javafx.scene.paint.Color;
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
        primaryStage.setScene(new Scene(getPane(), 300, 600));

        // Setup the stage
        primaryStage.setTitle("Elevator Buttons");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

     private Pane getPane() {
         Pane pane = new VBox(10);
         pane.setPadding(new Insets(40));

        for (int i = numOfButtons - 1; i >= 0; i--) {

            // Set the button number as text for the button
            buttonsArray[i] = new Button(Integer.toString(i + 1));
            buttonsArray[i].setShape(new Circle(50));

            // Set preferred width and style with a light gray background
            buttonsArray[i].setPrefWidth(100);
            buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            pane.getChildren().add(buttonsArray[i]);
            buttonsArray[i].setOnAction(ButtonHandler);
        }
         HBox hBox = new HBox(20);
         hBox.getChildren().addAll(test, clear);
         pane.getChildren().addAll(hBox);
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
}
