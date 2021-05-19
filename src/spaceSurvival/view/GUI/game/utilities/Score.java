package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.utilities.DesignSpace;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    private final JLabel stringScore;
    private final JLabel score;

    public Score(){
        super(new FlowLayout()); {{ setOpaque(false); }}

        this.stringScore = new JLabel("Score: ");
        this.score = new JLabel("2345800");

        this.stringScore.setOpaque(false);
        this.score.setOpaque(false);

        this.stringScore.setFont(DesignSpace.getFontForGame(35));
        this.stringScore.setForeground(DesignSpace.color4);
        this.score.setFont(DesignSpace.getFontForGame(35));
        this.score.setForeground(DesignSpace.color4);


        super.add(FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(java.util.List.of(
                this.stringScore, this.score), 10));


    }
}
