package view.GUI.menu.concrete;

import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.menu.GUIMenu;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIMenuConcrete extends AbstractGUI implements GUIMenu {
    public static final int N_BUTTONS = 6;
    private final JLabel lbTitle;
    private final JTextField txfNamePlayer;
    private final List<ButtonID> links;

    public GUIMenuConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.txfNamePlayer = new JTextField();
        this.links = Stream.generate(ButtonID::new)
                .limit(N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    @Override
    public JTextField getTxfNamePlayer(){
        return this.txfNamePlayer;
    }

    @Override
    public ButtonID getButton(final int ind){
        return this.links.get(ind);
    }

    @Override
    public void setNameButtons(final List<String> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.links.get(i).setText(listName.get(i));
        }
    }

    @Override
    public void setIDButtons(final List<IdGUI> linksID) {
        for(int i = 0; i < N_BUTTONS; i++){
            this.links.get(i).setIdGUICurrent(this.getId());
            this.links.get(i).setIdGUINext(linksID.get(i));
        }
    }


    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.links.forEach(button -> button.setForeground(color));
    }

    @Override
    public void setFontGUITitle(final Font font){
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


    @Override
    public List<ButtonID> getButtonLinks() {
        return this.links;
    }
}
