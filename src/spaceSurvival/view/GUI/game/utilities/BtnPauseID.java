package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.view.utilities.ButtonID;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BtnPauseID extends ButtonID {
    private String pathIconEnter;
    private String pathIcon;

    public BtnPauseID(){
        super();
        FactoryGUIs.setIconJButtonFromRate(this, Icon.PAUSE, 30, Screen.WIDTH_FULL_SCREEN);
        super.addMouseListener(this.mouseListener());
    }

    public MouseListener mouseListener(){
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {
                FactoryGUIs.setIconJButtonFromRate(BtnPauseID.this, Icon.PAUSE_2FACE, 30, Screen.WIDTH_FULL_SCREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                FactoryGUIs.setIconJButtonFromRate(BtnPauseID.this, Icon.PAUSE, 30, Screen.WIDTH_FULL_SCREEN);
            }
        };
    }

}
