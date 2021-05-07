package view.GUI.game.factoryMethod;

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

        concreteGame.getLife().setFont(new Font("Mv Boli", Font.BOLD, 20));
        concreteGame.getLife().setValue(50);
        concreteGame.getLife().setStringPainted(true);
        concreteGame.getLife().setForeground(Color.green);
        concreteGame.getLife().setBackground(Color.black);


        final JPanel panelSouth = new JPanel(new BorderLayout(){{ setHgap(250); }}) {{ setOpaque(false); }};

        panelSouth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT,concreteGame.getHeartLife()),
                BorderLayout.WEST);
        panelSouth.add(FactoryGUIs.encapsulateInPanel_Box_Vertical_Center(concreteGame.getLife()), BorderLayout.CENTER);
        panelSouth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,concreteGame.getBullet()),
                BorderLayout.EAST);

        final JPanel panelNorth = new JPanel(new GridLayout()) {{ setOpaque(false); }};

        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.LEFT, concreteGame.getScore()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanel_Flow(concreteGame.getRoundTimer()));
        panelNorth.add(FactoryGUIs.encapsulatesInPanelFlowOrientation(FlowLayout.RIGHT,
                FactoryGUIs.encapsulatesHorizontal(
                        java.util.List.of(concreteGame.getBtnPause(), concreteGame.getCounterEnemies()),
                        5)));

        concreteGame.addForegroundPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addForegroundPanel(panelSouth, BorderLayout.SOUTH);
        concreteGame.visibleForegroundPanel(true);

        concreteGame.setBackgroundLayout(null);
        concreteGame.addBackPanel(concreteGame.getPanelGame());
    }
}
