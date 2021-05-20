package spaceSurvival.model.GUI.help;

import spaceSurvival.model.image.EngineImage;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.DesignJComponent;

import java.util.List;

public enum UnitsHelp {
    PANEL_MOVE(DesignJComponent.NAME_UNIT_HELP_MOVEMENT, List.of(
            new EngineImage(ScaleOf.ICON_HELP_PLURAL, EngineHelp.DIMENSION.width, Icon.WASD),
            new EngineImage(ScaleOf.ICON_HELP_PLURAL, EngineHelp.DIMENSION.width, Icon.ROW))),

    PANEL_SHOT(DesignJComponent.NAME_UNIT_HELP_SHOT, List.of(
            new EngineImage(ScaleOf.ICON_HELP_PLURAL, EngineHelp.DIMENSION.width, Icon.SPACEBAR),
            new EngineImage(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.DIMENSION.width, Icon.KEY_K))),

    PANEL_PAUSE(DesignJComponent.NAME_UNIT_HELP_PAUSE, List.of(
            new EngineImage(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.DIMENSION.width, Icon.KEY_P),
            new EngineImage(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.DIMENSION.width, Icon.PAUSE_KEY)));

    private final String name;

    private final List<EngineImage> pathFiles;

    private UnitsHelp(final String name, final List<EngineImage> pathFiles){
        this.name = name;
        this.pathFiles = pathFiles;
    }

    public String getName(){
        return this.name;
    }

    public List<EngineImage> getPathFiles(){
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
