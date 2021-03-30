package view.GUI.help.utilities;

import view.utilities.JImageRate;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class HelpPanel extends JPanel {
    protected JLabel lbTitle = new JLabel();
    private List<JImageRate> listCommandImages = new ArrayList<>();

    public HelpPanel(){
        super(new FlowLayout());
        this.setOpaque(false);
        this.add(this.lbTitle);
    }

    public void setFontLbTitle(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setForegroundLbTitle(final Color color){
        this.lbTitle.setForeground(color);
    }

    public void setLbTitle(final String title){
        this.lbTitle.setText(title);
    }

    public void addHelpImage(final String path, final int rate){
        final JImageRate pnImage = new JImageRate(path, rate);
        this.listCommandImages.add(pnImage);
        this.add(pnImage);
    }

    public String getLbTitle(){
        return this.lbTitle.getText();
    }

    @Override
    public String toString() {
        return "PanelHelp{" +
                "lbTitle=" + lbTitle +
                ", listCommandImages=" + listCommandImages +
                '}';
    }
}
