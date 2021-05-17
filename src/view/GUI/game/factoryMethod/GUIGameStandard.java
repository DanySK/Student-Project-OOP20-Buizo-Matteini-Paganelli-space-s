package view.GUI.game.factoryMethod;

import utilities.dimension.Screen;
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
        concreteGame.setBackgroundImage("background/game3.jpg");

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

        final JPanel panelSouth = new JPanel(new BorderLayout()
        {{ setHgap(Screen.scaleRespectTo(70, Screen.WIDTH_FULL_SCREEN));
            }})
        {{ setOpaque(false); }};

        concreteGame.getLifeShip().setPreferredSize(new Dimension(250, 20));

        panelSouth.add(FactoryGUIs.createPanelGridBagUnionComponentsVerticalInsetExternalSX(
                java.util.List.of(
                FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,concreteGame.getHeartLife()),
                concreteGame.getLifeShip()), 10, 10),BorderLayout.WEST);

        panelSouth.add(FactoryGUIs.encapsulateInPanelVerticalCenter(concreteGame.getLifeBoss()), BorderLayout.CENTER);
        panelSouth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEADING,concreteGame.getBullet()),
                BorderLayout.EAST);

        concreteGame.addForegroundPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addForegroundPanel(panelSouth, BorderLayout.SOUTH);
        concreteGame.visibleForegroundPanel(true);

        concreteGame.setBackgroundLayout(null);
        concreteGame.addBackPanel(concreteGame.getPanelGame());
    }
}
