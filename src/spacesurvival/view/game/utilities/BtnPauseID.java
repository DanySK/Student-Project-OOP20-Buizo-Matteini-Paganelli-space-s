package spacesurvival.view.game.utilities;

import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.Icon;
import spacesurvival.view.utilities.BtnAction;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BtnPauseID extends BtnAction implements MouseListener{
    private final String pathIconEnter;
    private final String pathIconExit;

    public BtnPauseID(){
        super();
        super.setBorder(null);
        this.pathIconExit = Icon.PAUSE;
        this.pathIconEnter = Icon.PAUSE_2FACE;

        FactoryGUIs.setIconJButtonFromRate(this, this.pathIconExit, ScaleOf.ICON_FULL, Screen.WIDTH_FULLSCREEN);
        this.addMouseListener(this);
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
        //FactoryGUIs.setIconJButtonFromRate(this,
        //        this.pathIconEnter, ScaleOf.ICON_FULL, Screen.WIDTH_FULL_SCREEN);
    }

    @Override
    public void mouseExited(final MouseEvent e) {
        //FactoryGUIs.setIconJButtonFromRate(this,
        //        this.pathIconExit, ScaleOf.ICON_FULL, Screen.WIDTH_FULL_SCREEN);
    }

    @Override
    public void mouseClicked(final MouseEvent e) { }

    @Override
    public void mousePressed(final MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }
}
