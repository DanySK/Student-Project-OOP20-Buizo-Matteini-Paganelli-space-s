package spacesurvival.view.help.concrete;

import spacesurvival.model.EngineImage;
import spacesurvival.model.gui.help.EngineHelp;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.help.GUIHelp;
import spacesurvival.view.help.utilities.UnitHelp;
import spacesurvival.view.utilities.ButtonLink;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIHelpConcrete extends AbstractGUI implements GUIHelp {
    private final JLabel lbTitle;
    private final List<UnitHelp> unitHelps;
    private final ButtonLink btnBack;

    public GUIHelpConcrete() {
        super();
        this.lbTitle = new JLabel();
        this.btnBack = new ButtonLink();
        this.unitHelps = Stream.generate(UnitHelp::new)
                .limit(EngineHelp.N_UNIT).collect(Collectors.toList());
    }

    @Override
    public List<ButtonLink> getBtnActionLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public void setActionBtnBack(final LinkActionGUI mainAction, final LinkActionGUI intoID) {
        this.btnBack.setCurrentLink(mainAction);
        this.btnBack.setNextLink(intoID);
    }

    @Override
    public void setNameUnit(final List<String> listName){
        AtomicInteger i = new AtomicInteger();
        this.unitHelps.forEach(unit -> unit.setTitleUnit(listName.get(i.getAndIncrement())));
    }

    @Override
    public void setBtnNames(final List<String> listName) {
        int i = 0;
        this.btnBack.setText(listName.get(i));
    }

    @Override
    public void addNameAndIconInUnit(final String panelName, final List<EngineImage> engineImages) {
        this.unitHelps.stream().filter(unit -> unit.getTitleUnit().contentEquals(panelName))
                .forEach(unit -> engineImages.forEach(engine -> {
                    engine.setScale(engine.getScaleOf(), super.getWidth());
                    unit.addIconUnit(engine);
                }));
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

    public ButtonLink getBtnBack(){
        return this.btnBack;
    }

    public List<UnitHelp> getUnitHelps(){
        return this.unitHelps;
    }
}
