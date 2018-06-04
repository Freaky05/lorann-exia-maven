package view;

import javax.swing.*;
import java.awt.*;

public class Lorann extends Movable {

    Image LorannImg;
    ImageIcon iLorannDown = new ImageIcon("Images/lorann_b.png");

    public Lorann(int x, int y) {
        setX(x);
        setY(y);
    }

    public Image getImage() {
        LorannImg = iLorannDown.getImage();

        return LorannImg;
    }
}
