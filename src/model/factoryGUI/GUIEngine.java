package model.factoryGUI;

import utilities.IdGUI;

import java.util.List;

public interface GUIEngine {

    public IdGUI getId();

    public boolean getState();

    public void setState(final boolean state);

    public void changeState();

    public String getTitleGUI();

    public IdGUI getLink();

    public List<IdGUI> getLinks();



}
