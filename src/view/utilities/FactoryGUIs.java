package view.utilities;

import model.image.EngineImage;
import utilities.DesignSound;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FactoryGUIs {

    public static JPanel encapsulatesInPanel_Flow(Component component){
        JPanel encapsulate = new JPanel(new FlowLayout());
        encapsulate.setOpaque(false);
        encapsulate.add(component);
        return encapsulate;
    }


    public static JPanel encapsulateInPanel_Box_Vertical_Center(Component component){
        JPanel encapsulate = new JPanel();
        encapsulate.setOpaque(false);
        encapsulate.setLayout(new BoxLayout(encapsulate, BoxLayout.X_AXIS));
        encapsulate.add(component);
        return encapsulate;
    }

    public static JPanel encapsulatesVertical(final List<? extends JComponent> components, final int inset){
        JPanel encapsulate = new JPanel(new GridBagLayout()) {{ setOpaque(false); }};
        GridBagConstraints limit = createGBConstraintsBase();
        limit.insets = new Insets(inset / 2,inset,inset / 2,inset);

        for (Component component : components) {
            encapsulate.add(component, limit);
            limit.gridy++;
        }

        return encapsulate;
    }

    public static JPanel encapsulatesHorizontal(List<JComponent> components, final int inset){
        JPanel encapsulate = new JPanel(new GridBagLayout()) {{ setOpaque(false); }};
        GridBagConstraints limit = createGBConstraintsBase();
        limit.insets = new Insets(inset, inset / 2,inset, inset / 2);
        for (JComponent component : components) {
            encapsulate.add(component, limit);
            limit.gridx++;
        }

        return encapsulate;
    }

    public static JPanel getUnionComponents(List<Component> list){
        JPanel unionComponent = new JPanel(new FlowLayout());
        unionComponent.setOpaque(false);
        for (Component component : list) {
            unionComponent.add(component);
        }
        return unionComponent;
    }

    public static void resetGridBagContraints(GridBagConstraints lim){
        lim.ipadx = 0;
        lim.ipady = 0;
        lim.gridx = 0;
        lim.gridy = 0;
    }

    public static GridBagConstraints createGBConstraintsWithSpaceTitle(final int separationTitle){
        GridBagConstraints lim = new GridBagConstraints();
        lim.fill = GridBagConstraints.HORIZONTAL;
        lim.insets = new Insets(3,3,3,3);
        lim.gridx = 0;
        lim.gridy = 0;
        lim.ipady = separationTitle;
        return lim;
    }

    public static GridBagConstraints createGBConstraintsBase(){
        GridBagConstraints lim = new GridBagConstraints();
        lim.fill = GridBagConstraints.HORIZONTAL;
        lim.insets = new Insets(3,3,3,3);
        FactoryGUIs.resetGridBagContraints(lim);
        return lim;
    }

    public static void setTransparentDesignJButton(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
    }

    public static void setIconJButtonFromRate(final JButton button, final String pathIcon,
                                              final int rate, final int widthScreen) {
        EngineImage engineImage = new EngineImage(widthScreen, rate, pathIcon);
        JImage imag = new JImage(pathIcon, engineImage.getSize());
        button.setIcon(imag.getImageIcon());
    }

    public static JComponent getJComponentEmpty(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setSize(0,0);
        return panel;
    }

    public static void setDefaultJSlider(final JSlider slider){
        slider.setOpaque(false);
        slider.setMajorTickSpacing(DesignSound.DEFAULT_MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(DesignSound.DEFAULT_MINOR_TICK_SPACING);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }

}
