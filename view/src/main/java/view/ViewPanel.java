package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ViewPanel extends JPanel implements IView {

    public ViewPanel() {
       // repaint();
    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void loadLevel(String level) {

    }


    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        try (PrintWriter out = new PrintWriter("maps/level_1.txt")) {
            out.println("       0101111111110 \n" +
                    "   011002 7       00\n" +
                    "   2    2          2\n" +
                    "0110    2   5      2\n" +
                    "2 5 01110111110    0\n" +
                    "25  6       4    3 2\n" +
                    "2 5 01110111110    0\n" +
                    "0110    2   5      2\n" +
                    "   2   82          2\n" +
                    "   0110029    S   00\n" +
                    "      0101111111110 \n" +
                    "                    \n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(1290, 768));
        content.setBackground(Color.BLACK);
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        //On crée nos différents conteneurs de couleur différente
        JPanel[][] panel = new JPanel[20][12];
        int[][] block = {};
        int[][] lorann = {};

        for (int x = 0; x < panel.length; x++) {
            for (int y = 0; y < panel[x].length; y++) {
                Color couleur = new Color((int)(Math.random() * 0x1000000));
                panel[x][y] = new JPanel();
                panel[x][y].setBackground(Color.BLACK);
                panel[x][y].setPreferredSize(new Dimension(64, 64));
                gbc.gridx = x;
                gbc.gridy = y;
                gbc.weightx = 0.05;
                gbc.weighty = 0.08;
                gbc.fill = GridBagConstraints.BOTH;
                content.add(panel[x][y], gbc);
            }
        }
        FileReader fr;
        int i =0, x = 0, y =0;
        File f = new File("maps/level_1.txt");
        if(f.exists() && !f.isDirectory())
        {
            try {
                fr = new FileReader("maps/level_1.txt");
                while((i=fr.read()) != -1){
                    gbc.gridx = x;
                    gbc.gridy = y;

                    char strImg = (char) i;
                    switch (strImg)
                    {
                        case '0':
                            content.remove(panel[x][y]);
                            ImageIcon icone0 = new ImageIcon("sprites/bone.png");
                            Image image0 = icone0.getImage(); // transform it
                            Image newimg0 = image0.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone0 = new ImageIcon(newimg0);
                            JLabel newimage0 = new JLabel(icone0);


                            panel[x][y].add(newimage0);
                            content.add(panel[x][y], gbc);
                            //block[x][y] = 0;
                            /*bone1 = new Bone1(x*32, y*32);
                            Bones1.add(bone1);*/
                            break;
                        case '1':
                            ImageIcon icone1 = new ImageIcon("sprites/horizontal_bone.png");
                            Image image1 = icone1.getImage(); // transform it
                            Image newimg1 = image1.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone1 = new ImageIcon(newimg1);
                            JLabel newimage1 = new JLabel(icone1);
                            panel[x][y].add(newimage1);
                            /*Game [x][y] = "WALLS";
                            bone2 = new Bone2(x*32, y*32);
                            Bones2.add(bone2);*/
                            break;
                        case '2':
                            ImageIcon icone2 = new ImageIcon("sprites/vertical_bone.png");
                            Image image2 = icone2.getImage(); // transform it
                            Image newimg2 = image2.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone2 = new ImageIcon(newimg2);
                            JLabel newimage2 = new JLabel(icone2);
                            panel[x][y].add(newimage2);
                            /*Game [x][y] = "WALLS";
                            bone3 = new Bone3(x*32, y*32);
                            Bones3.add(bone3);*/
                            break;
                        case '3':
                            ImageIcon icone3 = new ImageIcon("sprites/lorann_b.png");
                            Image image3 = icone3.getImage(); // transform it
                            Image newimg3 = image3.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone3 = new ImageIcon(newimg3);
                            JLabel newimage3 = new JLabel(icone3);
                            panel[x][y].add(newimage3);
                            //block[x][y] = 1;

                            /*Game [x][y] = "LORANN";
                            lorann = new Lorann (x*32, y*32);*/
                            break;
                        case '4':
                            ImageIcon icone4 = new ImageIcon("sprites/crystal_ball.png");
                            Image image4 = icone4.getImage(); // transform it
                            Image newimg4 = image4.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone4 = new ImageIcon(newimg4);
                            JLabel newimage4 = new JLabel(icone4);
                            panel[x][y].add(newimage4);
                            /*Game [x][y] = "CRYSTALBALL";
                            crystalball = new CrystalBall (x*32, y*32);
                            CrystalBalls.add(crystalball);*/
                            break;
                        case '5':
                            ImageIcon icone5 = new ImageIcon("sprites/purse.png");
                            Image image5 = icone5.getImage(); // transform it
                            Image newimg5 = image5.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone5 = new ImageIcon(newimg5);
                            JLabel newimage5 = new JLabel(icone5);
                            panel[x][y].add(newimage5);
                            /*Game [x][y] = "PURSES";
                            purses = new Purses (x*32, y*32);
                            Pursess.add(purses);*/
                            break;
                        case '6':
                            ImageIcon icone6 = new ImageIcon("sprites/monster_1.png");
                            Image image6 = icone6.getImage(); // transform it
                            Image newimg6 = image6.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone6 = new ImageIcon(newimg6);
                            JLabel newimage6 = new JLabel(icone6);
                            panel[x][y].add(newimage6);
                            /*Game[x][y] = "MONSTER1";
                            monster1 = new Monster1 (x*32,y*32);
                            Monsters1.add(monster1);*/
                            break;
                        case '7':
                            ImageIcon icone7 = new ImageIcon("sprites/monster_2.png");
                            Image image7 = icone7.getImage(); // transform it
                            Image newimg7 = image7.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone7 = new ImageIcon(newimg7);
                            JLabel newimage7 = new JLabel(icone7);
                            panel[x][y].add(newimage7);
                            /*Game[x][y] = "MONSTER2";
                            monster2 = new Monster2 (x*32,y*32);
                            Monsters2.add(monster2);*/
                            break;
                        case '8':
                            ImageIcon icone8 = new ImageIcon("sprites/monster_3.png");
                            Image image8 = icone8.getImage(); // transform it
                            Image newimg8 = image8.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone8 = new ImageIcon(newimg8);
                            JLabel newimage8 = new JLabel(icone8);
                            panel[x][y].add(newimage8);
                            /*Game[x][y] = "MONSTER3";
                            monster3 = new Monster3 (x*32,y*32);
                            Monsters3.add(monster3);*/
                            break;
                        case '9':
                            ImageIcon icone9 = new ImageIcon("sprites/monster_4.png");
                            Image image9 = icone9.getImage(); // transform it
                            Image newimg9 = image9.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone9 = new ImageIcon(newimg9);
                            JLabel newimage9 = new JLabel(icone9);
                            panel[x][y].add(newimage9);
                            /*Game[x][y] = "MONSTER4";
                            monster4 = new Monster4 (x*32,y*32);
                            Monsters4.add(monster4);*/
                            break;
                        case 'S':
                            ImageIcon icone10 = new ImageIcon("sprites/gate_closed.png");
                            Image image10 = icone10.getImage(); // transform it
                            Image newimg10 = image10.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            icone10 = new ImageIcon(newimg10);
                            JLabel newimage10 = new JLabel(icone10);
                            panel[x][y].add(newimage10);
                            /*Game[x][y] = "OUTDOOR";
                            outdoor = new OutDoor (x*32,y*32);
                            OutDoors.add(outdoor);*/
                            break;
                        case ' ':
                            /*Game[x][y] = null;*/
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

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.add(content);
        //repaint();
        //updateUI();
        revalidate();
    }
}
