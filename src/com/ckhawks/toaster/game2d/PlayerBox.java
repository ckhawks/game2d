package com.ckhawks.toaster.game2d;

import java.awt.event.KeyEvent;

/**
 * Created by Melted on 2/19/2016.
 */
public class PlayerBox extends MovingBox {

    public PlayerBox(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
    }

    public void keyPress(int id){
        switch(id){
            case KeyEvent.VK_W: moveUp(); break;
            case KeyEvent.VK_S: moveDown(); break;
            case KeyEvent.VK_A: moveLeft(); break;
            case KeyEvent.VK_D: moveRight(); break;
        }
    }

    public void moveUp(){
        dy -= 4;
    }

    public void moveDown(){
        dy += 4;
    }

    public void moveLeft(){
        dx -= 4;
    }

    public void moveRight(){
        dx += 4;
    }


}
