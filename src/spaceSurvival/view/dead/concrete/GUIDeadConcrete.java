package spaceSurvival.view.dead.concrete;

import spaceSurvival.model.GUI.dead.EngineDead;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.AbstractGUI;
import spaceSurvival.view.dead.GUIDead;
import spaceSurvival.view.utilities.BtnAction;

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
            this.links.get(i).setActionCurrent(actions.get(i));
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


    public JLabel getLbTitleDead() {
        return this.lbTitleDead;
    }

    @Override
    public void setForegroundTitle(final Color color) {
        this.lbTitleDead.setForeground(color);
    }


}
