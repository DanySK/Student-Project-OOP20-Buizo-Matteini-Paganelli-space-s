package view.GUI.menu;

import utilities.IdGUI;
import model.GUI.menu.NameMenuGUI;
import view.GUI.GUI;

import java.util.List;

public interface GUIMenu extends GUI{

    public void setTitleGUI(final String title);

    public void setNameButtons(final List<NameMenuGUI> listNames);

    public void setIDButtons(final List<IdGUI> linksID);

    public void setBounds(int x, int y, int width, int height);

}
