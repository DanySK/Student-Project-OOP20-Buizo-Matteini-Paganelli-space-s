package controller.GUI;

import model.GUI.scoreboard.EngineScoreboard;
import view.GUI.scoreboard.GUIScoreboard;

public class CtrlScoreboard {
    private GUIScoreboard scoreboardGUI;
    private EngineScoreboard scoreboardEngine;

    public CtrlScoreboard(final GUIScoreboard scoreboardGUI, final EngineScoreboard scoreboardEngine){
        this.scoreboardGUI = scoreboardGUI;
        this.scoreboardEngine = scoreboardEngine;
        this.initScoreboard();
    }

    private void initScoreboard(){
        this.scoreboardGUI.setId(this.scoreboardEngine.getId());
        this.scoreboardGUI.setTitleGUI(this.scoreboardEngine.getTitleGUI());
        this.scoreboardGUI.setNameButtons(this.scoreboardEngine.getListName());
        this.scoreboardGUI.setBtnBackID(this.scoreboardEngine.getBackLink());
        this.scoreboardGUI.setVisible(this.scoreboardEngine.getState());
    }

}
