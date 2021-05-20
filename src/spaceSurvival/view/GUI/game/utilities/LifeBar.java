package spaceSurvival.view.GUI.game.utilities;

import javax.swing.*;
import java.awt.*;

public class LifeBar extends JProgressBar {

    public LifeBar(){
        super();
        super.setStringPainted(true);
    }

    public void setValue(final int life){
        super.setValue(life);

        if(life > 75){
            super.setForeground(Color.green);
        } else if(life > 40){
            super.setForeground(Color.orange);
        } else if(life > 20){
            super.setForeground(Color.red);
        }
    }

    @Override
    public String getString() {
        return "Life " + super.getValue();
    }
}
