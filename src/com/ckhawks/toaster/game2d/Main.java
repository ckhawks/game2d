
// TODO remove loop from object (box)
// TODO have new update thread

package com.ckhawks.toaster.game2d;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static void main(String[] args) {


        // set up the window and all that shit
        JFrame window = new JFrame("RivenGame2d");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(WIDTH + 30, HEIGHT + 30));
        window.setResizable(false);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(screenSize.width / 2 - window.getWidth() / 2,
                screenSize.height / 2 - window.getHeight() / 2);

        // start drawing thingy
        Drawer d = new Drawer();
        Thread drawer = new Thread(d);
        drawer.start();

        window.addKeyListener(d);

        // create a new new new

        ObjectManager om = new ObjectManager();
        d.connectObjectManager(om);

        Thread omThread = new Thread(om);
        omThread.start();

        SettingsManager sm = new SettingsManager();

        MovingObject box = new PlayerBox(WIDTH / 2, HEIGHT / 2, 16, 32);
        om.addNewObject(box);

        MovingObject enemy = new EnemyBox(10, 10, 20, 20);
        om.addNewObject(enemy);

        // add drawer thingy to thingy thing
        window.add(d);
        d.setPreferredSize(new Dimension(SettingsManager.getScreenWidth(), SettingsManager.getScreenHeight()));
        window.pack();
        window.setVisible(true);
        window.setFocusable(true);
        window.requestFocusInWindow();


        // required console output
        System.out.println("Dank memes r hot");
    }
}
