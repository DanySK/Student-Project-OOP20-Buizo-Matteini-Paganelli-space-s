package spacesurvival.view;

import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.utilities.FactoryGUIs;
import spacesurvival.view.utilities.JPanelImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public abstract class AbstractGUI extends JFrame {
    private static final long serialVersionUID = -4633648377297371296L;
    private final JPanelImage panelBackground;
    private final JPanel panelForeground;

    private ActionGUI mainAction;

    public AbstractGUI() {
        super();
        this.panelBackground = new JPanelImage();
        this.panelForeground = FactoryGUIs.createPanelTransparent(new BorderLayout());

        super.setContentPane(this.panelBackground);
        super.setGlassPane(this.panelForeground);

        FactoryGUIs.setDefaultJFrame(this);
    }


    public void setMainAction(final ActionGUI actionGUI) {
        this.mainAction = actionGUI;
    }

    @Override
    public void setBounds(final Rectangle screen){
        super.setBounds(screen);
        this.panelBackground.setBounds(screen);
        this.panelForeground.setBounds(screen);
    }

    public void setImageBackground(final String path) {
        this.panelBackground.setImage(path, super.getSize());
    }

    public void setBorder(final Color color, final int thickness) {
        final Border lobstered = BorderFactory.createLoweredBevelBorder();
        final Border line = BorderFactory.createLineBorder(color, thickness);

        this.panelBackground.setBorder(BorderFactory.createCompoundBorder(lobstered, line));
    }


    public void addFrontPanel(final Component component, final String index) {
        this.panelForeground.add(component, index);
    }

    public void visibleForegroundPanel(final Visibility visible) {
        this.panelForeground.setVisible(visible.isVisible());

    }

    public void close() {
        System.exit(0);
    }

}
