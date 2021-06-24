package spacesurvival.view.game.factorymethod;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.Background;
import spacesurvival.view.game.FactoryGUIGame;
import spacesurvival.view.game.GUIGame;
import spacesurvival.view.game.concrete.GUIGameConcrete;
import spacesurvival.view.utilities.GraphicsLayoutUtils;
import spacesurvival.view.utilities.FactoryGUIs;


/**
 * Implements the creation of the standard settings GUI.
 */
public class GUIGameStandard implements FactoryGUIGame {

    /**
     * {@inheritDoc}
     */
    @Override
    public GUIGame create() {
        final GUIGameConcrete concreteGame = new GUIGameConcrete();
        concreteGame.setImageBackground(Background.GAME);
        concreteGame.setFontGUI(GraphicsLayoutUtils.getFontForGame(GraphicsLayoutUtils.SIZE_FONT_H3));
        concreteGame.setFontLifeBars(GraphicsLayoutUtils.getFontForGame(GraphicsLayoutUtils.SIZE_FONT_H6));
        concreteGame.setBackgroundLifeBars(GraphicsLayoutUtils.COLOR_OPACITY_BLACK);
        concreteGame.setForegroundGUI(GraphicsLayoutUtils.COLOR_4);

        this.graphics(concreteGame);
        return concreteGame;
    }

    /**
     * Create graphics standard concreteGame GUI.
     * 
     * @param concreteGame to create the graphics.
     */
    private void graphics(final GUIGameConcrete concreteGame) {
        FactoryGUIs.setTransparentJButton(concreteGame.getBtnPause());

        final JPanel panelNorth = FactoryGUIs.createPanelTransparent(new GridLayout());

        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT, concreteGame.getScore()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getRoundTimer()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,
                FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(
                        java.util.List.of(concreteGame.getBtnPause(), concreteGame.getCounterEnemies()),
                        FactoryGUIs.INSET_H3)));

        concreteGame.getLifeBoss().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_LIFEBAR_BOSS, Screen.WIDTH_FULLSCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_LIFEBAR_BOSS, Screen.HEIGHT_FULLSCREEN)));

        concreteGame.getLifeShip().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_LIFEBAR_SHIP, Screen.WIDTH_FULLSCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_LIFEBAR_SHIP, Screen.HEIGHT_FULLSCREEN)));

        final JPanel groupShip = FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,
                FactoryGUIs.createPanelGridBagUnionComponentsVerticalInsetExternalSX(
                    java.util.List.of(FactoryGUIs.encapsulatesInPanelFlowOrientation(
                        FlowLayout.LEFT, concreteGame.getHeartLife()),
                        concreteGame.getLifeShip()), FactoryGUIs.INSET_H3, FactoryGUIs.INSET_H3));


        final JPanel panelSouth = FactoryGUIs.createPanelTransparent(new GridLayout());

        panelSouth.add(groupShip);

        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getLifeBoss()), BorderLayout.SOUTH));

        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT, concreteGame.getBullet()),
                BorderLayout.SOUTH));


        concreteGame.addFrontPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addFrontPanel(panelSouth, BorderLayout.SOUTH);
        concreteGame.visibleForegroundPanel(Visibility.VISIBLE);

        concreteGame.setLayout(null);
        concreteGame.add(concreteGame.getPanelEntity());
        concreteGame.add(concreteGame.getPanelBullet());
    }
}
