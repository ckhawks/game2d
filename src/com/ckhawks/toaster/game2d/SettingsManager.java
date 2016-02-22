package com.ckhawks.toaster.game2d;

// TODO change to use dictionary, accessors call to dictionary for setting name
// ex. SettingsManager.getSetting("WIDTH") returns 1920

/**
 * Created by Melted on 2/21/2016.
 */
public class SettingsManager {

    public static int WIDTH, HEIGHT;

    public SettingsManager(){
        // read from final

        WIDTH = 500;
        HEIGHT = 500;
    }

    public static int getScreenHeight(){
        return HEIGHT;
    }

    public static int getScreenWidth(){
        return WIDTH;
    }

}
