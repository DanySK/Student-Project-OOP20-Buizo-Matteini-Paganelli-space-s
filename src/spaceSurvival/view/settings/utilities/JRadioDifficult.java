package spaceSurvival.view.settings.utilities;

import spaceSurvival.model.GUI.settings.Difficulty;

import javax.swing.*;

public class JRadioDifficult extends JRadioButton {
    private Difficulty difficulty;

    public JRadioDifficult(){
        super();
        super.setOpaque(false);
        super.setOpaque(false);
        super.setFocusable(false);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
