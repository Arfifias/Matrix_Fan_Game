import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class city extends JFrame implements KeyListener, ActionListener {

    public JButton back;

    public ImageIcon icon = new ImageIcon("D:\\Projects\\Matrix\\Images\\City.jpg");
    public ImageIcon protagonist = new ImageIcon("D:\\Projects\\Matrix\\Images\\Neo.png");
    public ImageIcon icon2 = new ImageIcon("D:\\Projects\\Matrix\\Images\\shooting.png");

    public ImageIcon leader = new ImageIcon("D:\\Projects\\Matrix\\Images\\Morpheus.png");

    public ImageIcon girl = new ImageIcon("D:\\Projects\\Matrix\\Images\\Trinity.png");


    public JLabel neo;
    public JLabel morpheus;
    public JLabel trinity;
    public JLabel city;

    //Variables





    city() {

        back = new JButton("Back");
        back.setBounds(800,500,300,150);
        back.setForeground(new Color(50,200,50));
        back.setFont(new Font("Arial",Font.PLAIN,20));
        back.setFocusable(false);
        back.setBackground(new Color(0,0,0));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setVisible(false);
        back.addActionListener(this);

        neo = new JLabel(protagonist);
        neo.setBounds(300, 300, 700, 800);

        morpheus = new JLabel(leader);
        morpheus.setBounds(900, 500, 300, 500);

        trinity = new JLabel(girl);
        trinity.setBounds(1200, 500, 300, 500);

        city = new JLabel(icon);
        city.setBounds(0, 0, 1920, 1080);
        city.add(back);
        city.add(neo);
        city.add(morpheus);
        city.add(trinity);
        city.setOpaque(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.addKeyListener(this);
        this.add(city);
        this.setVisible(true);

        /*
         *Please note that this is a project which I am still working on
         * I have not finished the collision because I am still new in Game Development
         * It's a little bit hard because I realized that the player should have been a class and not a label
         * Also worth mentioning that there are only one animation with neo as the chosen one
         */

    }


    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w' -> neo.setLocation(neo.getX(), neo.getY() - 10);
            case 's' -> neo.setLocation(neo.getX(), neo.getY() + 10);
            case 'a' -> neo.setLocation(neo.getX() - 10, neo.getY());
            case 'd' -> neo.setLocation(neo.getX() + 10, neo.getY());
            case 'f' -> neo.setIcon(icon2);
            case 'e' -> neo.setIcon(protagonist);
            case 'b' -> {
                neo.setVisible(false);
                morpheus.setVisible(false);
                trinity.setVisible(false);
                back.setVisible(true);
            }
            case 'i' -> trinity.setLocation(trinity.getX(),trinity.getY() - 10);
            case 'k' -> trinity.setLocation(trinity.getX(),trinity.getY() + 10);
            case 'l' -> trinity.setLocation(trinity.getX() + 10,trinity.getY());
            case 'j' -> trinity.setLocation(trinity.getX() - 10,trinity.getY());
        }
        //Movement
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            this.dispose();
            System.exit(0);
            //Exiting with escape
        }

        switch (e.getKeyCode()){
            case 37 -> morpheus.setLocation(morpheus.getX() - 10,morpheus.getY());
            case 38 -> morpheus.setLocation(morpheus.getX(),morpheus.getY() - 10);
            case 40 -> morpheus.setLocation(morpheus.getX(),morpheus.getY() + 10);
            case 39 -> morpheus.setLocation(morpheus.getX() + 10,morpheus.getY());

            //More movement
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());

    }

    public void audio() throws Exception {

        File file = new File("D:\\Projects\\Matrix\\Audio\\Matrix.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        while (con()) {
            clip.start();
            //Same audio
        }
    }

    public boolean con(){

        return true;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            new Menu();
            this.dispose();

            /*
             *By pressing b and back somebody can exit the game
             * In future releases I will add more stuff in the game
             * Now this version is a v0.01
             */
        }
    }
}


