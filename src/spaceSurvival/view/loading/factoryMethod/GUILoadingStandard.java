package spacesurvival.view.loading.factoryMethod;

import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.pathImage.Background;
import spacesurvival.view.loading.FactoryGUILoading;
import spacesurvival.view.loading.GUILoading;
import spacesurvival.view.loading.concrete.GUILoadingConcrete;
import spacesurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUILoadingStandard implements FactoryGUILoading {

    @Override
    public GUILoading create() {
        GUILoadingConcrete concrete = new GUILoadingConcrete();
        concrete.setImageBackground(Background.LOADING);
        concrete.setFontLbtitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H0));
        concrete.setForegroundGUI(DesignGraphics.COLOR_4);


        graphics(concrete);
        return concrete;
    }

    private void graphics(final GUILoadingConcrete concrete) {
        concrete.setLayout(new BorderLayout());

        JPanel panel1 = FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle());
        FlowLayout flow1 = (FlowLayout) panel1.getLayout();
        flow1.setVgap(FactoryGUIs.INSET_H1);

        concrete.add(panel1, BorderLayout.NORTH);


        JPanel panel = FactoryGUIs.encapsulatesInPanelFlow(concrete.getProgressBar());
        FlowLayout flow = (FlowLayout) panel.getLayout();
        flow.setVgap(FactoryGUIs.EXTREME_INSET);


        concrete.add(FactoryGUIs.encapsulateInPanelBorderOrientation(panel, BorderLayout.SOUTH),
                BorderLayout.CENTER);

        concrete.getProgressBar().setForeground(DesignGraphics.COLOR_4);

        concrete.getProgressBar().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_BAR_LOADING, Screen.WIDTH_FULL_SCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_BAR_LOADING, Screen.HEIGHT_FULL_SCREEN)));
    }
}
