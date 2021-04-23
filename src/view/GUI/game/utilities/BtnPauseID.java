package view.GUI.game.utilities;

import utilities.IconPath;
import view.utilities.ButtonID;
import view.utilities.FactoryGUIs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BtnPauseID extends ButtonID {
    private String pathIconEnter;
    private String pathIcon;

    public BtnPauseID(){
        super();
        FactoryGUIs.setIconInJButtonMini(this, IconPath.ICON_PAUSE);
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
                FactoryGUIs.setIconInJButtonMini(BtnPauseID.this, IconPath.ICON_PAUSE_2FACE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                FactoryGUIs.setIconInJButtonMini(BtnPauseID.this, IconPath.ICON_PAUSE);
            }
        };
    }

}
