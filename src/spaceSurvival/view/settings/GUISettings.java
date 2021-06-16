package spaceSurvival.view.settings;

import spaceSurvival.model.EngineImage;
import spaceSurvival.model.GUI.settings.Difficulty;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.settings.utilities.JRadioDifficult;

import javax.swing.*;
import java.util.List;

public interface GUISettings extends GUI, GraphicsGUISettings {

    public List<JButton> getBtnUnitSkin();

    public List<JRadioDifficult> getRadioBtnUnitDifficult();


    public void setUnitNames(final List<String> listName);

    public void setDifficultNames(final List<Difficulty> listDifficult);

    public void setNameBtnBack(final String nameBtnBack);

    public void setSkinSpaceShip(final EngineImage imageEngine);

    public void setDifficult(final Difficulty difficulty);

    public void setBtnBackID(final ActionGUI mainAction, final ActionGUI action);
}
