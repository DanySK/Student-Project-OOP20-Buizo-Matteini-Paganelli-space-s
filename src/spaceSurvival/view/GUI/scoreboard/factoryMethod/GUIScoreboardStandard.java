package spaceSurvival.view.GUI.scoreboard.factoryMethod;

import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.GUI.scoreboard.FactoryGUIScoreboard;
import spaceSurvival.view.GUI.scoreboard.GUIScoreboard;
import spaceSurvival.view.GUI.scoreboard.concrete.GUIScoreboardConcrete;
import spaceSurvival.view.utilities.FactoryGUIs;

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
        scoreboardConcrete.setForegroundGUI(DesignGraphics.color4);
        scoreboardConcrete.setBounds(Screen.RECTANGLE_MEDIUM);
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

        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnSearch(), Icon.SEARCH,
                ScaleOf.ICON_MEDIUM, scoreboardConcrete.getWidth());
        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, scoreboardConcrete.getWidth());

        JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.NORTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getScoreboard()),
                BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }

}
