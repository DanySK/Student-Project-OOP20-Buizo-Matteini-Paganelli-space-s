package spacesurvival.view.menu.concrete;

import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.utilities.BtnAction;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIMenuConcrete extends AbstractGUI implements GUIMenu {
    private static final long serialVersionUID = 1L;

    private final JLabel lbTitle;
    private final JTextField txfNamePlayer;
    private final List<BtnAction> links;

    public GUIMenuConcrete() {
        super();
        this.lbTitle = new JLabel();
        this.txfNamePlayer = new JTextField();
        this.links = Stream.generate(BtnAction::new)
                .limit(EngineMenu.N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public final List<BtnAction> getBtnActionLinks() {
        return this.links;
    }


    @Override
    public final void setNameButtons(final List<String> listName) {
        for (int i = 0; i < listName.size(); i++) {
            this.links.get(i).setText(listName.get(i));
        }
    }

    @Override
    public final void setBtnActions(final ActionGUI mainAction, final List<ActionGUI> linksID) {
        for (int i = 0; i < linksID.size(); i++) {
            this.links.get(i).setActionCurrent(mainAction);
            this.links.get(i).setActionNext(linksID.get(i));
        }
    }


    public final void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.links.forEach(button -> button.setForeground(color));
    }

    @Override
    public final void setFontTitleGUI(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public final void setFontGUI(final Font font) {
        this.txfNamePlayer.setFont(font);
        this.links.forEach(button -> button.setFont(font));
    }

    @Override
    public final void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public final void setColumnsNamePlayer(final int sizeColumn) {
        this.txfNamePlayer.setColumns(sizeColumn);
    }


    public final BtnAction getButton(final int ind) {
        return this.links.get(ind);
    }

    public final JLabel getLbTitle() {
        return this.lbTitle;
    }

    public final JTextField getTxfNamePlayer() {
        return this.txfNamePlayer;
    }
}
