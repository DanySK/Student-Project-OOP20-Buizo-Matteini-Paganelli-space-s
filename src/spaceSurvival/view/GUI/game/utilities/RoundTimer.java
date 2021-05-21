package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class RoundTimer extends JPanel {
    private final JLabel timer;
    private final JLabel stringRound;
    private final JLabel round;

    public RoundTimer(){
        super();
        super.setOpaque(false);

        this.timer = new JLabel(DesignGraphics.INIT_TIMER_STRING);
        this.stringRound = new JLabel(DesignGraphics.ROUND_STRING);
        this.round = new JLabel();

        super.add(FactoryGUIs.encapsulatesInPanelFlow(this.timer));
        super.add(FactoryGUIs.createPanelFlowUnionComponents(java.util.List.of(this.stringRound, this.round)));
        super.setLayout(new GridLayout(0, super.getComponentCount() - 1));
    }

    public void setFontAll(final Font font){
        this.timer.setFont(font);
        this.stringRound.setFont(font);
        this.round.setFont(font);
    }

    public void setForegroundAll(final Color color){
        this.timer.setForeground(color);
        this.stringRound.setForeground(color);
        this.round.setForeground(color);
    }

    public void setRound(final int round){
        this.round.setText(String.valueOf(round));
    }

    public void setRound(final String round){
        this.round.setText(round);
    }

    public void setTimer(final String timer){
        this.timer.setText(timer);
    }
}
