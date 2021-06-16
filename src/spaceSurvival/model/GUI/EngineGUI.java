package spaceSurvival.model.GUI;

import spaceSurvival.utilities.ActionGUI;

import java.awt.*;
import java.util.List;

public interface EngineGUI {

    public ActionGUI getMainAction();

    public Rectangle getRectangle();

    public Visibility getVisibility();

    public List<ActionGUI> getLinks();


    public void setVisibility(final Visibility state);

    public boolean isVisible();

}
