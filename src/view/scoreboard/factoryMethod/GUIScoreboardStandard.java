package view.scoreboard.factoryMethod;

import model.GUI.scoreboard.EngineScoreboard;
import utilities.dimension.ScaleOf;
import utilities.pathImage.Background;
import utilities.pathImage.Icon;
import view.utilities.DesignGraphics;
import view.scoreboard.FactoryGUIScoreboard;
import view.scoreboard.GUIScoreboard;
import view.scoreboard.concrete.GUIScoreboardConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUIScoreboardStandard implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        scoreboardConcrete.getTxtSearchName().setColumns(DesignGraphics.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        scoreboardConcrete.setForegroundGUI(DesignGraphics.COLOR_4);
        scoreboardConcrete.setBorder(DesignGraphics.COLOR_4, 3);
        scoreboardConcrete.setImageBackground(Background.MAIN);
        this.createGraphics(scoreboardConcrete);
        return scoreboardConcrete;
    }

    private void createGraphics(final GUIScoreboardConcrete scoreboardConcrete) {
        scoreboardConcrete.setLayout(new BorderLayout());

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getLbTitle()),
                BorderLayout.NORTH);

        scoreboardConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getBtnBack()),
                BorderLayout.SOUTH);

        FactoryGUIs.setTransparentDesignJButton(scoreboardConcrete.getBtnSearch());
        FactoryGUIs.setTransparentDesignJButton(scoreboardConcrete.getBtnBack());

        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnSearch(), Icon.SEARCH,
                ScaleOf.ICON_MEDIUM, EngineScoreboard.RECTANGLE.width);
        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, EngineScoreboard.RECTANGLE.width);

        JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.NORTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getScrollerScoreboard()),
                BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }

}
