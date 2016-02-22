package com.ckhawks.toaster.game2d;

import java.awt.*;

public class Bullet extends GameObject {

    public int x, y, dx, dy = 0; // position

    private int targetX, targetY;
    private int width, length; // size of bullet box

    private int speed = 30;

    public Bullet(int xPos, int yPos, int width, int length){
        this.x = xPos;
        this.y = yPos;

        dx = 0;
        dy = 0;

        this.width = width;
        this.length = length;

        System.out.println("Bullet created at " + x + ", " + y);
    }

    @Override
    public void update() {

        x -= dx / speed;
        y -= dy / speed;

        int delta = speed;

        if (Math.abs(x - targetX) < delta && Math.abs(y - targetY) < delta) {
            // moving = false;
            // remove
        }
    }

    @Override
    public void render(Graphics g) {
        //System.out.println("Bullet from (" + object.getX() + ", " + object.getY() + ") to (" + object.getParameter1() + ", " + object.getParameter2() + ").");
        g.drawLine(getX(), getY(), getParameter1(), getParameter2());
        g.fillRect(getX(), getY(), width, length);
    }

    // set the planned destination of the bullet
    public void setTargetPosition(int goingTowardsX, int goingTowardsY){
        targetX = goingTowardsX;
        targetY = goingTowardsY;

        // ???
        //dx = this.x - this.x;
        //dy = this.y - this.y;

        // moving = true;
        this.param1 = goingTowardsX;
        this.param2 = goingTowardsY;

    }

    // return destination of the bullet
    public Dimension getTargetPosition(){
        return new Dimension(targetX, targetY);
    }

    // return size of bullet
    public Dimension getSize(){
        return new Dimension(this.width, this.length);
    }

    @Override
    public int getX(){
        return this.x;
    }

    @Override
    public int getY(){
        return this.y;
    }

    // return the drawing shape of the bullet
    @Override
    public int getShape() {
        return GameObject.drawLine;
    }

    @Override
    public String toString(){
        return "Bullet at " + this.x + ", " + this.y + " heading towards " + targetX + ", " + targetY + ".";
    }
}
