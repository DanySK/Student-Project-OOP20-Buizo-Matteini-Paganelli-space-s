package view.GUI.Loading.factoryMethod;

import factorys.StaticFactoryGUI;
import utilities.DesignSpace;
import utilities.pathImage.Background;
import view.GUI.Loading.FactoryGUILoading;
import view.GUI.Loading.GUILoading;
import view.GUI.Loading.concrete.GUILoadingConcrete;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUILoadingStandard implements FactoryGUILoading {

    @Override
    public GUILoading create() {
        GUILoadingConcrete concrete = new GUILoadingConcrete();
        concrete.setBackgroundImage(Background.LOAD1);

        concrete.setFontLbtitle(DesignSpace.getFontForTitle(100));
        concrete.setForegroundGUI(DesignSpace.color4);


        graphics(concrete);
        concrete.validate();
        return concrete;
    }

    private void graphics(final GUILoadingConcrete concrete) {
        concrete.setBackgroundLayout(new BorderLayout());

        JPanel panel1 = FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle());
        FlowLayout flow1 = (FlowLayout) panel1.getLayout();
        flow1.setVgap(80);

        concrete.add(panel1, BorderLayout.NORTH);


        JPanel panel = FactoryGUIs.encapsulatesInPanelFlow(concrete.getProgressBar());
        FlowLayout flow = (FlowLayout) panel.getLayout();
        flow.setVgap(100);


        concrete.add(FactoryGUIs.encapsulateInPanelBorderOrientation(panel, BorderLayout.SOUTH),
                BorderLayout.CENTER);

        concrete.getProgressBar().setValue(50);
        concrete.getProgressBar().setForeground(DesignSpace.color4);

        concrete.getProgressBar().setPreferredSize(new Dimension(1600, 45));


    }
}
