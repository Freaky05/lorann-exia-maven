package view;

import model.IModel;
import showboard.BoardFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.SQLException;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView, KeyListener {

    private static final long serialVersionUID = 1L;
    private static final int mySize = 64;
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
    String[][] mapObjects = new String[20][12];
    Lorann lorann;

    @Override
    public final void loadLevel(final String level, final int numlevel) {
        this.setTitle("Lorann");
        this.setSize(1290, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(1290, 768));
        content.setBackground(Color.BLACK);
        content.setLayout(null);
        //content.setLayout(new GridBagLayout());
        this.setFocusable(true);
        addKeyListener(this);

        //L'objet servant à positionner les composants
        //GridBagConstraints gbc = new GridBagConstraints();


        //On crée nos différents conteneurs de couleur différente
        /*JPanel[][] panel = new JPanel[20][12];
        int[][] block = {};
        int[][] lorann = {};*/

        /*for (int x = 0; x < panel.length; x++) {
            for (int y = 0; y < panel[x].length; y++) {
                Color couleur = new Color((int)(Math.random() * 0x1000000));
                panel[x][y] = new JPanel();
                panel[x][y].setBackground(Color.BLACK);
                panel[x][y].setPreferredSize(new Dimension(mySize, mySize));
                gbc.gridx = x;
                gbc.gridy = y;
                gbc.weightx = 0.05;
                gbc.weighty = 0.08;
                gbc.fill = GridBagConstraints.BOTH;
                content.add(panel[x][y], gbc);
            }
        }*/
        level.toCharArray();
        int i =0, x = 0, y =0;
        for (int j = 0 ; j < level.length() ;j++) {
            //System.out.println(level.charAt(j));

            switch (level.charAt(j))
            {
                case '0':
                    //content.remove(panel[x][y]);
                    ImageIcon icone0 = new ImageIcon("sprites/bone.png");
                    Image image0 = icone0.getImage(); // transform it
                    Image newimg0 = image0.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone0 = new ImageIcon(newimg0);
                    JLabel newimage0 = new JLabel(icone0);
                    newimage0.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage0);
                    mapObjects[x][y] = "WALL";
                    //panel[x][y].add(newimage0);
                    //content.add(panel[x][y], gbc);
                    //block[x][y] = 0;
                            /*
                            Game [x][y] = "WALLS";
                            bone1 = new Bone1(x*32, y*32);
                            Bones1.add(bone1);*/
                    break;
                case '1':
                    ImageIcon icone1 = new ImageIcon("sprites/horizontal_bone.png");
                    Image image1 = icone1.getImage(); // transform it
                    Image newimg1 = image1.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone1 = new ImageIcon(newimg1);
                    JLabel newimage1 = new JLabel(icone1);
                    newimage1.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage1);
                    mapObjects[x][y] = "WALL";
                    //panel[x][y].add(newimage1);
                            /*Game [x][y] = "WALLS";
                            bone2 = new Bone2(x*32, y*32);
                            Bones2.add(bone2);*/
                    break;
                case '2':
                    ImageIcon icone2 = new ImageIcon("sprites/vertical_bone.png");
                    Image image2 = icone2.getImage(); // transform it
                    Image newimg2 = image2.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone2 = new ImageIcon(newimg2);
                    JLabel newimage2 = new JLabel(icone2);
                    newimage2.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage2);
                    mapObjects[x][y] = "WALL";
                    //panel[x][y].add(newimage2);
                            /*Game [x][y] = "WALLS";
                            bone3 = new Bone3(x*32, y*32);
                            Bones3.add(bone3);*/
                    break;
                case '3':
                    ImageIcon icone3 = new ImageIcon("sprites/lorann_b.png");
                    Image image3 = icone3.getImage(); // transform it
                    Image newimg3 = image3.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone3 = new ImageIcon(newimg3);
                    JLabel newimage3 = new JLabel(icone3);
                    newimage3.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage3);
                    mapObjects[x][y] = "LORANN";
                    lorann = new Lorann (x*mySize, y*mySize);
                    //panel[x][y].add(newimage3);
                    //block[x][y] = 1;

                            /*Game [x][y] = "LORANN";
                            lorann = new Lorann (x*32, y*32);*/
                    break;
                case '4':
                    ImageIcon icone4 = new ImageIcon("sprites/crystal_ball.png");
                    Image image4 = icone4.getImage(); // transform it
                    Image newimg4 = image4.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone4 = new ImageIcon(newimg4);
                    JLabel newimage4 = new JLabel(icone4);
                    newimage4.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage4);
                    mapObjects[x][y] = "CRYSTALBALL";
                    //panel[x][y].add(newimage4);
                            /*Game [x][y] = "CRYSTALBALL";
                            crystalball = new CrystalBall (x*32, y*32);
                            CrystalBalls.add(crystalball);*/
                    break;
                case '5':
                    ImageIcon icone5 = new ImageIcon("sprites/purse.png");
                    Image image5 = icone5.getImage(); // transform it
                    Image newimg5 = image5.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone5 = new ImageIcon(newimg5);
                    JLabel newimage5 = new JLabel(icone5);
                    newimage5.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage5);
                    mapObjects[x][y] = "PURSE";
                    //panel[x][y].add(newimage5);
                            /*Game [x][y] = "PURSES";
                            purses = new Purses (x*32, y*32);
                            Pursess.add(purses);*/
                    break;
                case '6':
                    ImageIcon icone6 = new ImageIcon("sprites/monster_1.png");
                    Image image6 = icone6.getImage(); // transform it
                    Image newimg6 = image6.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone6 = new ImageIcon(newimg6);
                    JLabel newimage6 = new JLabel(icone6);
                    newimage6.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage6);
                    mapObjects[x][y] = "MONSTER1";
                    //panel[x][y].add(newimage6);
                            /*Game[x][y] = "MONSTER1";
                            monster1 = new Monster1 (x*32,y*32);
                            Monsters1.add(monster1);*/
                    break;
                case '7':
                    ImageIcon icone7 = new ImageIcon("sprites/monster_2.png");
                    Image image7 = icone7.getImage(); // transform it
                    Image newimg7 = image7.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone7 = new ImageIcon(newimg7);
                    JLabel newimage7 = new JLabel(icone7);
                    newimage7.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage7);
                    mapObjects[x][y] = "MONSTER2";
                    //panel[x][y].add(newimage7);
                            /*Game[x][y] = "MONSTER2";
                            monster2 = new Monster2 (x*32,y*32);
                            Monsters2.add(monster2);*/
                    break;
                case '8':
                    ImageIcon icone8 = new ImageIcon("sprites/monster_3.png");
                    Image image8 = icone8.getImage(); // transform it
                    Image newimg8 = image8.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone8 = new ImageIcon(newimg8);
                    JLabel newimage8 = new JLabel(icone8);
                    newimage8.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage8);
                    mapObjects[x][y] = "MONSTER3";
                    //panel[x][y].add(newimage8);
                            /*Game[x][y] = "MONSTER3";
                            monster3 = new Monster3 (x*32,y*32);
                            Monsters3.add(monster3);*/
                    break;
                case '9':
                    ImageIcon icone9 = new ImageIcon("sprites/monster_4.png");
                    Image image9 = icone9.getImage(); // transform it
                    Image newimg9 = image9.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone9 = new ImageIcon(newimg9);
                    JLabel newimage9 = new JLabel(icone9);
                    newimage9.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage9);
                    mapObjects[x][y] = "MONSTER4";
                    //panel[x][y].add(newimage9);
                            /*Game[x][y] = "MONSTER4";
                            monster4 = new Monster4 (x*32,y*32);
                            Monsters4.add(monster4);*/
                    break;
                case 'S':
                    ImageIcon icone10 = new ImageIcon("sprites/gate_closed.png");
                    Image image10 = icone10.getImage(); // transform it
                    Image newimg10 = image10.getScaledInstance(mySize, mySize,  Image.SCALE_SMOOTH); // scale it the smooth way
                    icone10 = new ImageIcon(newimg10);
                    JLabel newimage10 = new JLabel(icone10);
                    newimage10.setBounds(x*mySize,y*mySize, mySize,mySize);
                    content.add(newimage10);
                    mapObjects[x][y] = "GATE";
                    //panel[x][y].add(newimage10);
                            /*Game[x][y] = "OUTDOOR";
                            outdoor = new OutDoor (x*32,y*32);
                            OutDoors.add(outdoor);*/
                    break;
                case ' ':
                    mapObjects[x][y] = null;
                    /*Game[x][y] = null;*/
                    break;
                case '\r':
                    x--;
                    break;
                case '\n':
                    x--;
                    break;
                default:
                    ;
            }
            if (x==19){
                y++;
                x=0;
            }
            else {
                x++;
            }
        }

        this.setContentPane(content);
        this.setVisible(true);

    }

    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;



        try{
            //g2d.drawImage(lorann.getImage(), lorann.getX(), lorann.getY(), null);

        }
        catch(Exception ex){}
        g.setColor(Color.RED);
        g.setFont(Font.getFont(Font.SANS_SERIF));
        //g.drawString("LEVEL : " + numlevel + " / Gold : " + gold + " / Lifes : " + lifes,240, 400);

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        int x=0;
        int y = 0;

        if (Key == KeyEvent.VK_S || Key == KeyEvent.VK_DOWN || Key == KeyEvent.VK_NUMPAD5 || Key == KeyEvent.VK_NUMPAD2){

            displayMessage("Bas");
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}













