package view.GUI;

import utilities.DesignJFrame;
import utilities.IdGUI;
import view.utilities.FactoryGUIs;
import view.utilities.JPanelImage;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGUI extends JFrame{
    private final JPanelImage panelBackground;
    private final JPanel frontPanel;

    private IdGUI id;

    public AbstractGUI() {
        super();
        this.frontPanel = new JPanel(new BorderLayout()) {{ setOpaque(false); }};
        this.panelBackground = new JPanelImage(DesignJFrame.PATH_MAIN_BACKGROUND);
        super.setGlassPane(this.frontPanel);
        super.setContentPane(this.panelBackground);
        this.setDefaultJFrame();
    }

    private void setDefaultJFrame(){
        super.setBounds(DesignJFrame.GUI_X_MEDIUM, DesignJFrame.GUI_Y_MEDIUM,
                DesignJFrame.GUI_WIDTH_MEDIUM, DesignJFrame.GUI_HEIGHT_MEDIUM);
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

    public void setBackLayoutGUI(final LayoutManager layoutGUI){
        this.panelBackground.setLayout(layoutGUI);
    }

    public void addFront(final Component component, final String index){
        this.frontPanel.add(component, index);
    }

    public void visibleFrontPanel(final boolean visible){
        this.frontPanel.setVisible(visible);
    }

    public void setBounds(final int widthFrame, final int heightFrame){
        super.setBounds(DesignJFrame.findPointXGUI(widthFrame), DesignJFrame.findPointYGUI(heightFrame),
                widthFrame, heightFrame);
        this.panelBackground.resizeImg(widthFrame);
    }

    public void setBackground(final String path){
        this.panelBackground.setImage(path);
    }

    public void close(){
        System.exit(0);
    }
}
