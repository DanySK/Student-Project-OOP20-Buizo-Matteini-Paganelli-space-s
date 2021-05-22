package spaceSurvival.view.scoreboard.factoryMethod;

import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.scoreboard.FactoryGUIScoreboard;
import spaceSurvival.view.scoreboard.GUIScoreboard;
import spaceSurvival.view.scoreboard.concrete.GUIScoreboardConcrete;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIScoreboardReverse implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        scoreboardConcrete.getTxtSearchName().setColumns(DesignGraphics.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        scoreboardConcrete.setForegroundGUI(DesignGraphics.color4);

        this.createGraphics(scoreboardConcrete);
        return scoreboardConcrete;
    }

    private void createGraphics(final GUIScoreboardConcrete scoreboardConcrete) {
        scoreboardConcrete.setLayout(new BorderLayout());

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getLbTitle()),
                BorderLayout.NORTH);
        scoreboardConcrete.add(scoreboardConcrete.getBtnBack(), BorderLayout.SOUTH);

        JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.createPanelFlowUnionComponents(java.util.List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.SOUTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanelFlow(
                scoreboardConcrete.getScoreboard()), BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }


}
