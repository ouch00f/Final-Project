package sample;
import java.io.IOException;

public class Shaggy extends Character {
    public Shaggy(double initialX, double initialY) throws IOException {//Default constructor
        super(initialX,initialY,5,5);//initially facing right with the attributes called into the super
        this.speed = 10;
        this.setFacingRight(true);
        this.standRight();
        this.setWidth(10);
        this.setHeight(10);
    }
}
