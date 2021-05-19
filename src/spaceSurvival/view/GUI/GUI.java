package spaceSurvival.view.GUI;

import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.utilities.ButtonID;

import java.awt.event.MouseListener;
import java.util.List;

public interface GUI {
    
    public void addMouseListener(final MouseListener mouseListener);

    public void setVisible(final boolean visible);

    public IdGUI getId();

    public void setId(final IdGUI id);

    public void close();

    public List<ButtonID> getButtonLinks();
}