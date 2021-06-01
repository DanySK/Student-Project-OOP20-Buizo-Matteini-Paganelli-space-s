package spaceSurvival.view.menu.factoryMethod;

import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.view.menu.FactoryGUIMenu;
import spaceSurvival.view.menu.GUIMenu;
import spaceSurvival.view.menu.concrete.GUIMenuConcrete;
import spaceSurvival.view.menu.utilities.IconsButton;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;

import java.util.List;

public class GUIMenuStandard implements FactoryGUIMenu {


    @Override
    public GUIMenu createGUI() {
        final GUIMenuConcrete menuConcrete = new GUIMenuConcrete();
        menuConcrete.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        menuConcrete.setForegroundGUI(DesignGraphics.COLOR_4);
        menuConcrete.setFontTitleGUI(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        menuConcrete.setColumnsNamePlayer(DesignJComponent.SIZE_COLUMNS_TEXT);
        menuConcrete.setImageBackground(Background.MAIN);
//        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//    	System.out.println(gd.isFullScreenSupported());
//
//        if (gd.isFullScreenSupported()) {
//            gd.setFullScreenWindow(menuConcrete);;
//        } else {
//            System.err.println("Full screen not supported");
//        }
//        menuConcrete.validate();
//        menuConcrete.revalidate();
//        menuConcrete.repaint();
        

        this.createGraphics(menuConcrete);
        return menuConcrete;
    }

    private void createGraphics(final GUIMenuConcrete menu) {
        menu.setLayout(new GridBagLayout());
        int nBtnUsed = 0;

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(DesignJComponent.SIZE_SPACE_TITLE);
        menu.add(menu.getLbTitle(), lim);

        FactoryGUIs.resetGridBagConstraints(lim);
        lim.gridy++;

        menu.getBtnActionLinks().forEach(FactoryGUIs::setTransparentDesignJButton);

        menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getTxfNamePlayer(),
                menu.getBtnActionLinks().get(nBtnUsed++))), lim);

        while(nBtnUsed < EngineGame.N_BUTTONS){
            lim.gridy++;
            menu.add(menu.getButton(nBtnUsed++), lim);
        }

        nBtnUsed = 0;
        while(nBtnUsed < EngineGame.N_BUTTONS){
            FactoryGUIs.setIconJButtonFromRate(menu.getButton(nBtnUsed),
                    IconsButton.values()[nBtnUsed++].getPath(), ScaleOf.ICON_FULL, menu.getWidth());
        }
    }

}
