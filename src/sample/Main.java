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
    }
}
