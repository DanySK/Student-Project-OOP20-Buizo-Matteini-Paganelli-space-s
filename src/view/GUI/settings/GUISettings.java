package view.GUI.settings;

import model.image.EngineImage;
import model.GUI.settings.Difficulty;
import utilities.IdGUI;
import view.GUI.GUI;

import javax.swing.*;
import java.util.List;

public interface GUISettings extends GUI, GraphicsGUISettings {

    public void setNameUnits(final List<String> listName);

    public void setNameBtnBack(final String nameBtnBack);

    public void setSkinSpaceShip(final EngineImage imageEngine);

    public void setDifficult(final Difficulty difficulty);

    public List<JButton> getUnitSkin();

    public List<JRadioButton> getUnitDifficult();

    public void setBtnBackID(final IdGUI intoID);
}
