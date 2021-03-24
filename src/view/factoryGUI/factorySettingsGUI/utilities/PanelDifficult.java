package view.factoryGUI.factorySettingsGUI.utilities;

import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class PanelDifficult extends JPanel{
    private JLabel lbTitle = new JLabel();
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton rbtEasy = new JRadioButton("Easy");
    private JRadioButton rbtMedium = new JRadioButton("Medium");
    private JRadioButton rbtHard = new JRadioButton("Hard");

    public PanelDifficult(){
        super(new BorderLayout());
        this.setOpaque(false);
        this.add(FactoryGUIs.encapsulatesInPanel_Flow(this.lbTitle), BorderLayout.NORTH);
        this.add(FactoryGUIs.getUnionComponents(List.of(this.rbtEasy,this.rbtMedium,this.rbtHard)), BorderLayout.CENTER);
        this.createGroup();
    }

    private void createGroup(){
        this.rbtEasy.setOpaque(false);
        this.rbtMedium.setOpaque(false);
        this.rbtHard.setOpaque(false);
        this.group.add(this.rbtEasy);
        this.group.add(this.rbtMedium);
        this.group.add(this.rbtHard);
        this.rbtEasy.setSelected(true);
    }

    public void setFontTitleDifficult(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setFontGroupRadioButton(final Font font){
        this.rbtEasy.setFont(font);
        this.rbtMedium.setFont(font);
        this.rbtHard.setFont(font);
    }

    public void setTitle(final String title){
        this.lbTitle.setText(title);
    }

    public void setAllForeground(final Color color){
        this.lbTitle.setForeground(color);
        this.rbtEasy.setForeground(color);
        this.rbtMedium.setForeground(color);
        this.rbtHard.setForeground(color);
    }

    public void setFocusable(final boolean focusable){
        this.rbtEasy.setFocusable(focusable);
        this.rbtMedium.setFocusable(focusable);
        this.rbtHard.setFocusable(focusable);
    }
}
