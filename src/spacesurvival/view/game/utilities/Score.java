package spacesurvival.view.game.utilities;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import spacesurvival.view.utilities.GraphicsLayoutUtils;
import spacesurvival.view.utilities.FactoryGUIs;

public class Score extends JPanel {
    private final JLabel stringScore;
    private final JLabel score;

    public Score() {
        super(new FlowLayout()); {{ setOpaque(false); }}

        this.stringScore = new JLabel(GraphicsLayoutUtils.SCORE_STRING);
        this.score = new JLabel();

        super.add(FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(java.util.List.of(
                this.stringScore, this.score), FactoryGUIs.INSET_H2));
    }

    public void setScore(final long score) {
        this.score.setText(Long.toString(score));
    }

    public void setScore(final String score) {
        this.score.setText(score);
    }

    public void setFontAll(final Font font) {
        this.stringScore.setFont(font);
        this.score.setFont(font);
    }

    public void setForegroundAll(final Color color) {
        this.stringScore.setForeground(color);
        this.score.setForeground(color);
    }
}
