package view.GUI.settings;

import model.MyJImage.JImageRateEngine;
import model.GUI.settings.Difficult;
import utilities.IdGUI;
import model.GUI.settings.NameSettingsGUI;
import view.GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public interface GUISettings extends GUI, GraphicsGUISettings {

    public void setNameComponent(final List<NameSettingsGUI> listName);

    public void setSkinSpaceShip(final JImageRateEngine imageEngine);

    public void setDifficult(final Difficult difficult);

    public List<JButton> getUnitSkin();

    public List<JRadioButton> getUnitDifficult();

    public void setBtnBackID(final IdGUI intoID);
}
