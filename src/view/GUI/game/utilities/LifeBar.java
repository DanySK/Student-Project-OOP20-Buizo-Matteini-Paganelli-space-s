package view.GUI.game.utilities;

import javax.swing.*;
import java.util.List;

public class LifeBar extends JProgressBar {

    public LifeBar(){
        super();

    }


    @Override
    public String getString() {
        return "Life " + super.getValue();
    }
}
