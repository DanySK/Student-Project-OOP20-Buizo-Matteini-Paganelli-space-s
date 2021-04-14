package view.GUI.help.concrete;

import model.MyJImage.JImageRateEngine;
import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.help.GUIHelp;
import view.GUI.help.utilities.UnitHelp;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIHelpConcrete extends AbstractGUI implements GUIHelp {
    private static final int N_UNIT_HELP = 3;
    private final JLabel lbTitle;
    private final List<UnitHelp> unitHelps;
    private final ButtonID btnBack;

    public GUIHelpConcrete() {
        super();
        this.lbTitle = new JLabel();
        this.btnBack = new ButtonID();
        this.unitHelps = Stream.generate(UnitHelp::new)
                .limit(N_UNIT_HELP).collect(Collectors.toList());
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public void setBtnBackID(final IdGUI intoID) {
        this.btnBack.setIdGUINext(intoID);
    }

    @Override
    public void setNameUnitHelps(final List<String> listName){
        AtomicInteger i = new AtomicInteger();
        this.unitHelps.forEach(unit -> unit.setTitleUnit(listName.get(i.getAndIncrement())));
    }

    @Override
    public void setNameButtons(final List<String> listName) {
        int i = 0;
        this.btnBack.setText(listName.get(i));
    }

    @Override
    public void addIconInUnitHelp(final String panelName, final List<JImageRateEngine> pathImg) {
        this.unitHelps.stream().filter(unit -> unit.getTitleUnit().contentEquals(panelName))
                .forEach(unit -> pathImg.forEach(img -> unit.addIconUnit(img.getPathImg(), img.getRate())));
    }


    @Override
    public void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setForegroundGUI(final Color color){
        this.lbTitle.setForeground(color);
        this.unitHelps.forEach(unit -> unit.setForegroundUnit(color));
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontTitleGUI(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setFontGUI(final Font font) {
        this.unitHelps.forEach(unit -> unit.setFontTitleUnit(font));
        this.btnBack.setFont(font);
    }


    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public ButtonID getBtnBack(){
        return this.btnBack;
    }

    public List<UnitHelp> getUnitHelps(){
        return this.unitHelps;
    }
}
