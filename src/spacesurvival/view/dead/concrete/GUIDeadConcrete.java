package spacesurvival.view.dead.concrete;

import spacesurvival.model.gui.dead.EngineDead;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.dead.GUIDead;
import spacesurvival.view.utilities.BtnAction;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JLabel;

public class GUIDeadConcrete extends AbstractGUI implements GUIDead {

    final private JLabel lbTitleDead;
    final private List<BtnAction> links;

    public GUIDeadConcrete() {
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
        for (int i = 0; i < listNames.size(); i++) {
            this.links.get(i).setText(listNames.get(i));
        }
    }

    @Override
    public void setBtnActions(final LinkActionGUI mainAction, final List<LinkActionGUI> actions) {
        for (int i = 0; i < actions.size(); i++) {
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
