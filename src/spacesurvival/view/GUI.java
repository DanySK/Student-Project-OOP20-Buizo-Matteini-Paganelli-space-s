package spacesurvival.view;

import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.utilities.BtnAction;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.util.List;

public interface GUI {

    void addMouseListener(MouseListener mouseListener);

    List<BtnAction> getBtnActionLinks();

    void setMainAction(ActionGUI actionGUI);

    void setBounds(Rectangle rectangle);

    void setVisible(boolean visible);

    void setImageBackground(String path);

    void visibleForegroundPanel(Visibility visible);

    void close();

}
