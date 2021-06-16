package spacesurvival.view.pause.concrete;

import spacesurvival.model.GUI.pause.EnginePause;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.pause.GUIPause;
import spacesurvival.view.utilities.BtnAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIPauseConcrete extends AbstractGUI implements GUIPause {
    private final JLabel lbTitle;
    private final List<BtnAction> links;

    public GUIPauseConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.links = Stream.generate(BtnAction::new)
                .limit(EnginePause.N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public List<BtnAction> getBtnActionLinks() {
        return this.links;
    }


    @Override
    public BtnAction getActionBtn(int ind) {
        return this.links.get(ind);
    }

    @Override
    public void setNameButtons(final List<String> listNames) {
        for(int i = 0; i < EnginePause.N_BUTTONS; i++){
            this.links.get(i).setText(listNames.get(i));
        }
    }

    @Override
    public void setActionButtons(final ActionGUI mainAction, final List<ActionGUI> linksID) {
        for(int i = 0; i < linksID.size(); i++){
            this.links.get(i).setActionCurrent(mainAction);
            this.links.get(i).setActionNext(linksID.get(i));
        }
    }


    @Override
    public void setFontGUITitle(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.links.forEach(btn -> btn.setForeground(color));
    }

    @Override
    public void setFontButtons(final Font font) {
        this.links.forEach(link -> link.setFont(font));
    }

    @Override
    public void setBackgroundButtons(final Color color) {
        this.links.forEach(btn -> btn.setBackground(color));
    }


    public JLabel getLbTitle(){
        return this.lbTitle;
    }

}
