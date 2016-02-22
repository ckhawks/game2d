package com.ckhawks.toaster.game2d;

import com.sun.scenario.Settings;

import java.awt.*;
import java.util.Random;

/**
 * Created by Melted on 2/21/2016.
 */
public class EnemyBox extends MovingBox {

    private int targetX, targetY;
    private int speed = 3;

    public EnemyBox(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
        this.param1 = width;
        this.param2 = height;
        pickTargetPosition();
    }

    @Override
    public void update(){
        if(x > targetX){
            x -= speed;
        } else if(x < targetX){
            x += speed;
        }

        if(y > targetY){
            y -= speed;
        } else if(y < targetY){
            y += speed;
        }


        x += dx;
        y += dy;

        if(dx < 0){
            dy += decelerate;
            if(dx > 0){
                dx = 0;
            }
        } else {
            dx -= decelerate;
            if(dx < 0){
                dx = 0;
            }
        }

        if(dy < 0){
            dy += decelerate;
            if(dy > 0){
                dy = 0;
            }
        } else {
            dy -= decelerate;
            if(dy < 0){
                dy = 0;
            }
        }

        // check if it's going off the screen
        if(x < 0){
            dx *= -1;
            x = 0;
        }

        if(y < 0){
            dy *= -1;
            y = 0;
        }

        // check if it's at target
        double dist = (double) Math.sqrt(
                Math.pow(x - targetX, 2) +
                        Math.pow(y - targetY, 2) );
        if(dist < 3){
            pickTargetPosition();
        }

        if(x + this.param1 > SettingsManager.getScreenWidth()){
            dx *= -1;
            x = SettingsManager.getScreenWidth() - this.param1;
        }

        if(y + this.param2 > SettingsManager.getScreenHeight()) {
            dy *= -1;
            y = SettingsManager.getScreenHeight() - this.param2;
        }
    }

    public void pickTargetPosition(){
        Random r = new Random();
        setTargetPosition(r.nextInt(SettingsManager.getScreenHeight() - 20) + 10, r.nextInt(SettingsManager.getScreenWidth() - 20) + 10);
    }

    // set the planned destination of the enemy
    public void setTargetPosition(int goingTowardsX, int goingTowardsY){
        targetX = goingTowardsX;
        targetY = goingTowardsY;

        //this.param1 = goingTowardsX;
        //this.param2 = goingTowardsY;

    }

    // return destination of the bullet
    public Dimension getTargetPosition(){
        return new Dimension(targetX, targetY);
    }

    public void moveUp(){
        dy -= 3;
    }

    public void moveDown(){
        dy += 3;
    }

    public void moveLeft(){
        dx -= 3;
    }

    public void moveRight(){
        dx += 3;
    }
}
