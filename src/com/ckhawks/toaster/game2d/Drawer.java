package com.ckhawks.toaster.game2d;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Drawer extends JComponent implements Runnable, KeyListener, MouseListener {

    public boolean running;
    private ObjectManager om;

    public Drawer(){
        running = true;

        addKeyListener(this);
        addMouseListener(this);
    }

    // main rendering loop
    @Override
    public void run() {
        while (running){
            try {
                Thread.sleep(1000/60);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // for painting pretty pictures
    public void paintComponent(Graphics g){

        // do the draw pretty pictures
        g.setColor(Color.BLACK);

        // loop through objects, draw each depending on it's shape type
        // only run if it's not in use
        if(om.isAvailable()) {
            om.acquire();
            for (MovingObject object : om.allYourObjectsAreBelongToMe()) {
                //System.out.println(object);
                //if(object.getShape() != 666){
                //    System.out.println(object.getShape());
                //}
                switch (object.getShape()) {
                    case MovingObject.drawLine:
                        // Drawing line from object position to param1, param2.
                        //System.out.println("Bullet from (" + object.getX() + ", " + object.getY() + ") to (" + object.getParameter1() + ", " + object.getParameter2() + ").");
                        g.drawLine(object.getX(), object.getY(), object.getParameter1(), object.getParameter2());
                        break;
                    case MovingObject.fillRect:
                        g.fillRect(object.getX(), object.getY(), object.getParameter1(), object.getParameter2());
                        break;
                }
            }
            om.release();
        }

    }

    // connect object manager to drawer
    public void connectObjectManager(ObjectManager om){
        this.om = om;
    }

    // whenever Mouse is clicked, send to object manager
    @Override
    public void mouseClicked(MouseEvent e) {
        om.mousePressed(e);
    }

    // whenever keyboard is pressed, send to object manager
    @Override
    public void keyPressed(KeyEvent e) {
        om.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
