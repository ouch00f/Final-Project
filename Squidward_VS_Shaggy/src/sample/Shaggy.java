package sample;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Shaggy extends Character {



    public Shaggy() throws IOException {//Empty Constructor
        super(0,0,5, (short) 5,(byte) 1);
    }
    public Shaggy(double initialX, double initialY) throws IOException {//Default constructor
        super(initialX,initialY,5,(short)5,(byte)1);//initially facing right with the attributes called into the super
        this.speed = 10;
        this.setFacingRight(true);
        this.standRight();

    }





}
