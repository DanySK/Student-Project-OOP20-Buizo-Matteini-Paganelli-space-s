package view.GUI.game.factoryMethod;

import utilities.dimension.ScaleOf;
import utilities.dimension.Screen;
import utilities.pathImage.Background;
import view.GUI.game.FactoryGUIGame;
import view.GUI.game.GUIGame;
import view.GUI.game.concrete.GUIGameConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIGameStandard implements FactoryGUIGame {
    @Override
    public GUIGame create() {
        final GUIGameConcrete concreteGame = new GUIGameConcrete();
        concreteGame.setBackgroundImage(Background.GAME);

        this.graphics(concreteGame);
        concreteGame.validate();
        return concreteGame;
    }

    private void graphics(final GUIGameConcrete concreteGame) {
        FactoryGUIs.setTransparentDesignJButton(concreteGame.getBtnPause());
        concreteGame.getBtnPause().setBorder(null);

        final JPanel panelNorth = new JPanel(new GridLayout()) {{ setOpaque(false); }};

        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT, concreteGame.getScore()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getRoundTimer()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,
                FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(
                        java.util.List.of(concreteGame.getBtnPause(), concreteGame.getCounterEnemies()),
                        5)));

        concreteGame.getLifeBoss().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_LIFEBAR_BOSS, Screen.WIDTH_FULL_SCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_LIFEBAR_BOSS, Screen.HEIGHT_FULL_SCREEN)));

        concreteGame.getLifeShip().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_LIFEBAR_SHIP, Screen.WIDTH_FULL_SCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_LIFEBAR_SHIP, Screen.HEIGHT_FULL_SCREEN)));

        concreteGame.getLifeBoss().setForeground(Color.RED);
        concreteGame.getLifeBoss().setVisible(false);

        final JPanel groupShip = FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,
                FactoryGUIs.createPanelGridBagUnionComponentsVerticalInsetExternalSX(
                    java.util.List.of(FactoryGUIs.encapsulatesInPanelFlowOrientation(
                        FlowLayout.LEFT,concreteGame.getHeartLife()),
                        concreteGame.getLifeShip()), 6, 6));


        final JPanel panelSouth = new JPanel(new GridLayout()) {{setOpaque(false); }};

        panelSouth.add(groupShip);

        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getLifeBoss()), BorderLayout.SOUTH));

        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,concreteGame.getBullet()),
                BorderLayout.SOUTH));


        concreteGame.addForegroundPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addForegroundPanel(panelSouth, BorderLayout.SOUTH);
        concreteGame.visibleForegroundPanel(true);

        concreteGame.setBackgroundLayout(null);
        concreteGame.addBackPanel(concreteGame.getPanelGame());
    }
}
