package game;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Gui extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    final JFrame frame = new JFrame();
    int pX,pY;

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    final Gui frame = new Gui();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public Gui() {
        this.setTitle("Exile Launcher");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1000, 563);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(null);
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        this.setUndecorated(true);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2);

        int X = 24;
        int Y = 40;

        final JButton HomeButton = new JButton();
        HomeButton.setFocusPainted(false);
        HomeButton.setBorder(null);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("imgHelp/pause.png")));
        HomeButton.setRolloverIcon(new ImageIcon(this.getClass().getClassLoader().getResource("imgHelp/space.png")));
        HomeButton.setBounds(new Rectangle(X, Y, 50, 50));
        this.contentPane.add(HomeButton);
        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("http://www.google.nl").toURI());
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Y += 60;

        final JButton ForumButton = new JButton();
        ForumButton.setFocusPainted(false);
        ForumButton.setBorder(null);
        ForumButton.setContentAreaFilled(false);
        ForumButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("imgHelp/wasd.png")));
        ForumButton.setRolloverIcon(new ImageIcon(this.getClass().getClassLoader().getResource("icon/start.png")));
        ForumButton.setBounds(new Rectangle(X, Y, 50, 50));
        this.contentPane.add(ForumButton);

        Y += 60;

        final JButton VoteButton = new JButton();
        VoteButton.setFocusPainted(false);
        VoteButton.setBorder(null);
        VoteButton.setContentAreaFilled(false);
        VoteButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("icon/weapon.png")));
        VoteButton.setRolloverIcon(new ImageIcon(this.getClass().getClassLoader().getResource("icon/start.png")));
        VoteButton.setBounds(new Rectangle(X, Y, 50, 50));
        this.contentPane.add(VoteButton);

        final JButton CloseButton = new JButton();
        CloseButton.setFocusPainted(false);
        CloseButton.setBorder(null);
        CloseButton.setContentAreaFilled(false);
        CloseButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("icon/quit.png")));
        CloseButton.setRolloverIcon(new ImageIcon(this.getClass().getClassLoader().getResource("icon/back.png")));
        CloseButton.setBounds(new Rectangle(875, 0, 27, 28));
        this.contentPane.add(CloseButton);
        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });

        final JButton MinimizeButton = new JButton();
        MinimizeButton.setFocusPainted(false);
        MinimizeButton.setBorder(null);
        MinimizeButton.setContentAreaFilled(false);
        MinimizeButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("imgHelp/key_k.png")));
        MinimizeButton.setRolloverIcon(new ImageIcon(this.getClass().getClassLoader().getResource("imgHelp/key_P.png")));
        MinimizeButton.setBounds(new Rectangle(850, -1, 27, 28));
        this.contentPane.add(MinimizeButton);
        MinimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        final JProgressBar ProgressBar = new JProgressBar();
        ProgressBar.setLocation(150, 500);
        ProgressBar.setSize(600, 50);
        ProgressBar.setValue(50);
        getContentPane().add(ProgressBar);

        final JLabel backgroundLabel = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("background/main.png")));
        backgroundLabel.setBounds(new Rectangle(0, 0, 1000, 563));
        getContentPane().add(backgroundLabel);

        JPanel titleBar = new JPanel();
        titleBar.setBounds(0, 0, 1000, 25);
        contentPane.add(titleBar);


        titleBar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                // Get x,y and store them
                pX=me.getX();
                pY=me.getY();
            }
        });

        titleBar.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent me)
            {
                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
            }
        });
    }
}