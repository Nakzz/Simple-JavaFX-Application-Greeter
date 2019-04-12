package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Title: JavaFX Application Course: CS400, Spring 2019 Author: Ajmain Naqib Email: naqib@wisc.edu
 * Lecturer's Name: Deb Deppeler
 * 
 */

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      // Label greetingLabel = new Label("Hello World!");
      Label projectLabel = new Label("CS400 MyFirstJavaFX");

      // Weekdays
      String week_days[] = {"Monday", "Tuesday", "Wednesday", "Thrusday", "Friday"};

      // Create a combo box
      ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(week_days));


      // load the image
      Image image = new Image("aj.jpg");

      // simple displays ImageView the image as is
      ImageView iv1 = new ImageView();
      iv1.setImage(image);
      iv1.setFitWidth(150);
      iv1.setPreserveRatio(true);
      iv1.setSmooth(true);
      iv1.setCache(true);

      // create a button
      Button b = new Button("Done");

      // create a text field
      TextField textField = new TextField();
      textField.setText("Enter your Name");
      textField.setMaxWidth(150);

      // create a label
      Text l =
        new Text(20, 50, "Pick a day from checkdown box and enter your name in the text field");

      l.setWrappingWidth(200);

      // action event
      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
          if (textField.getText().equalsIgnoreCase("Enter your Name")) {
            l.setText("Please enter your name!");
          } else if (combo_box.getValue() == null) {
            l.setText("Please pick a day from checkdown box");
          } else {
            l.setText("Hello " + textField.getText() + "! Happy " + combo_box.getValue() + "!");
          }
        }
      };

      // when enter is pressed
      b.setOnAction(event);

      BorderPane hbox = new BorderPane();
      // hbox.getChildren().addAll(textField, l);

      hbox.setTop(textField);
      hbox.setBottom(l);


      primaryStage.setTitle("AJ's Greeter JavaFX program");

      BorderPane root = new BorderPane();

      root.setTop(projectLabel);
      root.setLeft(combo_box);
      root.setCenter(iv1);
      root.setBottom(b);
      root.setRight(hbox);

      Scene scene = new Scene(root, 400, 400);

      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
