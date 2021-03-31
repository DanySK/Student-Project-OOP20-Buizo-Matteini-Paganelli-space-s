package view.GUI;

import utilities.DesignGUI;
import utilities.IdGUI;
import view.utilities.JPanelImage;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGUI extends JFrame{
    private JPanelImage panelBackground;
    private IdGUI id;

    public AbstractGUI() {
        super("Space Survival");
        this.panelBackground = new JPanelImage(DesignGUI.PATH_MAIN_BACKGROUND);
        super.setContentPane(this.panelBackground);
        this.setDefaultJFrame();
    }

    private void setDefaultJFrame(){
        super.setBounds(DesignGUI.GUI_X, DesignGUI.GUI_Y, DesignGUI.GUI_WIDTH, DesignGUI.GUI_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
    }

    public void setLayoutGUI(final LayoutManager layout){
        this.panelBackground.setLayout(layout);
    }

    public IdGUI getId(){
        return this.id;
    }

    public void setId(final IdGUI id){
        this.id = id;
    }
}
