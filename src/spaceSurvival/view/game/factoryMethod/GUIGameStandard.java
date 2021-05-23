package spaceSurvival.view.game.factoryMethod;

import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.game.FactoryGUIGame;
import spaceSurvival.view.game.GUIGame;
import spaceSurvival.view.game.concrete.GUIGameConcrete;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUIGameStandard implements FactoryGUIGame {
    @Override
    public GUIGame create() {
        final GUIGameConcrete concreteGame = new GUIGameConcrete();
        concreteGame.setImageBackground(Background.GAME);
        concreteGame.setFontGUI(DesignGraphics.getFontForGame(DesignGraphics.SIZE_FONT_H2));
        concreteGame.setFontLifeBars(DesignGraphics.getFontForGame(DesignGraphics.SIZE_FONT_H5));
        concreteGame.setBackgroundLifeBars(DesignGraphics.colorOpacityBlack);
        concreteGame.setForegroundGUI(DesignGraphics.color4);

        this.graphics(concreteGame);
        return concreteGame;
    }

    private void graphics(final GUIGameConcrete concreteGame) {
        FactoryGUIs.setTransparentDesignJButton(concreteGame.getBtnPause());

        final JPanel panelNorth = FactoryGUIs.createPanelTransparent(new GridLayout());

        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT, concreteGame.getScore()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getRoundTimer()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,
                FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(
                        java.util.List.of(concreteGame.getBtnPause(), concreteGame.getCounterEnemies()),
                        FactoryGUIs.MEDIUM_INSET)));

        concreteGame.getLifeBoss().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_LIFEBAR_BOSS, Screen.WIDTH_FULL_SCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_LIFEBAR_BOSS, Screen.HEIGHT_FULL_SCREEN)));

        concreteGame.getLifeShip().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_LIFEBAR_SHIP, Screen.WIDTH_FULL_SCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_LIFEBAR_SHIP, Screen.HEIGHT_FULL_SCREEN)));

//        concreteGame.getLifeBoss().setForeground(Color.RED);
        concreteGame.getLifeBoss().setVisible(false);

        final JPanel groupShip = FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,
                FactoryGUIs.createPanelGridBagUnionComponentsVerticalInsetExternalSX(
                    java.util.List.of(FactoryGUIs.encapsulatesInPanelFlowOrientation(
                        FlowLayout.LEFT,concreteGame.getHeartLife()),
                        concreteGame.getLifeShip()), FactoryGUIs.MEDIUM_INSET, FactoryGUIs.MEDIUM_INSET));


        final JPanel panelSouth = new JPanel(new GridLayout()) {{setOpaque(false); }};

        panelSouth.add(groupShip);

        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getLifeBoss()), BorderLayout.SOUTH));

        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,concreteGame.getBullet()),
                BorderLayout.SOUTH));


        concreteGame.addFrontPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addFrontPanel(panelSouth, BorderLayout.SOUTH);
        concreteGame.visibleForegroundPanel(Visibility.VISIBLE);

        concreteGame.setLayout(null);
        concreteGame.add(concreteGame.getPanelGame());
    }
}
