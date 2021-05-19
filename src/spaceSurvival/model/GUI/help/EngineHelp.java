package spaceSurvival.model.GUI.help;

import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.utilities.DesignTitleGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class EngineHelp implements EngineGUI {
    public static final Rectangle DIMENSION = Screen.RECTANGLE_MEDIUM;

    private final IdGUI id;
    private final IdGUI linkBack;

    private final List<UnitsHelp> listNameHelpUnits;
    private final List<String> listName;

    private Visibility visibility;

    public EngineHelp(){
        this.id = IdGUI.ID_HELP;
        this.linkBack = IdGUI.ID_BACK;
        this.listName = List.of(DesignJComponent.STRING_BACK_BUTTON);
        this.listNameHelpUnits = Arrays.asList(UnitsHelp.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public IdGUI getId() {
        return this.id;
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
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<IdGUI> getLinks() {
        return List.of(this.linkBack);
    }


    public String getTitle() {
        return DesignTitleGUI.TITLE_HELP;
    }

    public IdGUI getBackLink(){
        return this.linkBack;
    }

    public List<String> getListNameHelpUnits() {
        return this.listNameHelpUnits.stream().map(UnitsHelp::getName).collect(Collectors.toList());
    }

    public List<String> getListNameButtons() {
        return this.listName;
    }

    public List<EngineImage> getPathIconUnit(final String unitName){
        return this.listNameHelpUnits.stream().filter(unit -> unit.getName().contentEquals(unitName))
                .map(UnitsHelp::getPathFiles)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
