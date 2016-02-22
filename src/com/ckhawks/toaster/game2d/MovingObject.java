package com.ckhawks.toaster.game2d;

/**
 * Created by Melted on 2/19/2016.
 */
public abstract class MovingObject {

    protected int x, y; // position of object
    protected int param1, param2, param3, param4;

    // unique identifiers for each type of drawing method
    public static final int fillRect = 666;
    public static final int drawLine = 420;

    // updates 60 times per second
    public abstract void update();

    // returns identifier of the shape of the crap
    public abstract int getShape();

    // used for drawing arguments
    public int getParameter1(){
        return param1;
    }

    public int getParameter2(){
        return param2;
    }

    public int getParameter3(){
        return param3;
    }

    public int getParameter4(){
        return param4;
    }

    // get position of moving object
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString(){
        return "Object at " + x + ", " + y;
    }

}
