package spacesurvival.view.loading.factorymethod;

import spacesurvival.view.utilities.GraphicsLayoutUtils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.Background;
import spacesurvival.view.loading.FactoryGuiLoading;
import spacesurvival.view.loading.GUILoading;
import spacesurvival.view.loading.concrete.GUILoadingConcrete;
import spacesurvival.view.utilities.FactoryGUIs;

/**
 * Implements the creation of the compact loading GUI.
 */
public class GuiLoadingStandard implements FactoryGuiLoading {

    /**
     * {@inheritDoc}
     */
    @Override
    public GUILoading create() {
        final GUILoadingConcrete concrete = new GUILoadingConcrete();
        concrete.setImageBackground(Background.LOADING);
        concrete.setFontTitleGUI(GraphicsLayoutUtils.getFontForTitle(GraphicsLayoutUtils.SIZE_FONT_H1));
        concrete.setForegroundGUI(GraphicsLayoutUtils.COLOR_4);


        graphics(concrete);
        return concrete;
    }

    /**
     * Create graphics compact menu GUI.
     * 
     * @param concrete loading to create the graphics.
     */
    private void graphics(final GUILoadingConcrete concrete) {
        concrete.setLayout(new BorderLayout());

        final JPanel panel1 = FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle());
        final FlowLayout flow1 = (FlowLayout) panel1.getLayout();
        flow1.setVgap(FactoryGUIs.INSET_H1);

        concrete.add(panel1, BorderLayout.NORTH);


        final JPanel panel = FactoryGUIs.encapsulatesInPanelFlow(concrete.getProgressBar());
        final FlowLayout flow = (FlowLayout) panel.getLayout();
        flow.setVgap(FactoryGUIs.INSET_H0);


        concrete.add(FactoryGUIs.encapsulateInPanelBorderOrientation(panel, BorderLayout.SOUTH),
                BorderLayout.CENTER);

        concrete.getProgressBar().setForeground(GraphicsLayoutUtils.COLOR_4);

        concrete.getProgressBar().setPreferredSize(new Dimension(
                Screen.scaleRespectTo(ScaleOf.WIDTH_BAR_LOADING, Screen.WIDTH_FULLSCREEN),
                Screen.scaleRespectTo(ScaleOf.HEIGHT_BAR_LOADING, Screen.HEIGHT_FULLSCREEN)));
    }
}
