package view;

import javax.swing.*;
import java.awt.*;

public class Monster2 extends Movable {
    Image Monster2;
    /**
     * |#################|
     * |constructor demon|
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public Monster2(int Startx, int Starty){
        x = Startx;
        y = Starty;

        ImageIcon iMonster2 = new ImageIcon("sprites/monster_2.png");
        Monster2 = iMonster2.getImage();
    }
    /**
     * |##########################|
     * |define an image for demon |
     * |@return Demon2		  	  |
     * |##########################|
     */
    public Image getImage(){
        return Monster2;
    }
}
