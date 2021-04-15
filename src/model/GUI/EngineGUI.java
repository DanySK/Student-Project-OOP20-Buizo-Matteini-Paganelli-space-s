package model.GUI;

import utilities.IdGUI;

import java.util.List;

public interface EngineGUI {

    public IdGUI getId();

    public Visibility getVisibility();

    public void setVisibility(final Visibility state);

    public boolean isVisible();

    public List<IdGUI> getLinks();
}
