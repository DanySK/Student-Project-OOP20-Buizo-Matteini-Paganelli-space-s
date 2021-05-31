package spaceSurvival.view.dead.concrete;

import spaceSurvival.view.AbstractGUI;
import spaceSurvival.view.dead.GUIDead;
import spaceSurvival.view.utilities.BtnAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUIDeadConcrete extends AbstractGUI implements GUIDead {

    private JLabel lbTitleDead;

    public GUIDeadConcrete(){
        this.lbTitleDead = new JLabel();
    }

    @Override
    public List<BtnAction> getBtnActionLinks() {
        return List.of();
    }


    @Override
    public void setFontTitleGUI(final Font font) {
        this.lbTitleDead.setFont(font);
    }

    @Override
    public void setTitleGUI(final String titleGUI) {
        this.lbTitleDead.setText(titleGUI);
    }


    public JLabel getLbTitleDead() {
        return this.lbTitleDead;
    }

    @Override
    public void setForegroundTitle(final Color color) {
        this.lbTitleDead.setForeground(color);
    }
}
