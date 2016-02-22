package com.ckhawks.toaster.game2d;

import java.awt.*;

public abstract class GameObject {

    protected int x, y; // position of object

    // updates 60 times per second
    public abstract void update();

    // rendering logic, updated 60 times per second
    public abstract void render(Graphics g);

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
