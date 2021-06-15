package spaceSurvival.view;

import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.utilities.FactoryGUIs;
import spaceSurvival.view.utilities.JPanelImage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class AbstractGUI extends JFrame{
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


    public void setMainAction(final ActionGUI actionGUI){
        this.mainAction = actionGUI;
    }

    @Override
    public void setBounds(final Rectangle screen){
        super.setBounds(screen);
        this.panelBackground.setBounds(screen);
        this.panelForeground.setBounds(screen);
    }

    public void setImageBackground(final String path){
        this.panelBackground.setImage(path, super.getSize());
    }

    public void setBorder(final Color color, final int thickness){
        final Border lobstered = BorderFactory.createLoweredBevelBorder();
        final Border line = BorderFactory.createLineBorder(color, thickness);

        this.panelBackground.setBorder(BorderFactory.createCompoundBorder(lobstered, line));
    }


    public void addFrontPanel(final Component component, final String index){
        this.panelForeground.add(component, index);
    }

    public void visibleForegroundPanel(final Visibility visible){
        this.panelForeground.setVisible(visible.isVisible());

    }

    public void close(){
        System.exit(0);
    }

    //    public void paint(Graphics g){
//        this.panelBackground.setBounds(super.getBounds());
//        this.panelForeground.setBounds(super.getBounds());
//        super.paintComponents(g);
//    }
}
