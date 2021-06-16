package spacesurvival.view.settings.utilities;

import spacesurvival.model.EngineImage;
import spacesurvival.model.GUI.settings.EngineSettings;
import spacesurvival.view.utilities.FactoryGUIs;
import spacesurvival.view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class PanelSkin extends JPanel {
    private final JLabel lbTitle;
    private final JButton btSX;
    private final JButton btDX;

    private final JImage pnImage;

    public PanelSkin(){
        super(new BorderLayout());
        super.setOpaque(false);

        this.lbTitle = new JLabel();
        this.btSX  = new JButton(EngineSettings.DIR_SX);
        this.btDX = new JButton(EngineSettings.DIR_DX);
        this.pnImage = new JImage();
        this.createGraphics();
    }

    private void createGraphics(){
        this.add(FactoryGUIs.encapsulateInPanelVerticalCenter(this.btSX), BorderLayout.WEST);
        this.add(FactoryGUIs.encapsulatesInPanelFlow(this.lbTitle), BorderLayout.NORTH);
        this.add(this.pnImage, BorderLayout.CENTER);
        this.add(FactoryGUIs.encapsulateInPanelVerticalCenter(this.btDX), BorderLayout.EAST);
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
        this.pnImage.setImage(pathImage);
    }

    public void setRateImg(final int rate, final int widthScreen) {
         final Dimension dimension = EngineImage.getSizeImageFromScale(
                 this.pnImage.getPath(), rate, widthScreen);
        this.pnImage.setSize(dimension);
    }

    public JButton getBtSX() {
        return btSX;
    }

    public JButton getBtDX() {
        return btDX;
    }
}
