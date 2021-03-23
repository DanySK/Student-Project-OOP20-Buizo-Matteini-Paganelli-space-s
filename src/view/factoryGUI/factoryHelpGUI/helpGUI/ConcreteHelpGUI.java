package view.factoryGUI.factoryHelpGUI.helpGUI;

import model.MyJImage.MyJImageEngine;
import utilities.IdGUI;
import view.factoryGUI.AbstractGUI;
import view.factoryGUI.factoryHelpGUI.interfaceHelp.HelpGUI;
import view.factoryGUI.factoryHelpGUI.utilities.PanelHelp;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteHelpGUI extends AbstractGUI implements HelpGUI {
    private JLabel lbTitle = new JLabel();
    private List<PanelHelp> helpPanels = Arrays.asList(new PanelHelp(),
            new PanelHelp(),
            new PanelHelp());

    private ButtonID btnBack = new ButtonID();

    public ConcreteHelpGUI() {
        super();
    }

    @Override
    public void setAllForeground(final Color color){
        this.lbTitle.setForeground(color);
        this.helpPanels.forEach(panel -> panel.setForegroundLbTitle(color));
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontLbTitle(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setAllFontNotLbTitle(final Font font) {
        this.helpPanels.forEach(panel -> panel.setFontLbTitle(font));
        this.btnBack.setFont(font);
    }

    @Override
    public void setTitleGUI(String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setBtnBackID(IdGUI intoID) {
        this.btnBack.setCommandIdGUI(intoID);
    }

    @Override
    public void setHelpPanelsName(List<String> listName){
        AtomicInteger i = new AtomicInteger();
        this.helpPanels.forEach(panel -> panel.setLbTitle(listName.get(i.getAndIncrement())));
    }

    @Override
    public void setButtonsName(List<String> listName) {
        int i = 0;
        this.btnBack.setText(listName.get(i));
    }

    @Override
    public void setImageInPanelHelp(String panelName, final List<MyJImageEngine> pathImg) {
        this.helpPanels.stream().filter(panel -> panel.getLbTitle().contains(panelName))
                .forEach(panel -> pathImg.forEach(img -> panel.addHelpImage(img.getWidth(), img.getHeight(), img.getPath())));
    }

    @Override
    public List<? extends JButton> getButtons() {
        return List.of(this.btnBack);
    }

    @Override
    public List<ButtonID> getLinksButtons() {
        return List.of(this.btnBack);
    }


    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public ButtonID getBtnBack(){
        return this.btnBack;
    }

    public List<PanelHelp> getHelpPanels(){
        return this.helpPanels;
    }
}
