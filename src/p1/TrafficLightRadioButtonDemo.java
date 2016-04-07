package p1;

/*
 * Created by mmendez9 on 4/5/2016.
 * Traffic Light Demo
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLightRadioButtonDemo extends Application{

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
        vBox.setStyle("-fx-border-color: black; -fx-background-color: grey");
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(circle[0], circle[1], circle[2]);

        // Create radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        // Put the radio buttons in a group
        ToggleGroup tg1 = new ToggleGroup();
        rbRed.setToggleGroup(tg1);
        rbYellow.setToggleGroup(tg1);
        rbGreen.setToggleGroup(tg1);

        // Create a HBox for the radio buttons
        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: grey");
        hBox.setPadding(new Insets(20));
        hBox.getChildren().addAll(rbRed, rbYellow, rbGreen);

        // Create a pane for the vBox
        GridPane pane1 = new GridPane();
        pane1.setPrefHeight(300);
        pane1.setPrefWidth(100);
        pane1.setAlignment(Pos.CENTER);
        pane1.getChildren().addAll(vBox,hBox);

        // Create a pane for the hBox
        GridPane pane2 = new GridPane();
        pane2.setPrefHeight(100);
        pane2.setPrefWidth(150);
        pane2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(hBox);

        // Border pane
        BorderPane pane = new BorderPane();
        pane.setTop(pane1);
        pane.setCenter(pane2);

        // Create the scene for the panes
        Scene scene = new Scene(pane, 250, 450);
        primaryStage.setTitle("Traffic Light");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        EventHandler<ActionEvent> eventHandler = e -> {
            if (rbRed.isSelected()) {
                circle[0].setFill(Color.RED);
                circle[1].setFill(Color.WHITE);
                circle[2].setFill(Color.WHITE);
            }
            else if (rbYellow.isSelected()) {
                circle[1].setFill(Color.YELLOW);
                circle[0].setFill(Color.WHITE);
                circle[2].setFill(Color.WHITE);
            }
            else if (rbGreen.isSelected()) {
                circle[2].setFill(Color.GREEN);
                circle[0].setFill(Color.WHITE);
                circle[1].setFill(Color.WHITE);
            }
        };

        rbRed.setOnAction(eventHandler);
        rbYellow.setOnAction(eventHandler);
        rbGreen.setOnAction(eventHandler);
    }
}
