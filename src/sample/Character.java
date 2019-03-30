package sample;
import javafx.scene.image.ImageView;

public abstract class Character extends ImageView {
    //Fields
    protected float speed, jumpConstant;
    protected byte direction;
    protected boolean isBlocking, falling;
    protected int health;
    static final byte RIGHT_DIRECTION = 1;//Important: do not modify this unless the coordinate system is mirrored backwards on the x axis for some reason


    public Character(){//primary constructor
        this.speed = 1;
        this.jumpConstant = 1;
        this.direction = 1;

    }

    public Character(double initialX, double initialY,float startingSpeed,short startingJumpConstant, byte startingDirection){

    }


    //Actions
    public void faceRight(){//all x-axis movement is multiplied by the direction facing
        this.direction = this.RIGHT_DIRECTION;
    }

    public void faceLeft(){
        this.direction = (byte) -this.RIGHT_DIRECTION; //all x-axis movement is multiplied by the direction facing
    }

    public void takeHit(int damage){
        if(!this.isBlocking()) { //when this character is not blocking it then takes damage
            this.setHealth(this.getHealth()-damage);
        }
    }


    public void jump(){
        this.setY(jumpConstant);
        this.setFalling(true);
    }

    public void move(){
        this.setX((this.getX() + this.speed)*direction);
    }

    public void attack(Character opponent, int damage){
        opponent.takeHit(damage);
    }

    //Functional properties
    protected boolean isFacingRight(){//boolean request if the character is facing right (true if right)
        return this.direction == this.RIGHT_DIRECTION;
    }

    protected boolean isFacingLeft(){//boolean request if the character is facing left (true if left)
        return !this.isFacingRight();
    }



    //Accessors and mutators

    public boolean isBlocking(){ return this.isBlocking;}

    public void setBlocking(boolean newBlocking){ this.isBlocking = newBlocking; }

    public void setFalling(boolean newFalling){this.falling = newFalling;}


    public int getHealth(){return health;}

    public void setHealth(int newHealth){ this.health = newHealth;}

    public float getSpeed(){return speed;}

    public void setSpeed(float newSpeed){this.speed = newSpeed;}

    public float getJumpConstant(){return jumpConstant;}

    public void setJumpConstant(float newJumpConstant) {this.jumpConstant = newJumpConstant;}

}
