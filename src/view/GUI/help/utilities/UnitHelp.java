package view.GUI.help.utilities;

import view.utilities.JImageRate;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class UnitHelp extends JPanel {
    private final JLabel lbTitle;
    private final List<JImageRate> listIconCommand;

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

    public void addIconUnit(final String path, final int rate) {
        final JImageRate pnImage = new JImageRate(path, rate);
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
