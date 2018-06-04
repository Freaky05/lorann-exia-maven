package view;

import javax.swing.*;
import java.awt.*;

public class BoneVertical extends Block{
    Image bonevertical;
    /**
     * |#################|
     * |constructor bone |
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public BoneVertical(int Startx, int Starty){

        this.x = Startx;
        this.y = Starty;

        ImageIcon iboneverticalImg = new ImageIcon("sprites/vertical_bone.png");
        bonevertical= iboneverticalImg.getImage();
    }
    /**
     * |###################################|
     * |define an image for BoneVertical   |
     * |@return Bonevertical		  	    |
     * |###################################|
     */
    public Image getImage(){
        return bonevertical;
    }
}