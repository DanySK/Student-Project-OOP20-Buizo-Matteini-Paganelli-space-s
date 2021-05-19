package spaceSurvival.view.GUI.scoreboard.factoryMethod;

import spaceSurvival.utilities.DesignSpace;
import spaceSurvival.view.GUI.scoreboard.FactoryGUIScoreboard;
import spaceSurvival.view.GUI.scoreboard.GUIScoreboard;
import spaceSurvival.view.GUI.scoreboard.concrete.GUIScoreboardConcrete;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIScoreboardReverse implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_H1));
        scoreboardConcrete.getTxtSearchName().setColumns(DesignSpace.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        scoreboardConcrete.setForegroundGUI(DesignSpace.color4);

        this.createGraphics(scoreboardConcrete);
        return scoreboardConcrete;
    }

    private void createGraphics(final GUIScoreboardConcrete scoreboardConcrete) {
        scoreboardConcrete.setBackgroundLayout(new BorderLayout());

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
