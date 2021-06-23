package spacesurvival.view.scoreboard.factorymethod;

import spacesurvival.view.utilities.GraphicsLayoutUtils;
import spacesurvival.view.scoreboard.FactoryGUIScoreboard;
import spacesurvival.view.scoreboard.GUIScoreboard;
import spacesurvival.view.scoreboard.concrete.GUIScoreboardConcrete;
import spacesurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIScoreboardReverse implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        final GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(GraphicsLayoutUtils.getFontForTitle(GraphicsLayoutUtils.SIZE_FONT_H2));
        scoreboardConcrete.getTxtSearchName().setColumns(GraphicsLayoutUtils.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(GraphicsLayoutUtils.FONT_STANDARD_H5);
        scoreboardConcrete.setForegroundGUI(GraphicsLayoutUtils.COLOR_4);

        this.createGraphics(scoreboardConcrete);
        return scoreboardConcrete;
    }

    private void createGraphics(final GUIScoreboardConcrete scoreboardConcrete) {
        scoreboardConcrete.setLayout(new BorderLayout());

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getLbTitle()),
                BorderLayout.NORTH);
        scoreboardConcrete.add(scoreboardConcrete.getBtnBack(), BorderLayout.SOUTH);

        final JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.createPanelFlowUnionComponents(java.util.List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.SOUTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanelFlow(
                scoreboardConcrete.getScoreboard()), BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }


}
