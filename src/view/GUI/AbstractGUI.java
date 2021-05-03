package view.GUI;

import utilities.DesignSpace;
import utilities.DimensionScreen;
import utilities.IdGUI;
import view.utilities.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Arrays;

public abstract class AbstractGUI extends JFrame{
    private final JPanelImage panelBackground;
    private final JPanel panelForeground;

    private IdGUI id;

    public AbstractGUI() {
        super();
        this.panelBackground = new JPanelImage(DimensionScreen.PATH_MAIN_BACKGROUND);
        this.panelForeground = new JPanel(new BorderLayout()) {{ setOpaque(false); setVisible(false); }};

        super.setContentPane(this.panelBackground);
        super.setGlassPane(this.panelForeground);

        this.setDefaultJFrame();
    }

    private void setDefaultJFrame(){
        super.setBounds(DimensionScreen.RECTANGLE_FULLSCREEN);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setUndecorated(true);
        super.setResizable(false);

    }


    public IdGUI getId(){
        return this.id;
    }

    public void setId(final IdGUI id){
        this.id = id;
    }


    public void setBackgroundLayout(final LayoutManager layoutGUI){
        this.panelBackground.setLayout(layoutGUI);
    }

    public void addForegroundPanel(final Component component, final String index){
        this.panelForeground.add(component, index);
    }

    public void visibleForegroundPanel(final boolean visible){
        this.panelForeground.setVisible(visible);
    }

    public void setBounds(final Rectangle screen){
        super.setBounds(screen);
        this.panelBackground.setBounds(screen);
        this.panelForeground.setBounds(screen);
    }

    public void setBackgroundImage(final String path){
        this.panelBackground.setImage(path);
    }

    public void close(){
        System.exit(0);
    }

    public void setBorder(final int thickness){
        this.panelBackground.setBorder(BorderFactory.createLineBorder(DesignSpace.color4, thickness));
    }
}
