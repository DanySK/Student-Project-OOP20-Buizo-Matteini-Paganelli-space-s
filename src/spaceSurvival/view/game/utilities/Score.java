package spacesurvival.view.game.utilities;

import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    private final JLabel stringScore;
    private final JLabel score;

    public Score(){
        super(new FlowLayout()); {{ setOpaque(false); }}

        this.stringScore = new JLabel(DesignGraphics.SCORE_STRING);
        this.score = new JLabel();

        super.add(FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(java.util.List.of(
                this.stringScore, this.score), FactoryGUIs.MAX_INSET));
    }

    public void setScore(final long score){
        this.score.setText(Long.toString(score));
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
