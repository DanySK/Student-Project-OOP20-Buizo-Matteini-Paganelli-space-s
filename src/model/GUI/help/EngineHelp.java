package model.GUI.help;

import model.MyJImage.JImageRateEngine;
import model.GUI.EngineGUI;
import utilities.IdGUI;

import java.util.*;
import java.util.stream.Collectors;

public class EngineHelp implements EngineGUI {
    private static final String TITLE_GUI = "HELP";
    private static final IdGUI Id = IdGUI.ID_HELP;
    private static final IdGUI linkBack = IdGUI.ID_BACK;

    private final List<HelpNameButtons> listNameButtons;
    private final List<UnitsHelp> listNameHelpUnits;

    private boolean state = false;

    public EngineHelp(){
        this.listNameButtons = Arrays.asList(HelpNameButtons.values());
        this.listNameHelpUnits =  Arrays.asList(UnitsHelp.values());
    }

    @Override
    public IdGUI getId() {
        return Id;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public void setState(final boolean state) {
        this.state = state;
    }

    @Override
    public List<IdGUI> getLinks() {
        return List.of(linkBack);
    }

    public String getTitleGUI() {
        return TITLE_GUI;
    }

    public IdGUI getBackLink(){
        return linkBack;
    }

    public List<String> getListNameHelpUnits() {
        return this.listNameHelpUnits.stream().map(UnitsHelp::getName).collect(Collectors.toList());
    }

    public List<String> getListNameButtons() {
        return this.listNameButtons.stream().map(HelpNameButtons::getName).collect(Collectors.toList());
    }

    public List<JImageRateEngine> getPathIconUnit(final String unitName){
        return this.listNameHelpUnits.stream().filter(unit -> unit.getName().contentEquals(unitName))
                .map(UnitsHelp::getPathFiles)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
