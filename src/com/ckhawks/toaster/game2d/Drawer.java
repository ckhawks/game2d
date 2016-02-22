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
            for (GameObject object : om.getObjects()) {

                object.render(g);

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

    //
    //     UNUSED INPUT FUNCTIONS
    //

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
