package view.factoryGUI.factoryHelpGUI;

import model.MyJImage.JImageRateEngine;
import model.MyJImage.MyJImageEngine;
import utilities.IdGUI;
import view.factoryGUI.GUI;

import java.util.List;

public interface HelpGUI extends GUI {
    public void setTitleGUI(final String title);

    public void setBtnBackID(final IdGUI intoID);

    public void setHelpPanelsName(List<String> listName);

    public void setButtonsName(List<String> listName);

    public void setImageInPanelHelp(final String panelName, final List<JImageRateEngine> pathImg);


}
