package spaceSurvival.model.GUI.pause;

import spaceSurvival.utilities.IdGUI;

public enum LinksPause {
    RESUME_BUTTON("Resume", IdGUI.ID_BACK),
    SOUND_BUTTON("Sound", IdGUI.ID_SOUND),
    HELP_BUTTON("Help", IdGUI.ID_HELP),
    QUIT_BUTTON("Quit", IdGUI.ID_QUIT);

    private final String name;
    private final IdGUI idGUI;

    private LinksPause(final String name, final IdGUI idGUI){
        this.name = name;
        this.idGUI = idGUI;
    }

    public String getName(){
        return this.name;
    }

    public IdGUI getIdGUI(){
        return this.idGUI;
    }
}
