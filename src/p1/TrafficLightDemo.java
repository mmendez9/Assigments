package p1;

/*
 * Created by mmendez9 on 4/5/2016.
 * Traffic Light Demo
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
        circle[0].setFill(Color.RED);

        circle[1] = new Circle();
        circle[1].setRadius(50);
        circle[1].setStroke(Color.BLACK);
        circle[1].setFill(Color.YELLOW);

        circle[2] = new Circle();
        circle[2].setRadius(50);
        circle[2].setStroke(Color.BLACK);
        circle[2].setFill(Color.GREEN);

        // Create a VBox pane for the circles
        VBox pane = new VBox(20);
        pane.setStyle("-fx-background-color: grey");
        pane.setPadding(new Insets(20));
        pane.getChildren().addAll(circle[0], circle[1], circle[2]);

        // Create the scene for the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
