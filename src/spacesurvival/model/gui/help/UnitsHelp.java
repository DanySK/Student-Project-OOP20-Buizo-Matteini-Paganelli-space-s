package spacesurvival.model.gui.help;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.path.Helps;
import spacesurvival.utilities.DesignJComponent;

import java.util.List;

public enum UnitsHelp {
    
    PANEL_MOVE(DesignJComponent.NAME_UNIT_HELP_MOVEMENT, List.of(
            new EngineImage(ScaleOf.ICON_HELP_PLURAL, EngineHelp.RECTANGLE.width, Helps.WASD),
            new EngineImage(ScaleOf.ICON_HELP_PLURAL, EngineHelp.RECTANGLE.width, Helps.ROW))),

    PANEL_SHOT(DesignJComponent.NAME_UNIT_HELP_SHOT, List.of(
            new EngineImage(ScaleOf.ICON_HELP_PLURAL, EngineHelp.RECTANGLE.width, Helps.SPACEBAR),
            new EngineImage(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.RECTANGLE.width, Helps.KEY_K))),

    PANEL_PAUSE(DesignJComponent.NAME_UNIT_HELP_PAUSE, List.of(
            new EngineImage(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.RECTANGLE.width, Helps.KEY_P),
            new EngineImage(ScaleOf.ICON_HELP_SINGULAR, EngineHelp.RECTANGLE.width, Helps.PAUSE_KEY)));

    private final String name;
    private final List<EngineImage> pathFiles;

    UnitsHelp(final String name, final List<EngineImage> pathFiles){
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
