import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu extends JFrame implements ActionListener {


    public JButton play;

    public JButton quit;

    public ImageIcon background = new ImageIcon("D:\\Projects\\Matrix\\Images\\Matrix.gif");
    public JLabel menu;

    Menu(){

        play = new JButton("Play");
        play.setBounds(800,300,300,150);
        play.setForeground(new Color(50,200,50));
        play.setFont(new Font("Arial",Font.PLAIN,20));
        play.setFocusable(false);
        play.setBackground(new Color(0,0,0));
        play.setBorder(BorderFactory.createEmptyBorder());
        play.addActionListener(this);

        /*
         *Above there is the play button which leads to the game
         * In the game there are three characters
         * Neo,Trinity and Morpheus
         * There is an animation for neo who is shooting wih his pistols
         * Morpheus holds a katana and Trinity guns
         * By pressing the quit button you can exit the game
         */

        quit = new JButton("Quit");
        quit.setBounds(800,800,300,150);
        quit.setForeground(new Color(50,200,50));
        quit.setFont(new Font("Arial",Font.PLAIN,20));
        quit.setFocusable(false);
        quit.setBackground(new Color(0,0,0));
        quit.setBorder(BorderFactory.createEmptyBorder());
        quit.addActionListener(this);

        //The menu consists of a Gif which is the background

        menu = new JLabel(background);
        menu.setBounds(0,0,1920,1080);
        menu.add(play);
        menu.add(quit);
        menu.setOpaque(true);

        /*
         *Below somebody can see the code of the frame
         * The window is full screen by the way
         */


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.add(menu);
        this.setVisible(true);

    }

    public void audio() throws Exception {

        File file = new File("D:\\Projects\\Matrix\\Audio\\Matrix.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        while (con()) {
            clip.start();
        }

        //Soundtrack code above

    }
    public boolean con(){

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            new city();
            this.dispose();
        } else if (e.getSource() == quit) {
            this.dispose();
            System.exit(0);
        }

        //Menu code above

    }

}
