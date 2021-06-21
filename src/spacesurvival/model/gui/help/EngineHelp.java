package spacesurvival.model.gui.help;

import spacesurvival.model.gui.Visibility;
import spacesurvival.model.EngineImage;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class EngineHelp implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static final int N_UNIT = 3;
    public static final String TITLE = "HELP";

    private final LinkActionGUI mainAction;
    private final LinkActionGUI actionBack;

    private final List<UnitsHelp> listNameUnits;
    private final List<String> listName;

    private Visibility visibility;

    public EngineHelp(){
        this.mainAction = LinkActionGUI.ID_HELP;
        this.actionBack = LinkActionGUI.ID_BACK;
        this.listName = List.of(DesignJComponent.STRING_BACK_BUTTON);
        this.listNameUnits = Arrays.asList(UnitsHelp.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public LinkActionGUI getMainAction() {
        return this.mainAction;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public List<LinkActionGUI> getLinks() {
        return List.of(this.actionBack);
    }

    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }


    public String getTitle() {
        return TITLE;
    }

    public LinkActionGUI getBackLink(){
        return this.actionBack;
    }

    public List<String> getListNameUnits() {
        return this.listNameUnits.stream().map(UnitsHelp::getName).collect(Collectors.toList());
    }

    public List<String> getListNameButtons() {
        return this.listName;
    }

    public List<EngineImage> getPathIconUnit(final String unitName){
        return this.listNameUnits.stream().filter(unit -> unit.getName().contentEquals(unitName))
                .map(UnitsHelp::getPathFiles)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
