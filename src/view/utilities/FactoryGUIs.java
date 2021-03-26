package view.utilities;

import utilities.DesignSpace;

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

    public static JPanel encapsulatesInPanel_Box_Vertical_Center(Component component){
        JPanel encapsulate = new JPanel();
        encapsulate.setOpaque(false);
        encapsulate.setLayout(new BoxLayout(encapsulate, BoxLayout.X_AXIS));
        encapsulate.add(component);
        return encapsulate;
    }

    public static JPanel getUnionComponents(List<JComponent> list){
        JPanel unionComponent = new JPanel(new FlowLayout());
        unionComponent.setOpaque(false);
        for (JComponent component : list) {
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

    public static void resizeImage(final int width, final int height, ImageIcon imageIcon){
        Image img = imageIcon.getImage();
        Image resizeImage = img.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
        imageIcon.setImage(resizeImage);
    }

    public static void resizeImage(final Dimension dimension, ImageIcon imageIcon){
        Image img = imageIcon.getImage();
        Image resizeImage = img.getScaledInstance(dimension.width, dimension.height, Image.SCALE_AREA_AVERAGING);
        imageIcon.setImage(resizeImage);
    }


    public static void setTransparentDesignJButton(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
    }

    public static void setNotFocusable(Component component){
        component.setFocusable(false);
    }

    public static void setIconInJButton(JButton button, final String pathIcon) {
        JImageRate imag = new JImageRate(pathIcon, 5);
        button.setIcon(imag.getIcon());
    }

    public static void rateImage(final int rate, ImageIcon imageIcon){
        int widthRateImage = DesignSpace.GUI_WIDTH * rate / 100;
        int heightRateImage = imageIcon.getIconHeight() * widthRateImage / imageIcon.getIconWidth();
        resizeImage(widthRateImage, heightRateImage, imageIcon);
    }



}
