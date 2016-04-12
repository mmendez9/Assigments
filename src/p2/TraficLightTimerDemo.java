package p2;

/*
 * Created by mmendez9 on 4/5/2016.
 */


import javafx.animation.KeyFrame;
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


public class TraficLightTimerDemo extends Application{
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
        circle[2].setFill(Color.GREEN.brighter());

        // Create a VBox pane for the circles
        Pane vBox = new VBox(20);
        vBox.setStyle("-fx-border-color: black; -fx-background-color: white");
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

        EventHandler<ActionEvent> eventHandler = e -> {
            /*if (circle[0].getFill() == Color.RED) {
                circle[0].setFill(Color.DARKRED.darker());
                circle[1].setFill(Color.YELLOW.darker().darker());
                circle[2].setFill(Color.GREEN.brighter());
            } else {
                circle[0].setFill(Color.RED);
                circle[2].setFill(Color.DARKGREEN.darker());
            }*/

            /*if (circle[1].getFill() == Color.YELLOW) {
                circle[1].setFill(Color.YELLOW.darker().darker());
                circle[0].setFill(Color.RED);
                circle[2].setFill(Color.DARKGREEN.darker());
            } else {
                circle[1].setFill(Color.YELLOW);
                circle[0].setFill(Color.DARKRED.darker());
            }*/

            if (circle[2].getFill() == Color.GREEN) {
                circle[2].setFill(Color.WHITE);
                circle[1].setFill(Color.YELLOW);
                circle[0].setFill(Color.WHITE);
            } else {
                circle[2].setFill(Color.GREEN);
                circle[1].setFill(Color.WHITE);
            }
        };

        // Create an animation to trigger an event every half-second
        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}
