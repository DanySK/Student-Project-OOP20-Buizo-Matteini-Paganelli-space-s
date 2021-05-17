package view.GUI.game.utilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LifeBar extends JProgressBar {

    public LifeBar(){
        super();
        super.setFont(new Font("Mv Boli", Font.BOLD, 15));
        super.setValue(50);
        super.setStringPainted(true);
        super.setForeground(Color.green);
        super.setBackground(Color.black);


    }


    @Override
    public String getString() {
        return "Life " + super.getValue();
    }
}
