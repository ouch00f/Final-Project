package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("");
        Scene scene = new Scene(root, 800, 450);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //Key event filters
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {//key press controls
            keyPress(keyEvent.getCode());
        });

        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {//key press controls
            keyRelease(keyEvent.getCode());
        });


        //Items to add to primaryStage
        Group group = new Group();
        Shaggy SHAGGY = new Shaggy(0,0);
        Squidward SQUIDWARD = new Squidward(0,150);
        group.getChildren().add(SHAGGY);
        group.getChildren().add(SQUIDWARD);
    }

    public void keyPress(KeyCode keycode){//when keys are pressed

    }

    public void keyRelease(KeyCode keycode){//when keys are released

    }


    public static void main(String[] args) {
        launch(args);
        connect();
    }


    private static final String insertSQL = "INSERT INTO HighScores(dmgDealt) VALUES(newScore)";
    private static final int newScore = 0;
    private static final String url = "jdbc:sqlite:/Users/rain/Desktop/Final-Project-master/master.db";

    // Connection method, perhaps replaced with built in database tool(?)
    public static void connect() {
        Connection conn = null;
        try {

            //String url = "jdbc:sqlite:/Users/rain/Desktop/Squidward_VS_Shaggy/master.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Connection established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    // insert method that currently does not work
    public void insert(int score){
        try{
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement statement = conn.prepareStatement(insertSQL);
            statement.setInt(1, score);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void newScore(int oldScore, int newScore){
        if (newScore > oldScore) {
            insert(newScore);
        }
    }
}



