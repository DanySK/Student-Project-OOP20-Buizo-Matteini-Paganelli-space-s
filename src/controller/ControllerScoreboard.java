package controller;

import model.factoryGUI.scoreboardGUI.ScoreboardEngine;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.ScoreboardGUI;

public class ControllerScoreboard {
    private ScoreboardGUI scoreboardGUI;
    private ScoreboardEngine scoreboardEngine;

    public ControllerScoreboard(final ScoreboardGUI scoreboardGUI, final ScoreboardEngine scoreboardEngine){
        this.scoreboardGUI = scoreboardGUI;
        this.scoreboardEngine = scoreboardEngine;
        this.initScoreboard();
    }

    private void initScoreboard(){
        this.scoreboardGUI.setId(this.scoreboardEngine.getId());
        this.scoreboardGUI.setTitleGUI(this.scoreboardEngine.getTitleGUI());
        this.scoreboardGUI.setNameButtons(this.scoreboardEngine.getListName());
        this.scoreboardGUI.setBtnBackID(this.scoreboardEngine.getLink());
        this.scoreboardGUI.setVisible(this.scoreboardEngine.getState());
    }

}
