package spaceSurvival.view.GUI.loading.utilities;

import spaceSurvival.model.image.EngineImage;
import spaceSurvival.view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class LoadingBar extends JProgressBar {

    public LoadingBar(){
        super(JProgressBar.HORIZONTAL, 0, 100);;
    }

    public void paintComponent(final Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        Image img = getImageFromEngine(new EngineImage("loading.png", 50, 50));

        super.getValue();
        super.getSize();

        int i = 50;

        for (int j = 0; j < (super.getValue()/3) + 1; j++){
            g2d.drawImage(img, j * i,0, null);
        }



    }

    private Image getImageFromEngine(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }
}
