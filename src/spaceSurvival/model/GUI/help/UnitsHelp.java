package spaceSurvival.model.GUI.help;

import spaceSurvival.model.ImageDesign;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.DesignJComponent;

import java.util.List;

public enum UnitsHelp {
    PANEL_MOVE(DesignJComponent.NAME_UNIT_HELP_MOVEMENT, List.of(
            new ImageDesign(ScaleOf.ICON_HELP_PLURAL, EngineHelp.RECTANGLE.width, Icon.WASD),
            new ImageDesign(ScaleOf.ICON_HELP_PLURAL, EngineHelp.RECTANGLE.width, Icon.ROW))),

    PANEL_SHOT(DesignJComponent.NAME_UNIT_HELP_SHOT, List.of(
            new ImageDesign(ScaleOf.ICON_HELP_PLURAL, EngineHelp.RECTANGLE.width, Icon.SPACEBAR),
            new ImageDesign(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.RECTANGLE.width, Icon.KEY_K))),

    PANEL_PAUSE(DesignJComponent.NAME_UNIT_HELP_PAUSE, List.of(
            new ImageDesign(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.RECTANGLE.width, Icon.KEY_P),
            new ImageDesign(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.RECTANGLE.width, Icon.PAUSE_KEY)));

    private final String name;

    private final List<ImageDesign> pathFiles;

    private UnitsHelp(final String name, final List<ImageDesign> pathFiles){
        this.name = name;
        this.pathFiles = pathFiles;
    }

    public String getName(){
        return this.name;
    }

    public List<ImageDesign> getPathFiles(){
        return this.pathFiles;
    }

    @Override
    public String toString() {
        return "HelpNamePanels{" +
                "name='" + name + '\'' +
                ", pathFiles=" + pathFiles +
                '}';
    }
}
