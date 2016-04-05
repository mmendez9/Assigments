package p1;

/*
 * Created by mmendez9 on 4/5/2016.
 * Traffic Light Demo
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLightDemo extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize three circles in the array
        Circle[] circle = new Circle[3];

        circle[0] = new Circle();
        circle[0].setRadius(50);
        circle[0].setStroke(Color.BLACK);
        circle[0].setFill(Color.WHITE);

        circle[1] = new Circle();
        circle[1].setRadius(50);
        circle[1].setStroke(Color.BLACK);
        circle[1].setFill(Color.WHITE);

        circle[2] = new Circle();
        circle[2].setRadius(50);
        circle[2].setStroke(Color.BLACK);
        circle[2].setFill(Color.WHITE);

        // Create a VBox pane for the circles
        VBox vBox = new VBox(20);
        vBox.setStyle("-fx-background-color: grey");
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(circle[0], circle[1], circle[2]);

        // Create radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        // Create a HBox for the radio buttons
        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: grey");
        hBox.setPadding(new Insets(20));
        hBox.getChildren().addAll(rbRed, rbYellow, rbGreen);

        // Create a pane for the vBox and hBox
        BorderPane pane = new BorderPane();
        pane.setTop(vBox);
        pane.setBottom(hBox);

        // Create the scene for the panes
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
