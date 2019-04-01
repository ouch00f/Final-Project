package sample;

import java.io.IOException;

public class Squidward extends Character {

    public Squidward(double initialX, double initialY) throws IOException {
        super(initialX,initialY,5,(short)5,(byte)-1);//initially facing left with the attributes called into the super
    }
}
