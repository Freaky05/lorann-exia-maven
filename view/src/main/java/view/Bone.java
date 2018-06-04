package view;

import javax.swing.*;
import java.awt.*;

public class Bone extends Block {
    Image bone;
    /**
     * |#################|
     * |constructor bone |
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public Bone(int Startx, int Starty){

        this.x = Startx;
        this.y = Starty;

        ImageIcon iboneImg = new ImageIcon("sprites/bone.png");
        bone = iboneImg.getImage();
    }
    /**
     * |##########################|
     * |define an image for Bone  |
     * |@return Bone   		  	   |
     * |##########################|
     */
    public Image getImage(){
        return bone;
    }
}
