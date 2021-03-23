package view.factoryGUI.factoryMenuGUI.intefaceMenu;

import utilities.IdGUI;
import model.factoryGUI.menuGUI.NameMenuGUI;
import view.factoryGUI.GUI;

import java.util.List;

public interface MenuGUI extends GUI{

    public void setTitleGUI(final String title);

    public void setNameButtons(final List<NameMenuGUI> listNames);

    public void setIDButtons(final List<IdGUI> linksID);

    public void setBounds(int x, int y, int width, int height);

}
