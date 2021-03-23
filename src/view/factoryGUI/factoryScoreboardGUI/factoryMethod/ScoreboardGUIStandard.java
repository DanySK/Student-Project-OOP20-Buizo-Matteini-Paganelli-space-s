package view.factoryGUI.factoryScoreboardGUI.factoryMethod;

import utilities.DesignSpace;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.FactoryScoreboardGUI;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.ScoreboardGUI;
import view.factoryGUI.factoryScoreboardGUI.scoreboardGUI.ConcreteScoreboardGUI;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreboardGUIStandard implements FactoryScoreboardGUI {
    private final ConcreteScoreboardGUI concreteScoreboardGUI = new ConcreteScoreboardGUI();

    @Override
    public ScoreboardGUI createGUI() {
        this.concreteScoreboardGUI.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.concreteScoreboardGUI.getTxtSearchName().setColumns(DesignSpace.SIZE_COLUMNS_TEXT);
        this.concreteScoreboardGUI.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.concreteScoreboardGUI.setAllForeground(DesignSpace.color3);

        this.createGraphics();
        return this.concreteScoreboardGUI;
    }

    private void createGraphics() {
        this.concreteScoreboardGUI.setLayoutGUI(new BorderLayout());
        this.concreteScoreboardGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.concreteScoreboardGUI.getLbTitle()), BorderLayout.NORTH);


        JPanel panelScore = new JPanel(new BorderLayout());
        panelScore.setOpaque(false);

        FactoryGUIs.setTransparentDesignJButton(this.concreteScoreboardGUI.getBtnSearch());
        FactoryGUIs.setIconInJButton(this.concreteScoreboardGUI.getBtnSearch(), "iconButton/iconSearch.png");
        panelScore.add(FactoryGUIs.getUnionComponents(List.of(this.concreteScoreboardGUI.getTxtSearchName(),
                this.concreteScoreboardGUI.getBtnSearch())), BorderLayout.NORTH);

        panelScore.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.concreteScoreboardGUI.getScoreboard()), BorderLayout.CENTER);

        FactoryGUIs.setTransparentDesignJButton(this.concreteScoreboardGUI.getBtnBack());
        FactoryGUIs.setIconInJButton(this.concreteScoreboardGUI.getBtnBack(), "iconButton/iconBack.png");

        FactoryGUIs.setTransparentDesignJButton(this.concreteScoreboardGUI.getBtnSearch());
        this.concreteScoreboardGUI.add(panelScore, BorderLayout.CENTER);
        this.concreteScoreboardGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.concreteScoreboardGUI.getBtnBack()), BorderLayout.SOUTH);

    }

}
