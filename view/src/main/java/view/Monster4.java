package view;

import javax.swing.*;
import java.awt.*;

public class Monster4 extends Movable {
    Image Monster4;
    /**
     * |#################|
     * |constructor demon|
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public Monster4(int Startx, int Starty){
        x = Startx;
        y = Starty;

        ImageIcon iMonster4 = new ImageIcon("sprites/monster_4.png");
        Monster4 = iMonster4.getImage();
    }
    /**
     * |##########################|
     * |define an image for demon |
     * |@return Demon4		  	  |
     * |##########################|
     */
    public Image getImage(){
        return Monster4;
    }
}