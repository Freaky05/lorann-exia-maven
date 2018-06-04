package view;

import javax.swing.*;
import java.awt.*;

public class CrystalBall extends Block {
    Image CrystalBall;
    /**
     * |#####################|
     * |constructor magicball|
     * |@param Startx	 	 |
     * |@param Starty	 	 |
     * |#####################|
     */
    public CrystalBall(int Startx, int Starty ){
        x = Startx;
        y = Starty;

        ImageIcon iCrystalBall = new ImageIcon("sprites/crystal_ball.png");
        CrystalBall = iCrystalBall.getImage();
    }
    /**
     * |##################################|
     * |define an image for the magicball |
     * |@return Magicball			  	  |
     * |##################################|
     */
    public Image getImage(){
        return CrystalBall;
    }
}
