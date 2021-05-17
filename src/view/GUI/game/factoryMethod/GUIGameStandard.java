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

        concreteGame.getLifeBoss().setPreferredSize(new Dimension(500, 30));
        concreteGame.getLifeShip().setPreferredSize(new Dimension(250, 20));

        final JPanel panelSouth = new JPanel(new GridBagLayout());
        final GridBagConstraints lim = FactoryGUIs.createGBConstraintFill(GridBagConstraints.VERTICAL);

        lim.fill = GridBagConstraints.HORIZONTAL;
        lim.gridwidth = 1;
        lim.weightx = 0.5;
        lim.anchor = GridBagConstraints.LINE_START;
        lim.gridx = 0;
        lim.gridy = 0;
        panelSouth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,
                FactoryGUIs.createPanelGridBagUnionComponentsVerticalInsetExternalSX(
                java.util.List.of(FactoryGUIs.encapsulatesInPanelFlowOrientation(
                        FlowLayout.LEFT,concreteGame.getHeartLife()),
                concreteGame.getLifeShip()), 6, 6)), lim);


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getLifeBoss()), BorderLayout.SOUTH);
        lim.fill = GridBagConstraints.HORIZONTAL;
        lim.gridwidth = 1;
        lim.anchor = GridBagConstraints.CENTER;
        lim.weightx = 0.5;
        lim.gridx = 1;
        lim.gridy = 0;
        panelSouth.add(panel, lim);

        lim.fill = GridBagConstraints.HORIZONTAL;
        lim.anchor = GridBagConstraints.LINE_END;
        lim.gridwidth = 1;
        lim.weightx = 0.5;
        lim.gridx = 2;
        lim.gridy = 0;
        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
                FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,concreteGame.getBullet()),
                BorderLayout.SOUTH), lim);


//        final JPanel panelSouth = new JPanel(new GridLayout()) {{setOpaque(false); }};
//
//        panelSouth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,
//                FactoryGUIs.createPanelGridBagUnionComponentsVerticalInsetExternalSX(
//                java.util.List.of(FactoryGUIs.encapsulatesInPanelFlowOrientation(
//                        FlowLayout.LEFT,concreteGame.getHeartLife()),
//                concreteGame.getLifeShip()), 6, 6)));
//
//
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(FactoryGUIs.encapsulatesInPanelFlow(concreteGame.getLifeBoss()), BorderLayout.SOUTH);
//        panelSouth.add(panel);
//
//
//        panelSouth.add(FactoryGUIs.encapsulateInPanelBorderOrientation(
//                FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,concreteGame.getBullet()),
//                BorderLayout.SOUTH
//        ));


        concreteGame.addForegroundPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addForegroundPanel(panelSouth, BorderLayout.SOUTH);
        concreteGame.visibleForegroundPanel(true);

        concreteGame.setBackgroundLayout(null);
        concreteGame.addBackPanel(concreteGame.getPanelGame());
    }
}
