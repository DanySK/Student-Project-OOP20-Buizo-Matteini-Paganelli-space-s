package spaceSurvival.view.help.concrete;

import spaceSurvival.model.ImageDesign;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.AbstractGUI;
import spaceSurvival.view.help.GUIHelp;
import spaceSurvival.view.help.utilities.UnitHelp;
import spaceSurvival.view.utilities.BtnAction;

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
    private final BtnAction btnBack;

    public GUIHelpConcrete() {
        super();
        this.lbTitle = new JLabel();
        this.btnBack = new BtnAction();
        this.unitHelps = Stream.generate(UnitHelp::new)
                .limit(N_UNIT_HELP).collect(Collectors.toList());
    }

    @Override
    public List<BtnAction> getButtonLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public void setIdBtnBack(final ActionGUI idBtnBack) {
        this.btnBack.setActionCurrent(super.getMainAction());
        this.btnBack.setActionNext(idBtnBack);
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
    public void addIconInUnitHelp(final String panelName, final List<ImageDesign> imageDesigns) {
        this.unitHelps.stream().filter(unit -> unit.getTitleUnit().contentEquals(panelName))
                .forEach(unit -> imageDesigns.forEach(engine -> {
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

    public BtnAction getBtnBack(){
        return this.btnBack;
    }

    public List<UnitHelp> getUnitHelps(){
        return this.unitHelps;
    }
}
