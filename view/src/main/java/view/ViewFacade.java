package view;

import model.IModel;
//import showboard.BoardFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView, KeyListener {

    private static final long serialVersionUID = 1L;
    public static final int mySize = 32;
    private static ArrayList<Bone> Bones;
    private static ArrayList<BoneHorizontal> BonesHorizontal;
    private static ArrayList<BoneVertical> BonesVertical;
    private static ArrayList<CrystalBall> CrystalBalls;
    private static ArrayList<Purses> Pursess;
    private static ArrayList<Monster1> Monsters1;
    private static ArrayList<Monster2> Monsters2;
    private static ArrayList<Monster3> Monsters3;
    private static ArrayList<Monster4> Monsters4;
    private static ArrayList<Gate> Gates;/*
    private static ArrayList<FireBall> FireBalls;*/

    private int gold = 0, lifes = 11, numlevel = 0;
    String[] levels = new String[7];
    String[][] mapObjects = new String[20][12];
    Lorann lorann;

    Bone bone;
    BoneHorizontal bonehorizontal;
    BoneVertical bonevertical;
    CrystalBall crystalball;
    Purses purses;
    Monster1 monster1;
    Monster2 monster2;
    Monster3 monster3;
    Monster4 monster4;
    Gate gate;/*
    FireBall fireball;*/

    /**
     * Instantiates a new view facade.
     */

    public ViewFacade() {
        //super();


        //new BoardFrame("Lorann", true);

    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }


    @Override
    public final void loadLevel(final String level) {
        if (level !="") {
            levels = level.split("¤");
        }
        String level1 = levels[numlevel];
        this.setTitle("Lorann");
        this.setSize(645, 440);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(645, 440));
        content.setBackground(Color.BLACK);
        content.setLayout(null);
        //content.setLayout(new GridBagLayout());
        this.setFocusable(true);
        addKeyListener(this);

        Bones = new ArrayList<Bone>();
        BonesHorizontal = new ArrayList<BoneHorizontal>();
        BonesVertical = new ArrayList<BoneVertical>();
        CrystalBalls = new ArrayList<CrystalBall>();
        Pursess = new ArrayList<Purses>();
        Monsters1 = new ArrayList<Monster1>();
        Monsters2 = new ArrayList<Monster2>();
        Monsters3 = new ArrayList<Monster3>();
        Monsters4 = new ArrayList<Monster4>();
        Gates = new ArrayList<Gate>();/*
        FireBalls = new ArrayList<FireBall>();*/

        level1.toCharArray();
        int i =0, x = 0, y =0;
        for (int j = 0 ; j < level1.length() ;j++) {
            //System.out.println(level.charAt(j));

            switch (level1.charAt(j))
            {
                case '0':
                    //content.remove(panel[x][y]);
                    /*ImageIcon icone0 = new ImageIcon("sprites/bone.png");
                    Image image0 = icone0.getImage(); // transform it
                    Image newimg0 = image0.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone0 = new ImageIcon(newimg0);
                    JLabel newimage0 = new JLabel(icone0);
                    newimage0.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage0);*/
                    bone = new Bone (x*mySize, y*mySize+32);
                    Bones.add(bone);
                    mapObjects[x][y] = "WALL";

                    break;
                case '1':
                    bonehorizontal = new BoneHorizontal (x*mySize, y*mySize+32);
                    BonesHorizontal.add(bonehorizontal);
                    mapObjects[x][y] = "WALL";
                    break;
                case '2':
                    bonevertical = new BoneVertical (x*mySize, y*mySize+32);
                    BonesVertical.add(bonevertical);
                    mapObjects[x][y] = "WALL";
                    break;
                case '3':
                    mapObjects[x][y] = "LORANN";
                    lorann = new Lorann (x*mySize, y*mySize+32);
                    break;
                case '4':
                    crystalball = new CrystalBall (x*32, y*32+32);
                    CrystalBalls.add(crystalball);
                    mapObjects[x][y] = "CRYSTALBALL";
                    break;
                case '5':
                    purses = new Purses (x*32, y*32+32);
                    Pursess.add(purses);
                    mapObjects[x][y] = "PURSE";
                    break;
                case '6':
                    monster1 = new Monster1 (x*32,y*32+32);
                    Monsters1.add(monster1);
                    mapObjects[x][y] = "MONSTER1";
                    break;
                case '7':
                    mapObjects[x][y] = "MONSTER2";
                    monster2 = new Monster2 (x*32,y*32+32);
                    Monsters2.add(monster2);
                    break;
                case '8':
                    mapObjects[x][y] = "MONSTER3";
                    monster3 = new Monster3 (x*32,y*32+32);
                    Monsters3.add(monster3);
                    break;
                case '9':
                    mapObjects[x][y] = "MONSTER4";
                    monster4 = new Monster4 (x*32,y*32+32);
                    Monsters4.add(monster4);
                    break;
                case 'S':

                    mapObjects[x][y] = "GATE";
                    gate= new Gate (x*32,y*32+32);
                    Gates.add(gate);
                    break;
                case ' ':
                    mapObjects[x][y] = null;
                    break;
                case '\r':
                    x--;
                    break;
                case '\n':
                    x--;
                    break;
                default:
            }
            if (x==19){
                y++;
                x=0;
            }
            else {
                x++;
            }
        }
        /*invalidate();
        validate();
        repaint();*/
        this.setContentPane(content);
        this.setVisible(true);

    }




    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i< Bones.size(); i++){
            bone = Bones.get(i);
            g2d.drawImage(bone.getImage(), bone.getX(), bone.getY(), null);
        }
        for(int i = 0; i< BonesHorizontal.size(); i++){
            bonehorizontal = BonesHorizontal.get(i);
            g2d.drawImage(bonehorizontal.getImage(), bonehorizontal.getX(), bonehorizontal.getY(), null);
        }
        for(int i = 0; i< BonesVertical.size(); i++){
            bonevertical = BonesVertical.get(i);
            g2d.drawImage(bonevertical.getImage(), bonevertical.getX(), bonevertical.getY(), null);
        }
        for(int i = 0; i< CrystalBalls.size(); i++){
            crystalball = CrystalBalls.get(i);
            g2d.drawImage(crystalball.getImage(), crystalball.getX(), crystalball.getY(), null);
        }
        for(int i = 0; i< Pursess.size(); i++){
            purses = Pursess.get(i);
            g2d.drawImage(purses.getImage(), purses.getX(),purses.getY(), null);
        }
        for(int i = 0; i< Monsters1.size(); i++){
            monster1 = Monsters1.get(i);
            g2d.drawImage(monster1.getImage(), monster1.getX(),monster1.getY(), null);
        }
        for(int i = 0; i< Monsters2.size(); i++){
            monster2 = Monsters2.get(i);
            g2d.drawImage(monster2.getImage(), monster2.getX(),monster2.getY(), null);
        }
        for(int i = 0; i< Monsters3.size(); i++){
            monster3 = Monsters3.get(i);
            g2d.drawImage(monster3.getImage(), monster3.getX(),monster3.getY(), null);
        }
        for(int i = 0; i< Monsters4.size(); i++){
            monster4 = Monsters4.get(i);
            g2d.drawImage(monster4.getImage(), monster4.getX(),monster4.getY(), null);
        }
        try{
            g2d.drawImage(gate.getImage(), gate.getX(), gate.getY(), null);
            g2d.drawImage(lorann.getImage(), lorann.getX(), lorann.getY(), null);

        }
        catch(Exception ex){}
        g.setColor(Color.RED);
        g.setFont(Font.getFont(Font.SANS_SERIF));
        //g.drawString("LEVEL : " + numlevel + " / Gold : " + gold + " / Lifes : " + lifes,240, 400);

        /*SwingUtilities.updateComponentTreeUI(this);
        invalidate();
        validate();
        repaint();*/
    }

    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        int x=0;
        int y = 0;
        if (Key == KeyEvent.VK_S || Key == KeyEvent.VK_DOWN || Key == KeyEvent.VK_NUMPAD5 || Key == KeyEvent.VK_NUMPAD2){
            if(mapObjects[lorann.getX()/32][(lorann.getY()/32)] != "WALL")  {
                mapObjects[lorann.getX()/32][(lorann.getY()/32)-1] = null;
                mapObjects[lorann.getX()/32][(lorann.getY()/32)] = "LORANN";
                //lorann.setY(lorann.getY()+32);
                lorann.moveDown();
                Collect();
            }
        }
        if (Key == KeyEvent.VK_Z || Key == KeyEvent.VK_UP || Key == KeyEvent.VK_NUMPAD8){
            if(mapObjects[lorann.getX()/32][(lorann.getY()/32)-2] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                mapObjects[lorann.getX()/32][(lorann.getY()/32)-2] = "LORANN";
                //lorann.setY(lorann.getY() - 32);
                lorann.moveUp();
                Collect();

            }
        }
        if (Key == KeyEvent.VK_Q || Key == KeyEvent.VK_LEFT || Key == KeyEvent.VK_NUMPAD4){
            if(mapObjects[(lorann.getX()/32)-1][(lorann.getY()/32)-1] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                mapObjects[(lorann.getX()/32)-1][(lorann.getY()/32)-1] = "LORANN";
                //lorann.setX(lorann.getX()-32);
                lorann.moveLeft();
                Collect();
            }
        }
        if (Key == KeyEvent.VK_D || Key == KeyEvent.VK_RIGHT || Key == KeyEvent.VK_NUMPAD6){
            if(mapObjects[(lorann.getX()/32)+1][(lorann.getY()/32)-1] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                mapObjects[(lorann.getX()/32)+1][(lorann.getY()/32)-1] = "LORANN";
                //lorann.setX(lorann.getX()+32);
                lorann.moveRight();
                Collect();
            }
        }
        if (Key == KeyEvent.VK_A || Key == KeyEvent.VK_NUMPAD7){
            if(mapObjects[(lorann.getX()/32)-1][(lorann.getY()/32)-2] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                mapObjects[(lorann.getX()/32)-1][(lorann.getY()/32)-2] = "LORANN";
                /*lorann.setX(lorann.getX()-32);
                lorann.setY(lorann.getY()-32);*/
                lorann.moveUpLeft();
                Collect();
            }

        }
        if (Key == KeyEvent.VK_E || Key == KeyEvent.VK_NUMPAD9){
            if(mapObjects[(lorann.getX()/32)+1][(lorann.getY()/32)-2] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                mapObjects[(lorann.getX()/32)+1][(lorann.getY()/32)-2] = "LORANN";
                /*lorann.setX(lorann.getX()+32);
                lorann.setY(lorann.getY()-32);*/
                lorann.moveUpRight();
                Collect();
            }

        }
        if (Key == KeyEvent.VK_W || Key == KeyEvent.VK_NUMPAD1){
            if(mapObjects[(lorann.getX()/32)-1][(lorann.getY()/32)] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                mapObjects[(lorann.getX()/32)-1][(lorann.getY()/32)] = "LORANN";
                /*lorann.setX(lorann.getX()-32);
                lorann.setY(lorann.getY()+32);*/
                lorann.moveDownLeft();
                Collect();
            }

        }
        if (Key == KeyEvent.VK_X ||  Key == KeyEvent.VK_C || Key == KeyEvent.VK_NUMPAD3){
            if(mapObjects[(lorann.getX()/32)+1][(lorann.getY()/32)] != "WALL") {
                mapObjects[lorann.getX() / 32][(lorann.getY() / 32) - 1] = null;
                /*lorann.setX(lorann.getX()+32);
                lorann.setY(lorann.getY()+32);*/
                mapObjects[(lorann.getX()/32)+1][(lorann.getY()/32)] = "LORANN";
                lorann.moveDownRight();
                Collect();


            }

        }
        SwingUtilities.updateComponentTreeUI(this);
        invalidate();
        revalidate();
        repaint();
    }

    public void Collect() {
        Rectangle lorannFake;
        lorannFake = lorann.getBounds();
        for(int i=0;i<Pursess.size();i++){
            purses = Pursess.get(i);
            Rectangle pursesFake = purses.getBounds();

            if(lorannFake.intersects(pursesFake)){
                Pursess.remove(i);
                gold = gold + 650;
                break;
            }
        }
        for (int i=0;i<CrystalBalls.size();i++){
            crystalball = CrystalBalls.get(i);
            Rectangle objectifRec = crystalball.getBounds();
            if (lorannFake.intersects(objectifRec)){
                CrystalBalls.remove(i);
                gate.setEtat("OPEN");
            }
        }

        for(int i=0; i<Gates.size(); i++){
            gate = Gates.get(i);
            Rectangle ouvertRec = gate.getBounds();

            if(lorannFake.intersects(ouvertRec)){
                //level++;
                if (gate.getEtat() == "CLOSED") {
                    lifes--;
                }
                else {
                    numlevel++;
                    loadLevel("");
                }

                //ChangeLevel();
            }
        }
    }
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}













