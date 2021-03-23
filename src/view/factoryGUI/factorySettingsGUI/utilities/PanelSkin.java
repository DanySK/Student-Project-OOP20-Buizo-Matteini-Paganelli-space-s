package view.factoryGUI.factorySettingsGUI.utilities;

import utilities.SkinSpaceShip;
import view.utilities.FactoryGUIs;
import view.utilities.MyJImage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelSkin extends JPanel {
    private JButton btSX;
    private JButton btDX;

    private SkinSpaceShip skinSpaceShip = SkinSpaceShip.DELUXE;
    private MyJImage pnImage;

    public PanelSkin(final int width, final int height) throws IOException {
        super(new BorderLayout());
        this.setOpaque(false);
        this.btDX = new JButton(">");
        this.btSX = new JButton("<");
        this.pnImage = new MyJImage(width, height, this.skinSpaceShip.getPath());
        this.createGraphics();

    }

    private void createGraphics(){
        this.add(FactoryGUIs.encapsulatesInPanel_Box_Vertical_Center(this.btSX), BorderLayout.WEST);
        this.add(this.pnImage, BorderLayout.CENTER);
        this.add(FactoryGUIs.encapsulatesInPanel_Box_Vertical_Center(this.btDX), BorderLayout.EAST);
    }

    public void setFontButtons(final Font font){
        this.btSX.setFont(font);
        this.btDX.setFont(font);
    }

    public void setAllForeground(final Color color){
        this.setForeground(color);
        this.btDX.setForeground(color);
        this.btSX.setForeground(color);
    }

    public void setTransparentButton(){
        FactoryGUIs.setTransparentDesignJButton(this.btSX);
        FactoryGUIs.setTransparentDesignJButton(this.btDX);
    }
}
