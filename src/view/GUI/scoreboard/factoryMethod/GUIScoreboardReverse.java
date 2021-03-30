package view.GUI.scoreboard.factoryMethod;

import utilities.DesignSpace;
import view.GUI.scoreboard.FactoryGUIScoreboard;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.scoreboard.concrete.GUIScoreboardConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIScoreboardReverse implements FactoryGUIScoreboard {
    private final GUIScoreboardConcrete GUIScoreboardConcrete = new GUIScoreboardConcrete();

    @Override
    public GUIScoreboard createGUI() {
        this.GUIScoreboardConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.GUIScoreboardConcrete.getTxtSearchName().setColumns(DesignSpace.SIZE_COLUMNS_TEXT);
        this.GUIScoreboardConcrete.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.GUIScoreboardConcrete.setAllForeground(DesignSpace.color3);

        this.createGraphics();
        return this.GUIScoreboardConcrete;
    }

    private void createGraphics() {
        this.GUIScoreboardConcrete.setLayoutGUI(new BorderLayout());

        this.GUIScoreboardConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.GUIScoreboardConcrete.getLbTitle()), BorderLayout.NORTH);


        JPanel panelScore = new JPanel(new BorderLayout());
        panelScore.setOpaque(false);

        panelScore.add(FactoryGUIs.getUnionComponents(java.util.List.of(this.GUIScoreboardConcrete.getTxtSearchName(),
                this.GUIScoreboardConcrete.getBtnSearch())), BorderLayout.SOUTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.GUIScoreboardConcrete.getScoreboard()), BorderLayout.CENTER);

        this.GUIScoreboardConcrete.add(panelScore, BorderLayout.CENTER);
        this.GUIScoreboardConcrete.add(this.GUIScoreboardConcrete.getBtnBack(), BorderLayout.SOUTH);

    }


}
