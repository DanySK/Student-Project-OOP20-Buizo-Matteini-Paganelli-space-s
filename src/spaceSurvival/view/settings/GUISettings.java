package spaceSurvival.view.settings;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.GUI.settings.Difficulty;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;

import javax.swing.*;
import java.util.List;

public interface GUISettings extends GUI, GraphicsGUISettings {

    public List<JButton> getBtnUnitSkin();

    public List<JRadioButton> getRadioBtnUnitDifficult();


    public void setUnitNames(final List<String> listName);

    public void setNameBtnBack(final String nameBtnBack);

    public void setSkinSpaceShip(final EngineImage imageEngine);

    public void setDifficult(final Difficulty difficulty);

    public void setBtnBackID(final ActionGUI mainAction, final ActionGUI action);
}
