package view.GUI.menu.concrete;

import utilities.IdGUI;
import model.GUI.menu.NameMenuGUI;
import view.GUI.AbstractGUI;
import view.GUI.menu.GUIMenu;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUIMenuConcrete extends AbstractGUI implements GUIMenu {
    private final JLabel lbTitle = new JLabel();
    private final JTextField txtName = new JTextField();
    private final List<ButtonID> buttons = Arrays.asList(new ButtonID(),
            new ButtonID(), new ButtonID(), new ButtonID(), new ButtonID(),new ButtonID());

    public GUIMenuConcrete(){
        super();
    }

    @Override
    public List<? extends JButton> getButtons(){
        return this.buttons;
    }
    @Override
    public List<ButtonID> getLinksButtons() {
        return this.buttons;
    }

    @Override
    public void setTitleGUI(final String title){
        this.lbTitle.setText(title);
    }
    @Override
    public void setNameButtons(List<NameMenuGUI> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.buttons.get(i).setText(listName.get(i).getName());
        }
    }
    @Override
    public void setIDButtons(List<IdGUI> linksID) {
        for(int i = 0; i < linksID.size(); i++){
            this.buttons.get(i).setCurrentGUIID(this.getId());
            this.buttons.get(i).setCommandIdGUI(linksID.get(i));
        }
    }

    @Override
    public void setAllFontNotLbTitle(final Font font){
        this.txtName.setFont(font);
        this.buttons.forEach(button -> button.setFont(font));
    }

    @Override
    public void setAllForeground(Color color) {
        this.lbTitle.setForeground(color);
        this.buttons.forEach(button -> button.setForeground(color));
    }

    @Override
    public void setFontLbTitle(final Font font){
        this.lbTitle.setFont(font);
    }

    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public JTextField getTxtName(){
        return this.txtName;
    }

    public void addButton(final int nBtn) {
        for (int i = 0; i < nBtn; i++) {
            this.buttons.add(new ButtonID());
        }
    }

    public ButtonID getButton(final int id){
        return this.buttons.get(id);
    }

}
