package spacesurvival.view.settings;

import spacesurvival.model.EngineImage;
import spacesurvival.model.gui.settings.Difficulty;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.settings.utilities.JRadioDifficult;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;

public interface GUISettings extends GUI {

    List<JButton> getBtnUnitSkin();

    List<JRadioDifficult> getRadioBtnUnitDifficult();


    void setUnitNames(List<String> listName);

    void setDifficultNames(List<Difficulty> listDifficult);

    void setNameBtnBack(String nameBtnBack);

    void setSkinSpaceShip(EngineImage imageEngine);

    void setDifficult(Difficulty difficulty);

    void setBtnBackID(ActionGUI mainAction, ActionGUI action);


    void setForegroundGUI(Color color);

    void setFontGUITitle(Font font);

    void setFontTitleUnit(Font font);

    void setFontUnit(Font font);

    void setTitleGUI(String title);

    void setTransparentComponent();
}
