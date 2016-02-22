package com.ckhawks.toaster.game2d;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Melted on 2/19/2016.
 */
public class ObjectManager implements Runnable {

    private ArrayList<MovingObject> objects;

    private boolean availability;

    public ObjectManager(){
        objects = new ArrayList<MovingObject>();
        availability = true;
    }

    // add new object to
    public void addNewObject(MovingObject obj){
        // only run if it's not in use
        if(this.isAvailable()) {
            this.acquire();
            objects.add(obj);
            this.release();
        }
    }

    // called from drawer whenever keyboard is pressed
    public void keyPressed(int id){
        //System.out.println("OM Key press: " + id);
        for(MovingObject obj : objects){
            this.acquire();
            if(obj instanceof PlayerBox){
                ((PlayerBox) obj).keyPress(id);
            }
            this.release();
        }
    }

    // called from drawer whenever mouse is clicked
    public void mousePressed(MouseEvent e){
        int id = e.getButton();

        //System.out.println("OM Mouse press: " + id);
        if(id == MouseEvent.BUTTON1){
            // pew pew

            PlayerBox pb = null;

            // only run if it's not in use
            if(this.isAvailable()){
                this.acquire();
                for(MovingObject obj : objects){
                    if(obj instanceof PlayerBox){
                        pb = (PlayerBox) obj;
                    }
                }
                this.release();
            }

            if(pb != null){
                //System.out.println("PlayerBox pos is " + pb.getX() + ", " + pb.getY());
                Bullet b = new Bullet(pb.getX(), pb.getY(), 3, 3);
                b.setTargetPosition(e.getX(), e.getY());
                addNewObject(b);
            }

        } else if(id == MouseEvent.BUTTON2){
            // Middle mouse click
        } else if(id == MouseEvent.BUTTON3){
            // Right click
        }
    }

    // for looping through objects, used in drawer
    public ArrayList<MovingObject> allYourObjectsAreBelongToMe(){
        return objects;
    }

    public void acquire(){
        this.availability = false;
    }

    public void release(){
        this.availability = true;
    }

    public boolean isAvailable(){
        return availability;
    }

    // main object loop
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000 / 60);

                // update each object 60 times per second
                if(this.isAvailable()){
                    this.acquire();
                    for(MovingObject object : objects){
                        object.update();
                    }
                    this.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
