package spaceSurvival.view.GUI.settings;

import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.GUI.settings.Difficulty;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;

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
