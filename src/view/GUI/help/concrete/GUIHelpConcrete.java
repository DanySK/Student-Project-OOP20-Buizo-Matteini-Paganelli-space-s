package view.GUI.help.concrete;

import model.MyJImage.JImageRateEngine;
import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.help.GUIHelp;
import view.GUI.help.utilities.HelpPanel;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GUIHelpConcrete extends AbstractGUI implements GUIHelp {
    private JLabel lbTitle = new JLabel();
    private List<HelpPanel> helpPanels = Arrays.asList(new HelpPanel(),
            new HelpPanel(),
            new HelpPanel());

    private ButtonID btnBack = new ButtonID();

    public GUIHelpConcrete() {
        super();
    }


    public void setAllForeground(final Color color){
        this.lbTitle.setForeground(color);
        this.helpPanels.forEach(panel -> panel.setForegroundLbTitle(color));
        this.btnBack.setForeground(color);
    }


    public void setFontLbTitle(final Font font) {
        this.lbTitle.setFont(font);
    }

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
        this.btnBack.setIdGUINext(intoID);
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
    public void setImageInPanelHelp(String panelName, final List<JImageRateEngine> pathImg) {
        this.helpPanels.stream().filter(panel -> panel.getLbTitle().contains(panelName))
                .forEach(panel -> pathImg.forEach(img -> panel.addHelpImage(img.getPathImg(), img.getRate())));
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnBack);
    }


    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public ButtonID getBtnBack(){
        return this.btnBack;
    }

    public List<HelpPanel> getHelpPanels(){
        return this.helpPanels;
    }
}
