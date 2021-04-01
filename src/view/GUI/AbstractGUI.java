package view.GUI;

import utilities.*;
import view.utilities.JPanelImage;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGUI extends JFrame{
    private final JPanelImage panelBackground;
    private IdGUI id;

    public AbstractGUI() {
        super();
        this.panelBackground = new JPanelImage(DesignJFrame.PATH_MAIN_BACKGROUND);
        super.setContentPane(this.panelBackground);
        this.setDefaultJFrame();
    }

    private void setDefaultJFrame(){
        super.setBounds(DesignJFrame.GUI_X, DesignJFrame.GUI_Y, DesignJFrame.GUI_WIDTH, DesignJFrame.GUI_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setUndecorated(true);
        super.setResizable(false);
    }

    public void setLayoutGUI(final LayoutManager layoutGUI){
        this.panelBackground.setLayout(layoutGUI);
    }

    public IdGUI getId(){
        return this.id;
    }

    public void setId(final IdGUI id){
        this.id = id;
    }
}
