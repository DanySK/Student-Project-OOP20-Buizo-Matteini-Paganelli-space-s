package spacesurvival.view.dead.concrete;

import spacesurvival.model.GUI.dead.EngineDead;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.dead.GUIDead;
import spacesurvival.view.utilities.BtnAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIDeadConcrete extends AbstractGUI implements GUIDead {

    private JLabel lbTitleDead;
    private List<BtnAction> links;

    public GUIDeadConcrete(){
        super();
        this.lbTitleDead = new JLabel();
        this.links = Stream.generate(BtnAction::new)
                .limit(EngineDead.N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public List<BtnAction> getBtnActionLinks() {
        return this.links;
    }


    @Override
    public void setNameButtons(final List<String> listNames) {
        for(int i = 0; i < listNames.size(); i++){
            this.links.get(i).setText(listNames.get(i));
        }
    }

    @Override
    public void setBtnActions(final ActionGUI mainAction, final List<ActionGUI> actions) {
        for(int i = 0; i < actions.size(); i++){
            this.links.get(i).setActionCurrent(mainAction);
            this.links.get(i).setActionNext(actions.get(i));
        }
    }


    @Override
    public void setFontTitleGUI(final Font font) {
        this.lbTitleDead.setFont(font);
    }

    @Override
    public void setTitleGUI(final String titleGUI) {
        this.lbTitleDead.setText(titleGUI);
    }

    @Override
    public void setForegroundTitle(final Color color) {
        this.lbTitleDead.setForeground(color);
    }

    @Override
    public void setFontGUI(final Font font) {
        this.links.forEach(link -> link.setFont(font));
    }

    @Override
    public void setForegroundGUI(final Color color) {
        this.links.forEach(link -> link.setForeground(color));
    }

    public JLabel getLbTitleDead() {
        return this.lbTitleDead;
    }
}
