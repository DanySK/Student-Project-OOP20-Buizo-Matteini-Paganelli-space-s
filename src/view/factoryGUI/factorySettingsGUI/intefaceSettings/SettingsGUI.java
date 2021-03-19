package view.factoryGUI.factorySettingsGUI.intefaceSettings;

import utilities.IdGUI;
import utilities.NameScoreboardGUI;
import view.factoryGUI.GUI;

import java.awt.*;
import java.util.List;

public interface SettingsGUI extends GUI {
    public void setTitleGUI(final String title);

    public void setFontTitlePanel(final Font font);

    public void setBtnBackID(final IdGUI intoID);

    public void setNameButtons(List<NameScoreboardGUI> listName);

}
