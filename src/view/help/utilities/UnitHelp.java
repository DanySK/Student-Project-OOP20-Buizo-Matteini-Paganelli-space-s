package view.help.utilities;

import model.EngineImage;
import view.utilities.JImage;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UnitHelp extends JPanel {
    private final JLabel lbTitle;
    private final List<JImage> listIconCommand;

    public UnitHelp(){
        super(new FlowLayout());
        super.setOpaque(false);
        this.lbTitle = new JLabel();
        this.listIconCommand = new ArrayList<>();
        super.add(this.lbTitle);
    }

    public String getTitleUnit(){
        return this.lbTitle.getText();
    }

    public void setTitleUnit(final String title) {
        this.lbTitle.setText(title);
    }

    public void setFontTitleUnit(final Font font) {
        this.lbTitle.setFont(font);
    }

    public void setForegroundUnit(final Color color) {
        this.lbTitle.setForeground(color);
    }

    public void addIconUnit(final EngineImage engineImage) {
        final JImage pnImage = new JImage(engineImage.getPath(), engineImage.getSize());
        this.listIconCommand.add(pnImage);
        super.add(pnImage);
    }
    
    @Override
    public String toString() {
        return "PanelHelp{" +
                "lbTitle=" + lbTitle +
                ", listCommandImages=" + listIconCommand +
                '}';
    }
}
