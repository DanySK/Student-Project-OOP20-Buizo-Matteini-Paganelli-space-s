package view.GUI.help;

import model.MyJImage.JImageRateEngine;
import utilities.IdGUI;
import view.GUI.GUI;

import java.util.List;

public interface GUIHelp extends GUI {
    public void setTitleGUI(final String title);

    public void setBtnBackID(final IdGUI intoID);

    public void setHelpPanelsName(List<String> listName);

    public void setButtonsName(List<String> listName);

    public void setImageInPanelHelp(final String panelName, final List<JImageRateEngine> pathImg);


}
