package view;

import javax.swing.*;
import java.awt.*;

public class Monster1 extends Movable {
    Image Monster1;
    /**
     * |#################|
     * |constructor demon|
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public Monster1(int Startx, int Starty){
        x = Startx;
        y = Starty;

        ImageIcon iMonster1 = new ImageIcon("sprites/monster_1.png");
        Monster1 = iMonster1.getImage();
    }
    /**
     * |##########################|
     * |define an image for demon |
     * |@return Demon1		  	  |
     * |##########################|
     */
    public Image getImage(){
        return Monster1;
    }
}
