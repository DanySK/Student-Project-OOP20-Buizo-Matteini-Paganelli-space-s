package view.factoryGUI.factoryHelpGUI.utilities;

import view.utilities.MyJImage;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class PanelHelp extends JPanel {
    protected JLabel lbTitle = new JLabel();
    private List<MyJImage> listCommandImages = new ArrayList<>();

    public PanelHelp(){
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

    public void addHelpImage(final int width, final int height, final String path){
        final MyJImage pnImage = new MyJImage(width, height, path);
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
