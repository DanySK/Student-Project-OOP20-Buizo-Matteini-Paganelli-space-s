package view.GUI.scoreboard.factoryMethod;

import utilities.DesignSpace;
import view.GUI.scoreboard.FactoryGUIScoreboard;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.scoreboard.concrete.GUIScoreboardConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUIScoreboardStandard implements FactoryGUIScoreboard {
    private final GUIScoreboardConcrete GUIScoreboardConcrete = new GUIScoreboardConcrete();

    @Override
    public GUIScoreboard createGUI() {
        this.GUIScoreboardConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.GUIScoreboardConcrete.getTxtSearchName().setColumns(DesignSpace.SIZE_COLUMNS_TEXT);
        this.GUIScoreboardConcrete.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.GUIScoreboardConcrete.setAllForeground(DesignSpace.color4);

        this.createGraphics();
        return this.GUIScoreboardConcrete;
    }

    private void createGraphics() {
        this.GUIScoreboardConcrete.setLayoutGUI(new BorderLayout());
        this.GUIScoreboardConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.GUIScoreboardConcrete.getLbTitle()), BorderLayout.NORTH);


        JPanel panelScore = new JPanel(new BorderLayout());
        panelScore.setOpaque(false);

        FactoryGUIs.setTransparentDesignJButton(this.GUIScoreboardConcrete.getBtnSearch());
        FactoryGUIs.setIconInJButtonMini(this.GUIScoreboardConcrete.getBtnSearch(), "iconButton/search.png");
        panelScore.add(FactoryGUIs.getUnionComponents(List.of(this.GUIScoreboardConcrete.getTxtSearchName(),
                this.GUIScoreboardConcrete.getBtnSearch())), BorderLayout.NORTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.GUIScoreboardConcrete.getScoreboard()), BorderLayout.CENTER);

        FactoryGUIs.setTransparentDesignJButton(this.GUIScoreboardConcrete.getBtnBack());
        FactoryGUIs.setIconInJButtonMini(this.GUIScoreboardConcrete.getBtnBack(), "iconButton/back.png");

        FactoryGUIs.setTransparentDesignJButton(this.GUIScoreboardConcrete.getBtnSearch());
        this.GUIScoreboardConcrete.add(panelScore, BorderLayout.CENTER);
        this.GUIScoreboardConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.GUIScoreboardConcrete.getBtnBack()), BorderLayout.SOUTH);

    }

}
