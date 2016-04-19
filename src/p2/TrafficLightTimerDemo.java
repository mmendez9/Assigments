package p2;

/*
 * Mayra Mendez
 * CIS 150-401
 * Traffic Light Simulator (red light 10s, yellow light 2s, green light 15s)
 */


import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TrafficLightTimerDemo extends Application{
    // Initialize three circles in the array
    private Circle[] circle = new Circle[3];

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Circle for the red light
        circle[0] = new Circle();
        circle[0].setRadius(50);
        circle[0].setStroke(Color.BLACK);
        circle[0].setFill(Color.WHITE);

        // Circle for the yellow light
        circle[1] = new Circle();
        circle[1].setRadius(50);
        circle[1].setStroke(Color.BLACK);
        circle[1].setFill(Color.WHITE);

        // Circle for the green light
        circle[2] = new Circle();
        circle[2].setRadius(50);
        circle[2].setStroke(Color.BLACK);
        circle[2].setFill(Color.GREEN);

        // Create a VBox pane for the circles
        Pane vBox = new VBox(20);
        vBox.setStyle("-fx-border-radius: 20; -fx-background-radius: 20; " +
                "-fx-border-color: black; -fx-background-color: black");
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(circle[0], circle[1], circle[2]);

        // Create a pane for the vBox
        GridPane pane = new GridPane();
        pane.setPrefHeight(300);
        pane.setPrefWidth(100);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(vBox);

        // Create the scene for the panes
        Scene scene = new Scene(pane, 250, 450);
        primaryStage.setTitle("Traffic Light");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create an animation for the 3 circles
        Timeline animation1 = new Timeline(new KeyFrame(Duration.seconds(15), GreenToYellow));
        animation1.setCycleCount(1);

        Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(2), YellowToRed));
        animation2.setCycleCount(1);

        Timeline animation3 = new Timeline(new KeyFrame(Duration.seconds(10), RedToGreen));
        animation3.setCycleCount(1);

        // Create a sequential animation for the 3 animations
        SequentialTransition animation = new SequentialTransition(animation1, animation2, animation3);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    // Event to change from green to yellow
    private EventHandler<ActionEvent> GreenToYellow = e -> {
        if (circle[2].getFill() == Color.GREEN) {
            circle[2].setFill(Color.WHITE);
            circle[1].setFill(Color.YELLOW);
            circle[0].setFill(Color.WHITE);
        } else {
            circle[2].setFill(Color.GREEN);
            circle[1].setFill(Color.WHITE);
            circle[0].setFill(Color.WHITE);
        }
    };

    // Event to change from yellow to red
    private EventHandler<ActionEvent> YellowToRed = e1 -> {
        if (circle[1].getFill() == Color.YELLOW) {
            circle[1].setFill(Color.WHITE);
            circle[0].setFill(Color.RED);
            circle[2].setFill(Color.WHITE);
        } else {
            circle[1].setFill(Color.YELLOW);
            circle[0].setFill(Color.WHITE);
        }
    };

    // Event to change from red to green
    private EventHandler<ActionEvent> RedToGreen = e2 -> {
        if (circle[0].getFill() == Color.RED) {
            circle[0].setFill(Color.WHITE);
            circle[1].setFill(Color.WHITE);
            circle[2].setFill(Color.GREEN);
        } else {
            circle[0].setFill(Color.RED);
            circle[2].setFill(Color.WHITE);
        }
    };

}
