package view;

import javax.swing.*;
import java.awt.*;

public class Gate {
    int x,y;

    Image Door;
    /**
     * |######################################|
     * |define the door's state and her image |
     * |######################################|

     */
    String State = "CLOSED";
    ImageIcon iDoor = new ImageIcon("sprites/gate_closed.png");
    ImageIcon iDoorOpen = new ImageIcon("sprites/gate_open.png");

    /**
     * |#################|
     * |constructor door |
     * |@param Startx	 |
     * |@param Starty	 |
     * |#################|
     */
    public Gate (int Startx, int Starty){
        x = Startx;
        y = Starty;

    }

    public int getX() {
        return x;
    }
    /**
     * |##########################|
     * |define position x and y   |
     * |@return X and Y		  	  |
     * |##########################|
     */
    public int getY() {
        return y;
    }
    /**
     * |##########################|
     * |define position hitbox    |
     * |@return box			  	  |
     * |##########################|
     */
    public Rectangle getBounds() {
        Rectangle Box = new Rectangle(x,y,32,32);
        return Box;
    }
    /**
     * |####################################|
     * |define position state of the door   |
     * |@return state		  		  	    |
     * |####################################|
     * @return
     */
    public String getEtat() {
        return State;
    }

    public void setEtat (String newState){
        this.State = newState;
    }
    /**
     * |##########################|
     * |switch door's Image       |
     * |@return Door		  	  |
     * |##########################|
     */
    public Image getImage(){
        if(State == "CLOSED"){
            Door = iDoor.getImage();
        }
        else if (State == "OPEN"){
            Door = iDoorOpen.getImage();
        }
        return Door;

    }
}
