package view.GUI.game.utilities;

import utilities.DesignSpace;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class CounterEnemies extends JPanel {
    private final JLabel stringEnemies;
    private final JLabel counter;

    public CounterEnemies(){
        super(new FlowLayout());
        super.setOpaque(false);

        this.stringEnemies = new JLabel("Enemies");
        this.counter = new JLabel("32");

        this.stringEnemies.setFont(DesignSpace.getFontForGame(35));
        this.counter.setFont(DesignSpace.getFontForGame(35));

        this.stringEnemies.setForeground(DesignSpace.color4);
        this.counter.setForeground(DesignSpace.color4);

        super.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(java.util.List.of(
                this.stringEnemies, FactoryGUIs.encapsulatesInPanelFlow(this.counter)), 5));

    }
}
