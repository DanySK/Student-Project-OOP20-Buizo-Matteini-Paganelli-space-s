package spaceSurvival.view.GUI.loading.factoryMethod;

import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.GUI.loading.FactoryGUILoading;
import spaceSurvival.view.GUI.loading.GUILoading;
import spaceSurvival.view.GUI.loading.concrete.GUILoadingConcrete;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUILoadingStandard implements FactoryGUILoading {

    @Override
    public GUILoading create() {
        GUILoadingConcrete concrete = new GUILoadingConcrete();
        concrete.setBackgroundImage(Background.LOAD1);

        concrete.setFontLbtitle(DesignGraphics.getFontForTitle(100));
        concrete.setForegroundGUI(DesignGraphics.color4);


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

        concrete.getProgressBar().setForeground(DesignGraphics.color4);

        concrete.getProgressBar().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_BAR_LOADING, Screen.WIDTH_FULL_SCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_BAR_LOADING, Screen.HEIGHT_FULL_SCREEN)));


    }
}
