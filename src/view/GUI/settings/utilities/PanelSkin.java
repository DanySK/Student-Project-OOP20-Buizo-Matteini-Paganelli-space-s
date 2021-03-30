package view.GUI.settings.utilities;

import model.GUI.settings.SkinSpaceShip;
import view.utilities.FactoryGUIs;
import view.utilities.JImageRate;

import javax.swing.*;
import java.awt.*;

public class PanelSkin extends JPanel {
    private JLabel lbTitle = new JLabel();
    private JButton btSX = new JButton("<");
    private JButton btDX = new JButton(">");;

    private SkinSpaceShip skinSpaceShip = SkinSpaceShip.PRIME;
    private JImageRate pnImage = new JImageRate();

    public PanelSkin(final int width, final int height){
        super(new BorderLayout());
        this.setOpaque(false);
        this.createGraphics();
    }

    public PanelSkin(final String path, final int rate){
        super(new BorderLayout());
        this.setOpaque(false);
        this.pnImage.setRate(rate);
        this.pnImage.setIcon(path);
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
        this.pnImage.setIcon(pathImage);
    }

    public void setRateImg(final int rate) {
        this.pnImage.setRate(rate);
    }

    public JButton getBtSX() {
        return btSX;
    }

    public JButton getBtDX() {
        return btDX;
    }
}
