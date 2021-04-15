package model.GUI.help;

import model.GUI.Visibility;
import utilities.DesignTitleGUI;
import model.MyJImage.JImageRateEngine;
import model.GUI.EngineGUI;
import utilities.DesignJComponent;
import utilities.IdGUI;

import java.util.*;
import java.util.stream.Collectors;

public class EngineHelp implements EngineGUI {
    private static final IdGUI Id = IdGUI.ID_HELP;
    private static final IdGUI linkBack = IdGUI.ID_BACK;

    private final List<UnitsHelp> listNameHelpUnits;
    private final List<String> listName;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineHelp(){
        this.listName = List.of(DesignJComponent.STRING_BACK_BUTTON);
        this.listNameHelpUnits = Arrays.asList(UnitsHelp.values());
    }

    @Override
    public IdGUI getId() {
        return Id;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public List<IdGUI> getLinks() {
        return List.of(linkBack);
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    public String getTitleGUI() {
        return DesignTitleGUI.TITLE_MENU;
    }

    public IdGUI getBackLink(){
        return linkBack;
    }

    public List<String> getListNameHelpUnits() {
        return this.listNameHelpUnits.stream().map(UnitsHelp::getName).collect(Collectors.toList());
    }

    public List<String> getListNameButtons() {
        return this.listName;
    }

    public List<JImageRateEngine> getPathIconUnit(final String unitName){
        return this.listNameHelpUnits.stream().filter(unit -> unit.getName().contentEquals(unitName))
                .map(UnitsHelp::getPathFiles)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
