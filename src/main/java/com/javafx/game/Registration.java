package com.javafx.game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.IOException;
// import javafx.scene.media.Media;
// import javafx.scene.media.MediaPlayer;
import java.nio.file.Paths;

public class Registration extends Application {

    private Scene mainScene; // Store the main scene to switch back to it later

    @Override
    public void start(Stage stage) throws Exception 
    {
        Image introImage = new Image(getClass().getResourceAsStream("first_image.jpg"));
        ImageView introImageView = new ImageView(introImage);
        introImageView.setFitWidth(2000);
        introImageView.setPreserveRatio(true);


        StackPane introStackPane = new StackPane();
        introStackPane.getChildren().add(introImageView);


        Scene introScene = new Scene(introStackPane, 1600, 800);


        stage.setTitle("Welcome to Stick Hero!");
        stage.setScene(introScene);
        stage.show();


        mainScene = introScene;


        introImageView.setOnMouseClicked(event -> showRegistrationForm(stage));
    }

    public void showRegistrationForm(Stage stage) 
    {

        Label titleLabel = new Label("Player Registration");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setTextFill(Color.WHITE);


        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();


        Label dobLabel = new Label("Date of Birth");
        DatePicker datePicker = new DatePicker();


        Label genderLabel = new Label("Gender");
        ToggleGroup genderToggleGroup = new ToggleGroup();

        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderToggleGroup);

        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderToggleGroup);


        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        registerButton.setOnAction(event -> {

            showPanel(stage);
            System.out.println("Registration logic goes here!");
        });


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(dobLabel, 0, 2);
        gridPane.add(datePicker, 1, 2);
        gridPane.add(genderLabel, 0, 3);
        gridPane.add(maleRadio, 1, 3);
        gridPane.add(femaleRadio, 2, 3);
        gridPane.add(registerButton, 1, 4);

        Scene registrationScene = new Scene(gridPane, 1600, 800);
        stage.setTitle("Player Registration");
        stage.setScene(registrationScene);
        stage.show();
    }

    private void showPanel(Stage stage) 
    {

        Button playGameButton = new Button("Play Game");
        Button highScoresButton = new Button("High Scores");

        playGameButton.setOnMouseClicked(event -> handlePlayGameButtonClick(stage));
        highScoresButton.setOnMouseClicked(event -> handleHighScoresButtonClick(stage));


        VBox buttonPanel = new VBox(10); // 10 is the spacing between buttons
        buttonPanel.getChildren().addAll(playGameButton, highScoresButton);
        buttonPanel.setAlignment(Pos.CENTER);


        Image backgroundImage = new Image(getClass().getResourceAsStream("actual_bg.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);


        StackPane panelStackPane = new StackPane();
        panelStackPane.setBackground(new Background(background));
        panelStackPane.getChildren().add(buttonPanel);

        Scene panelScene = new Scene(panelStackPane, 1600, 800);

        stage.setScene(panelScene);
        stage.setTitle("Game Panel");
        stage.show();
    }

    private void handlePlayGameButtonClick(Stage stage) 
    {
        // Load and display an image [choice 1]
        // Image gameImage = new Image(getClass().getResourceAsStream("gameplay_screen.jpeg"));
        // ImageView imageView = new ImageView(gameImage);
        // imageView.setFitHeight(800); // Adjust the size as needed
        // imageView.setFitWidth(1600);
        // imageView.setPreserveRatio(true);
        // StackPane imagePane = new StackPane(imageView);
        // Scene imageScene = new Scene(imagePane, 1600, 800);
        // imageView.setOnMouseClicked(event -> {
        //     // mediaPlayer.stop(); // Stop the audio when the image is clicked
        //     showEndScreen(stage);
        // });
        // stage.setScene(imageScene);
        // stage.setTitle("Game Image");
        // stage.show();

        // Loading an fxml scene [choice 2]
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameplay_screen.fxml"));
            Parent root = loader.load();
            Scene gameScene = new Scene(root, 1600, 800);
            stage.setScene(gameScene);
            stage.setTitle("Game Screen");
            stage.show();  

            gameScene.setOnMouseClicked(event -> {
            // mediaPlayer.stop(); // Stop the audio when the image is clicked
            showEndScreen(stage);
            });
        } 
        catch (IOException e) 
        {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }   
    
        // Set a click listener on the image to go to the end screen

    
        // Load and play audio
        // String audioPath = getClass().getResource("game_audio.mp3").toExternalForm();
        // Media media = new Media(audioPath);
        // MediaPlayer mediaPlayer = new MediaPlayer(media);
        // mediaPlayer.play();
    
        // Set the scene to the stage

    
    

    ///////////////////////////////////////////////////////////////////////////////
    private void showEndScreen(Stage stage) {

        int currentScore = 500;


        VBox endScreenBox = new VBox(10);
        endScreenBox.setAlignment(Pos.CENTER);

        Text scoreText = new Text("Score: " + currentScore);
        Text highestScoreText = new Text("Highest Score: " + getHighestScore());


        endScreenBox.getChildren().addAll(scoreText, highestScoreText);


        Button replayButton = new Button("Replay");
        replayButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        replayButton.setOnAction(event -> handleReplayButtonClick(stage));

        // Adding the replay button to the VBox
        endScreenBox.getChildren().add(replayButton);


        Scene endScreenScene = new Scene(endScreenBox, 1600, 800);


        stage.setScene(endScreenScene);
        stage.setTitle("End Screen");
        stage.show();
    }

    private int getHighestScore() {

        return 800;
    }

    private void handleReplayButtonClick(Stage stage) {

        handlePlayGameButtonClick(stage);
    }

    private void goToPanel(Stage stage)
    {
        showPanel(stage);
    }

    private void handleHighScoresButtonClick(Stage stage) {

        Image backgroundImage = new Image(getClass().getResourceAsStream("actual_bg.jpg"));

        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1600);
        backgroundImageView.setFitHeight(800);


        VBox highScoresBox = new VBox(10);
        highScoresBox.setAlignment(Pos.CENTER);


        Text highScoresText = new Text("High Scores:\n1. 800\n2. 950\n3. 800\n4. 700\n5. 500");
        highScoresText.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        highScoresText.setFill(Color.TEAL);

        Button Back = new Button("Back");
        Back.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Back.setOnAction(event -> goToPanel(stage));
        highScoresBox.getChildren().add(Back);

        highScoresBox.getChildren().add(highScoresText);


        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundImageView, highScoresBox);


        Scene highScoresScene = new Scene(stackPane, 1600, 800);


        stage.setScene(highScoresScene);
        stage.setTitle("High Scores");
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}