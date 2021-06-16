package spacesurvival.view;

import spacesurvival.model.GUI.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.utilities.BtnAction;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.List;

public interface GUI {

    public void addMouseListener(final MouseListener mouseListener);


    public List<BtnAction> getBtnActionLinks();


    public void setMainAction(final ActionGUI actionGUI);

    public void setBounds(final Rectangle rectangle);

    public void setVisible(final boolean visible);

    public void setImageBackground(final String path);


    public void visibleForegroundPanel(final Visibility visible);


    public void close();

}