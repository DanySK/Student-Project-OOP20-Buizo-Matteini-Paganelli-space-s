package view.factoryGUI.factorySettingsGUI.utilities;

import model.factoryGUI.settingsGUI.SkinSpaceShip;
import view.utilities.FactoryGUIs;
import view.utilities.MyJImage;

import javax.swing.*;
import java.awt.*;

public class PanelSkin extends JPanel {
    private JLabel lbTitle = new JLabel();
    private JButton btSX = new JButton("<");
    private JButton btDX = new JButton(">");;

    private SkinSpaceShip skinSpaceShip = SkinSpaceShip.PRIME;
    private MyJImage pnImage = new MyJImage();

    public PanelSkin(final int width, final int height){
        super(new BorderLayout());
        this.setOpaque(false);
        this.createGraphics();
    }

    public PanelSkin(final int width, final int height, final String path){
        super(new BorderLayout());
        this.setOpaque(false);
        this.pnImage.setDimensionImg(width, height);
        this.pnImage.setIconImage(path);
        this.createGraphics();
    }

    public PanelSkin(){
        super(new BorderLayout());
        this.setOpaque(false);
        this.createGraphics();
    }

    private void createGraphics(){
        this.add(FactoryGUIs.encapsulatesInPanel_Box_Vertical_Center(this.btSX), BorderLayout.WEST);
        this.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);
        this.add(this.pnImage, BorderLayout.CENTER);
        this.add(FactoryGUIs.encapsulatesInPanel_Box_Vertical_Center(this.btDX), BorderLayout.EAST);
    }

    public void setLbTitle(final String title){
        this.lbTitle.setText(title);
    }

    public void setFontButtons(final Font font){
        this.btSX.setFont(font);
        this.btDX.setFont(font);
    }

    public void setFontLbTitle(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setAllForeground(final Color color){
        this.setForeground(color);
        this.btDX.setForeground(color);
        this.btSX.setForeground(color);
        this.lbTitle.setForeground(color);
    }

    public void setTransparentButton(){
        FactoryGUIs.setTransparentDesignJButton(this.btSX);
        FactoryGUIs.setTransparentDesignJButton(this.btDX);
    }

    public void setPnImage(final String pathImage){
        this.pnImage.setIconImage(pathImage);
    }

    public void setDimensionImg(final int width, final int height) {
        this.pnImage.setDimensionImg(width, height);
    }

    public JButton getBtSX() {
        return btSX;
    }

    public JButton getBtDX() {
        return btDX;
    }
}
