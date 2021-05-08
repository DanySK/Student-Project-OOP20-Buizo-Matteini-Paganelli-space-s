package view.GUI.scoreboard.factoryMethod;

import utilities.DimensionScreen;
import utilities.IconPath;
import utilities.DesignSpace;
import view.GUI.scoreboard.FactoryGUIScoreboard;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.scoreboard.concrete.GUIScoreboardConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUIScoreboardStandard implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        scoreboardConcrete.getTxtSearchName().setColumns(DesignSpace.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        scoreboardConcrete.setForegroundGUI(DesignSpace.color4);
        scoreboardConcrete.setBounds(DimensionScreen.RECTANGLE_MEDIUM);
        scoreboardConcrete.setBorder(3);
        this.createGraphics(scoreboardConcrete);
        return scoreboardConcrete;
    }

    private void createGraphics(final GUIScoreboardConcrete scoreboardConcrete) {
        scoreboardConcrete.setBackgroundLayout(new BorderLayout());

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getLbTitle()),
                BorderLayout.NORTH);

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getBtnBack()),
                BorderLayout.SOUTH);

        FactoryGUIs.setTransparentDesignJButton(scoreboardConcrete.getBtnSearch());
        FactoryGUIs.setTransparentDesignJButton(scoreboardConcrete.getBtnBack());

        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnSearch(), IconPath.ICON_SEARCH,
                30, scoreboardConcrete.getWidth());
        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnBack(), IconPath.ICON_BACK,
                30, scoreboardConcrete.getWidth());

        JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.NORTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getScoreboard()),
                BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }

}
