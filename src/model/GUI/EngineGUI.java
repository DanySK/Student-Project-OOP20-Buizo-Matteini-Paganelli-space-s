package model.GUI;

import utilities.IdGUI;

import java.util.List;

public interface EngineGUI {

    public IdGUI getId();

    public boolean getState();

    public void setState(final boolean state);

    public void changeState();

    public String getTitleGUI();

    public IdGUI getLink();

    public List<IdGUI> getLinks();



}
