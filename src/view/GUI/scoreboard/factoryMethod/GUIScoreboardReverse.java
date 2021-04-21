package view.GUI.scoreboard.factoryMethod;

import utilities.DesignSpace;
import view.GUI.scoreboard.FactoryGUIScoreboard;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.scoreboard.concrete.GUIScoreboardConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIScoreboardReverse implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        scoreboardConcrete.getTxtSearchName().setColumns(DesignSpace.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        scoreboardConcrete.setForegroundGUI(DesignSpace.color4);

        this.createGraphics(scoreboardConcrete);
        return scoreboardConcrete;
    }

    private void createGraphics(final GUIScoreboardConcrete scoreboardConcrete) {
        scoreboardConcrete.setBackLayoutGUI(new BorderLayout());

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(scoreboardConcrete.getLbTitle()),
                BorderLayout.NORTH);
        scoreboardConcrete.add(scoreboardConcrete.getBtnBack(), BorderLayout.SOUTH);

        JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.getUnionComponents(java.util.List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.SOUTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanel_Flow(
                scoreboardConcrete.getScoreboard()), BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }


}
