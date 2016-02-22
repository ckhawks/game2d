package com.ckhawks.toaster.game2d;

import java.awt.*;

public class MovingBox extends GameObject {

    protected int dx, dy = 0; // position

    protected int width;
    protected int height;

    public int decelerate = 1; // accelerations / deceleration

    // riven x certified industrial industry standard code certification.

    public MovingBox(int xPos, int yPos, int width, int height){
        x = xPos;
        y = yPos;

        dx = 0;
        dy = 0;

        this.width = width;
        this.height = height;
    }

    public void update(){
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

        if(x + this.width > SettingsManager.getScreenWidth()){
            dx *= -1;
            x = SettingsManager.getScreenWidth() - this.width;
        }

        if(y + this.height > SettingsManager.getScreenHeight()){
            dy *= -1;
            y = SettingsManager.getScreenHeight() - this.height;
        }
    }

    @Override
    public void render(Graphics g) {
        g.fillRect(getX(), getY(), getSize().width, getSize().height);
    }


    // return size of box
    public Dimension getSize(){
        return new Dimension(this.width, this.height);
    }

}
