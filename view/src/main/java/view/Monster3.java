package view;

import javax.swing.*;
import java.awt.*;

public class Monster3 extends Movable {
    Image Monster3;
    /**
     * |#################|
     * |constructor demon|
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public Monster3(int Startx, int Starty){
        x = Startx;
        y = Starty;

        ImageIcon iMonster3 = new ImageIcon("sprites/monster_3.png");
        Monster3 = iMonster3.getImage();
    }
    /**
     * |##########################|
     * |define an image for demon |
     * |@return Demon3		  	  |
     * |##########################|
     */
    public Image getImage(){
        return Monster3;
    }
}