package spacesurvival.view.menu.concrete;

import spacesurvival.model.GUI.menu.EngineMenu;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.utilities.BtnAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIMenuConcrete extends AbstractGUI implements GUIMenu {
    private final JLabel lbTitle;
    private final JTextField txfNamePlayer;
    private final List<BtnAction> links;

    public GUIMenuConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.txfNamePlayer = new JTextField();
        this.links = Stream.generate(BtnAction::new)
                .limit(EngineMenu.N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public List<BtnAction> getBtnActionLinks() {
        return this.links;
    }


    @Override
    public void setNameButtons(final List<String> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.links.get(i).setText(listName.get(i));
        }
    }

    @Override
    public void setBtnActions(final ActionGUI mainAction, final List<ActionGUI> linksID) {
        for(int i = 0; i < linksID.size(); i++){
            this.links.get(i).setActionCurrent(mainAction);
            this.links.get(i).setActionNext(linksID.get(i));
        }
    }


    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.links.forEach(button -> button.setForeground(color));
    }

    @Override
    public void setFontTitleGUI(final Font font){
        this.lbTitle.setFont(font);
    }

    @Override
    public void setFontGUI(final Font font){
        this.txfNamePlayer.setFont(font);
        this.links.forEach(button -> button.setFont(font));
    }

    @Override
    public void setTitleGUI(final String title){
        this.lbTitle.setText(title);
    }

    @Override
    public void setColumnsNamePlayer(final int sizeColumn) {
        this.txfNamePlayer.setColumns(sizeColumn);
    }


    public BtnAction getButton(final int ind){
        return this.links.get(ind);
    }

    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public JTextField getTxfNamePlayer(){
        return this.txfNamePlayer;
    }
}
