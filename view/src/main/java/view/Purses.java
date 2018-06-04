package view;

import javax.swing.*;
import java.awt.*;

public class Purses extends Block {
    Image Purses;
    /**
     * |##################|
     * |constructor Purses|
     * |@param Startx	  |
     * |@param Starty	  |
     * |##################|
     */
    public Purses(int Startx, int Starty){
        x = Startx;
        y = Starty;

        ImageIcon iPurses = new ImageIcon("sprites/purse.png");
        Purses = iPurses.getImage();
    }
    /**
     * |##########################|
     * |define an image for Purses|
     * |@return Purses		  	  |
     * |##########################|
     */
    public Image getImage(){
        return Purses;
    }
}
