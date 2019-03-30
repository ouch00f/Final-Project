package sample;
import javafx.scene.image.Image;


public class Shaggy extends Character {
    //Image standingRight = new Image();
    public Shaggy(){//Empty Constructor
        super(0,0,5, (short) 5,(byte) 1);
    }

    public Shaggy(double initialX, double initialY){//Default constructor
        super(initialX,initialY,5,(short)5,(byte)1);//initially facing right with the attributes called into the super
        //this.setImage(standingRight);
    }

}
