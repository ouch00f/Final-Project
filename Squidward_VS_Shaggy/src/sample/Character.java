package sample;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public abstract class Character extends HBox {
    //Fields
    protected float speed, jumpConstant;

    protected boolean isBlocking, falling, facingRight;
    protected int health;


    //Cgaracter images to load into ImageView
    File sourceimage[] = {new File("C:\\Users\\muonn\\IdeaProjects\\Squidward_VS_Shaggy\\src\\resources\\images\\characterStandingRight.png"),
            new File("C:\\Users\\muonn\\IdeaProjects\\Squidward_VS_Shaggy\\src\\resources\\images\\characterStandingLeft.png"),
            new File("C:\\Users\\muonn\\IdeaProjects\\Squidward_VS_Shaggy\\src\\resources\\images\\characterRunningRight.png"),
            new File("C:\\Users\\muonn\\IdeaProjects\\Squidward_VS_Shaggy\\src\\resources\\images\\characterRunningLeft.png"),
            new File("C:\\Users\\muonn\\IdeaProjects\\Squidward_VS_Shaggy\\src\\resources\\images\\characterJumpingRight.png"),
            new File("C:\\Users\\muonn\\IdeaProjects\\Squidward_VS_Shaggy\\src\\resources\\images\\characterJumpingLeft.png")};
    protected Image standingRight, standingLeft, runningRight, runningLeft,jumpingRight,jumpingLeft;
    ImageView characterImage;




    public Character(double initialX, double initialY,float startingSpeed,short startingJumpConstant, byte startingDirection) throws IOException {//Constructor
        this.setLayoutX(initialX);
        this.setLayoutY(initialY);

        //Movement Images
        standingRight = SwingFXUtils.toFXImage((ImageIO.read(sourceimage[0])), null);
        standingLeft =  SwingFXUtils.toFXImage((ImageIO.read(sourceimage[1])), null);
        runningRight = SwingFXUtils.toFXImage((ImageIO.read(sourceimage[2])), null);
        runningLeft = SwingFXUtils.toFXImage((ImageIO.read(sourceimage[3])), null);
        jumpingRight = SwingFXUtils.toFXImage((ImageIO.read(sourceimage[4])), null);
        jumpingLeft =  SwingFXUtils.toFXImage((ImageIO.read(sourceimage[5])), null);

        characterImage = new ImageView();

        getChildren().add(characterImage);
    }


    //Actions
    public void standRight(){
        this.facingRight = true;
        characterImage.setImage(standingRight);
    }

    public void standLeft(){
        this.facingRight = false;
        characterImage.setImage(standingLeft);
    }

    public void runRight(){
        this.facingRight = true;
        characterImage.setImage(runningRight);
    }

    public void runLeft(){
        this.facingRight = false;
        characterImage.setImage(runningLeft);
    }

    public void jump(){
        if(facingRight) {
            characterImage.setImage(jumpingRight);
        }else{
            characterImage.setImage(jumpingLeft);
        }
    }

    public void takeHit(int damage){
        if(!this.isBlocking()) { //when this character is not blocking it then takes damage
            this.setHealth(this.getHealth()-damage);
        }
    }

    public void attack(Character opponent, int damage){
        opponent.takeHit(damage);
    }







    //Accessors and mutators

    public boolean isBlocking(){ return this.isBlocking;}

    public int getHealth(){return health;}

    public void setHealth(int newHealth){ this.health = newHealth;}





    public void setFacingRight(boolean newFacingRight){ this.facingRight = newFacingRight; }

    public boolean getFacingRight(){ return this.facingRight;}

    public void setBlocking(boolean newBlocking){ this.isBlocking = newBlocking; }

    public void setFalling(boolean newFalling){this.falling = newFalling;}

    public float getSpeed(){return speed;}

    public void setSpeed(float newSpeed){this.speed = newSpeed;}

    public float getJumpConstant(){return jumpConstant;}

    public void setJumpConstant(float newJumpConstant) {this.jumpConstant = newJumpConstant;}

}
