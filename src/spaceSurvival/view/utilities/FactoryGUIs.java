package spaceSurvival.view.utilities;

import spaceSurvival.model.EngineImage;
import spaceSurvival.utilities.DesignSound;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FactoryGUIs {
    public static final int EXTREME_INSET = 100;
    public static final int INSET_H1 = 80;
    public static final int MAX_INSET = 10;
    public static final int MEDIUM_INSET = 5;
    public static final int MIN_INSET = 3;

    public static JPanel createPanelTransparent(final LayoutManager layoutManager){
        return new JPanel(layoutManager) {{ setOpaque(false); }};
    }

    public static JPanel encapsulatesInPanelFlow(final Component component){
        final JPanel encapsulate = FactoryGUIs.createPanelTransparent(new FlowLayout());
        encapsulate.add(component);
        return encapsulate;
    }

    public static JPanel encapsulatesInPanelFlowOrientation(final int orientation, final Component component){
        final JPanel encapsulate = createPanelTransparent(new FlowLayout() {{ setAlignment(orientation); }} );
        encapsulate.add(component);
        return encapsulate;
    }

    public static JPanel createPanelFlowUnionComponents(final List<Component> list){
        final JPanel unionComponent =  FactoryGUIs.createPanelTransparent(new FlowLayout());
        for (final Component component : list) {
            unionComponent.add(component);
        }
        return unionComponent;
    }


    public static JPanel encapsulateInPanelBorderOrientation(final Component component, final String border){
        final JPanel panel = FactoryGUIs.createPanelTransparent(new BorderLayout());
        panel.add(component, border);
        return panel;
    }

    public static JPanel encapsulateInPanelVerticalCenter(final Component component){
        final JPanel encapsulate = FactoryGUIs.createPanelTransparent(null);
        encapsulate.setLayout(new BoxLayout(encapsulate, BoxLayout.X_AXIS));
        encapsulate.add(component);
        return encapsulate;
    }

    public static JPanel createPanelGridBagUnionComponentsVertical(final List<? extends  Component> components,
                                                                   final int inset){
        final JPanel encapsulate = FactoryGUIs.createPanelTransparent(new GridBagLayout());
        final GridBagConstraints limit = createGBConstraintsBase();
        limit.insets = new Insets(inset / 2,inset, inset / 2, inset);

        for (final Component component : components) {
            encapsulate.add(component, limit);
            limit.gridy++;
        }
        return encapsulate;
    }

    public static JPanel createPanelGridBagUnionComponentsVerticalInsetExternalSX
            (final List<? extends JComponent> components, final int bottom, final int left){
        final JPanel encapsulate = FactoryGUIs.createPanelTransparent(new GridBagLayout());
        final GridBagConstraints limit = createGBConstraintsBase();
        limit.insets = new Insets(0, 0, 0, 0);

        for (final Component component : components) {
            if(components.indexOf(component) == components.size() - 1){
                limit.insets = new Insets(0, left, bottom, 0);
            }
            encapsulate.add(component, limit);

            limit.gridy++;
        }

        return encapsulate;
    }

    public static JPanel createPanelGridBagUnionComponentsHorizontal(final List<? extends  JComponent> components, final int inset){
        final JPanel encapsulate =  FactoryGUIs.createPanelTransparent(new GridBagLayout());
        final GridBagConstraints limit = createGBConstraintsBase();
        limit.insets = new Insets(inset, inset / 2,inset, inset / 2);

        for (final Component component : components) {
            encapsulate.add(component, limit);
            limit.gridx++;
        }
        return encapsulate;
    }

    public static void resetGridBagConstraints(final GridBagConstraints lim){
        lim.ipadx = 0;
        lim.ipady = 0;
        lim.gridx = 0;
        lim.gridy = 0;
    }

    public static GridBagConstraints createGBConstraintFill(final int fill){
        final GridBagConstraints lim = new GridBagConstraints();
        lim.insets = new Insets(FactoryGUIs.MIN_INSET, FactoryGUIs.MIN_INSET, FactoryGUIs.MIN_INSET,FactoryGUIs.MIN_INSET);
        FactoryGUIs.resetGridBagConstraints(lim);
        lim.fill = fill;
        return lim;
    }

    public static GridBagConstraints createGBConstraintsBase(){
        return FactoryGUIs.createGBConstraintFill(GridBagConstraints.HORIZONTAL);
    }

    public static GridBagConstraints createGBConstraintsWithSpaceTitle(final int separationTitle){
        final GridBagConstraints lim = FactoryGUIs.createGBConstraintFill(GridBagConstraints.HORIZONTAL);

        lim.ipady = separationTitle;
        return lim;
    }

    public static JComponent getJComponentEmpty(){
        return FactoryGUIs.createPanelTransparent(null);
    }

    public static void setDefaultJSlider(final JSlider slider){
        slider.setOpaque(false);
        slider.setMajorTickSpacing(DesignSound.DEFAULT_MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(DesignSound.DEFAULT_MINOR_TICK_SPACING);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }


    public static void setTransparentDesignJButton(final JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
    }

    public static void setIconJButtonFromRate(final JButton button, final String pathIcon,
                                              final int scaleOf, final int respectTo) {
        final EngineImage engineImage = new EngineImage(scaleOf, respectTo, pathIcon);
        final JImage imag = new JImage(pathIcon, engineImage.getSize());
        button.setIcon(imag.getImageIcon());
    }
    
    public static void setIconJButtonFromRate(final JButton button, final EngineImage engineImage) {
    	FactoryGUIs.setIconJButtonFromRate(button, engineImage.getPath(),
                engineImage.getScaleOf(), engineImage.getRespectTo());
    }
}
