package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    private final JLabel stringScore;
    private final JLabel score;

    public Score(){
        super(new FlowLayout()); {{ setOpaque(false); }}

        this.stringScore = new JLabel(DesignGraphics.SCORE_STRING);
        this.score = new JLabel(DesignGraphics.INIT_SCORE_STRING);

        super.add(FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(java.util.List.of(
                this.stringScore, this.score), FactoryGUIs.MAX_INSET));
    }

    public void setScore(final int score){
        this.score.setText(Integer.toString(score));
    }

    public void setScore(final String score){
        this.score.setText(score);
    }

    public void setFontAll(final Font font){
        this.stringScore.setFont(font);
        this.score.setFont(font);
    }

    public void setForegroundAll(final Color color){
        this.stringScore.setForeground(color);
        this.score.setForeground(color);
    }
}
