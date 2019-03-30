package sample;

public class Squidward extends Character {

    public Squidward(){//empty constructor

    }

    public Squidward(double initialX, double initialY){
        super(initialX,initialY,5,(short)5,(byte)-1);//initially facing left with the attributes called into the super
    }
}
