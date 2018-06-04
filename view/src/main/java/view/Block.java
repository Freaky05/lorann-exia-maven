package view;

import java.awt.*;

public class Block {
    int x,y;

    public Rectangle getBounds(){
        Rectangle Box = new Rectangle(x,y,ViewFacade.mySize,ViewFacade.mySize);
        return Box;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

