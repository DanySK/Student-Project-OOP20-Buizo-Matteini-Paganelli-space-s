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
        JPanel panelSouth = new JPanel(new BorderLayout(){{ setHgap(250); setVgap(0);}})
        {{ setOpaque(false); }};

        FactoryGUIs.setTransparentDesignJButton(concreteGame.getBtnPause());
        concreteGame.getBtnPause().setBorder(null);

        concreteGame.getLife().setFont(new Font("Mv Boli", Font.BOLD, 20));
        concreteGame.getLife().setValue(50);
        concreteGame.getLife().setStringPainted(true);
        concreteGame.getLife().setForeground(Color.green);
        concreteGame.getLife().setBackground(Color.black);

        panelSouth.add(FactoryGUIs.encapsulateInPanel_Box_Vertical_Center(concreteGame.getLife()),
                BorderLayout.CENTER);
        JPanel panel = new JPanel(new BorderLayout() {{setVgap(10); setHgap(10);}} ) {{ setOpaque(false); }};
        panel.add(concreteGame.getHeartLife(), BorderLayout.CENTER);


        panelSouth.add(panel,
                BorderLayout.WEST);
        panelSouth.add(concreteGame.getBullet(), BorderLayout.EAST);



        JPanel panelNorth = new JPanel(new BorderLayout()) {{ setOpaque(false); }};


        panelNorth.add(concreteGame.getScore(), BorderLayout.WEST);
        panelNorth.add(FactoryGUIs.encapsulatesInPanel_Flow(concreteGame.getRoundTimer()), BorderLayout.CENTER);
        panelNorth.add(FactoryGUIs.encapsulatesHorizontal(java.util.List.of(
                concreteGame.getBtnPause(), concreteGame.getCounterEnemies()), 5), BorderLayout.EAST);


        concreteGame.visibleForegroundPanel(true);
        concreteGame.add(concreteGame.getSpaceShip());
        concreteGame.addForegroundPanel(panelNorth, BorderLayout.NORTH);
        concreteGame.addForegroundPanel(panelSouth, BorderLayout.SOUTH);
    }
}
