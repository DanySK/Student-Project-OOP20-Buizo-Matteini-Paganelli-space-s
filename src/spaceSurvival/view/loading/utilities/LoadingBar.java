package spaceSurvival.view.loading.utilities;

import spaceSurvival.model.EngineImage;
import spaceSurvival.utilities.dimension.Screen;

import javax.swing.*;
import java.awt.*;

public class LoadingBar extends JProgressBar {

    public LoadingBar(){
        super(SwingConstants.HORIZONTAL, 0, 100);;
    }

    @Override
    public void paintComponent(final Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

//        int i = Screen.scaleRespectTo(30, super.getWidth());
//        Image img = EngineImage.getImageFromEngine(new EngineImage("loading.png", i, i));
//
//        for (int j = 0; j < (super.getWidth() * super.getValue() / (100 * i)) + 1; j++){
//            g2d.drawImage(img, j * i,0, null);
//        }
    }


}
