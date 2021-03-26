package view.factoryGUI.factorySettingsGUI.intefaceSettings;

import model.MyJImage.JImageRateEngine;
import model.MyJImage.MyJImageEngine;
import model.factoryGUI.settingsGUI.Difficult;
import utilities.IdGUI;
import model.factoryGUI.settingsGUI.NameSettigsGUI;
import view.factoryGUI.GUI;
import view.utilities.JImageRate;

import java.awt.*;
import java.util.List;

public interface SettingsGUI extends GUI {
    public void setTitleGUI(final String title);

    public void setFontTitlePanel(final Font font);

    public void setBtnBackID(final IdGUI intoID);

    public void setNameButtons(final List<NameSettigsGUI> listName);

    public void setSkinSpaceShip(final JImageRateEngine imageEngine);

    public void setDifficult(final Difficult difficult);
}
