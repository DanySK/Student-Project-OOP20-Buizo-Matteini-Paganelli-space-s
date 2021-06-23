package spacesurvival.view.game.utilities;

import spacesurvival.view.utilities.GraphicsLayoutUtils;
import spacesurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class CounterEnemies extends JPanel {
    private final JLabel stringEnemies;
    private final JLabel counter;

    public CounterEnemies(){
        super(new FlowLayout());
        super.setOpaque(false);

        this.stringEnemies = new JLabel(GraphicsLayoutUtils.ENEMIES_STRING);
        this.counter = new JLabel();

        super.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(java.util.List.of(
                this.stringEnemies, FactoryGUIs.encapsulatesInPanelFlow(this.counter)),
                FactoryGUIs.INSET_H3));
    }

    public void setCounter(final long count){
        this.counter.setText(Long.toString(count));
    }

    public void setCounter(final String count){
        this.counter.setText(count);
    }

    public void setFontAll(final Font font) {
        this.stringEnemies.setFont(font);
        this.counter.setFont(font);
    }

    public void setForegroundAll(final Color color) {
        this.stringEnemies.setForeground(color);
        this.counter.setForeground(color);
    }
}
