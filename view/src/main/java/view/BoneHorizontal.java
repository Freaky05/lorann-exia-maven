package view;

import javax.swing.*;
import java.awt.*;

public class BoneHorizontal extends Block{
    Image bonehorizontal;
    /**
     * |#################|
     * |constructor bone |
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public BoneHorizontal(int Startx, int Starty){

        this.x = Startx;
        this.y = Starty;

        ImageIcon ibonehorizontalImg = new ImageIcon("sprites/horizontal_bone.png");
        bonehorizontal= ibonehorizontalImg.getImage();
    }
    /**
     * |###################################|
     * |define an image for BoneHorizontal |
     * |@return Bonehorizontal		  	    |
     * |###################################|
     */
    public Image getImage(){
        return bonehorizontal;
    }
}
