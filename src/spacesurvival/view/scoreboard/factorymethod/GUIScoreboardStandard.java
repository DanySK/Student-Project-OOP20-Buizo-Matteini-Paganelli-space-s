package spacesurvival.view.scoreboard.factorymethod;

import spacesurvival.model.gui.scoreboard.EngineScoreboard;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.path.Background;
import spacesurvival.utilities.path.Icon;
import spacesurvival.view.utilities.GraphicsLayoutUtils;
import spacesurvival.view.scoreboard.FactoryGUIScoreboard;
import spacesurvival.view.scoreboard.GUIScoreboard;
import spacesurvival.view.scoreboard.concrete.GUIScoreboardConcrete;
import spacesurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUIScoreboardStandard implements FactoryGUIScoreboard {

    @Override
    public GUIScoreboard createGUI() {
        final GUIScoreboardConcrete scoreboardConcrete = new GUIScoreboardConcrete();
        scoreboardConcrete.setFontLbTitle(GraphicsLayoutUtils.getFontForTitle(GraphicsLayoutUtils.SIZE_FONT_H2));
        scoreboardConcrete.getTxtSearchName().setColumns(GraphicsLayoutUtils.SIZE_COLUMNS_TEXT);
        scoreboardConcrete.setFontGUI(GraphicsLayoutUtils.FONT_STANDARD_H5);
        scoreboardConcrete.setForegroundGUI(GraphicsLayoutUtils.COLOR_4);
        scoreboardConcrete.setBorder(GraphicsLayoutUtils.COLOR_4, 3);
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

        FactoryGUIs.setTransparentJButton(scoreboardConcrete.getBtnSearch());
        FactoryGUIs.setTransparentJButton(scoreboardConcrete.getBtnBack());

        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnSearch(), Icon.SEARCH,
                ScaleOf.ICON_MEDIUM, EngineScoreboard.RECTANGLE.width);
        FactoryGUIs.setIconJButtonFromRate(scoreboardConcrete.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, EngineScoreboard.RECTANGLE.width);

        final JPanel panelScore = new JPanel(new BorderLayout()) {{ setOpaque(false); }};

        panelScore.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(scoreboardConcrete.getTxtSearchName(),
                scoreboardConcrete.getBtnSearch())), BorderLayout.NORTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanelFlow(scoreboardConcrete.getScrollerScoreboard()),
                BorderLayout.CENTER);

        scoreboardConcrete.add(panelScore, BorderLayout.CENTER);


    }

}
