package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    Squidward SQUIDWARD = new Squidward(0,150);


    public Shaggy SHAGGY = new Shaggy(0,0);

    public Main() throws IOException {
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();

        primaryStage.setTitle("");
        Scene scene = new Scene(root, 800, 450);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        root.getChildren().add(SHAGGY);

        //Key event filters
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {//key press controls
            this.keyPress(keyEvent.getCode());
        });

        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {//key press controls
            this.keyRelease(keyEvent.getCode());
        });





    }

    public void keyPress(KeyCode keycode){//when keys are pressed
        switch(keycode){
            case W:
                SHAGGY.jump();
            case D:
                SHAGGY.runRight();
            case A:
                SHAGGY.runLeft();

        }
    }

    public void keyRelease(KeyCode keycode){//when keys are released

        switch (keycode){
            case D:
                SHAGGY.standRight();
            case A:
                SHAGGY.standLeft();

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
