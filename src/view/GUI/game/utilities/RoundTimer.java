package view.GUI.game.utilities;

import utilities.DesignSpace;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class RoundTimer extends JPanel {
    private final JLabel timer;
    private final JLabel stringRound;
    private final JLabel round;

    public RoundTimer(){
        super();
        super.setOpaque(false);

        this.timer = new JLabel("00:00");
        this.stringRound = new JLabel("Round ");
        this.round = new JLabel("3");

        this.timer.setFont(DesignSpace.getFontForGame(35));
        this.stringRound.setFont(DesignSpace.getFontForGame(35));
        this.round.setFont(DesignSpace.getFontForGame(35));

        this.timer.setForeground(DesignSpace.color4);
        this.stringRound.setForeground(DesignSpace.color4);
        this.round.setForeground(DesignSpace.color4);


        super.add(FactoryGUIs.getUnionComponents(java.util.List.of(this.stringRound, this.round)));
        super.add(FactoryGUIs.encapsulatesInPanel_Flow(this.timer));



        super.setLayout(new GridLayout(0, super.getComponentCount() - 1));
    }
}