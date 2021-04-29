package view.GUI.menu.factoryMethod;

import utilities.DesignJComponent;
import utilities.DesignSpace;
import view.GUI.menu.FactoryGUIMenu;
import view.GUI.menu.GUIMenu;
import view.GUI.menu.concrete.GUIMenuConcrete;
import view.GUI.menu.utilities.IconsButton;
import view.utilities.FactoryGUIs;

import javax.swing.*;

import java.awt.*;

import java.util.List;

public class GUIMenuStandard implements FactoryGUIMenu {


    @Override
    public GUIMenu createGUI() {
        final GUIMenuConcrete menuConcrete = new GUIMenuConcrete();

        menuConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        menuConcrete.setForegroundGUI(DesignSpace.color4);
        menuConcrete.setFontTitleGUI(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        menuConcrete.setColumnsNamePlayer(DesignJComponent.SIZE_COLUMNS_TEXT);
        menuConcrete.setExtendedState(JFrame.MAXIMIZED_BOTH);

//        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//    	System.out.println(gd.isFullScreenSupported());
//
//        if (gd.isFullScreenSupported()) {
//            gd.setFullScreenWindow(menuConcrete);;
//        } else {
//            System.err.println("Full screen not supported");
//        }
//        
        this.createGraphics(menuConcrete);
        return menuConcrete;
    }

    private void createGraphics(final GUIMenuConcrete menu) {
        menu.setBackgroundLayout(new GridBagLayout());
        int nBtnUsed = 0;

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(DesignJComponent.SIZE_SPACE_TITLE);
        menu.add(menu.getLbTitle(), lim);

        FactoryGUIs.resetGridBagContraints(lim);
        lim.gridy++;

        menu.getButtonLinks().forEach(FactoryGUIs::setTransparentDesignJButton);

        menu.add(FactoryGUIs.getUnionComponents(List.of(menu.getTxfNamePlayer(),
                menu.getButtonLinks().get(nBtnUsed++))), lim);

        while(nBtnUsed < GUIMenuConcrete.N_BUTTONS){
            lim.gridy++;
            menu.add(menu.getButton(nBtnUsed++), lim);
        }

        nBtnUsed = 0;
        while(nBtnUsed < GUIMenuConcrete.N_BUTTONS){
            FactoryGUIs.setIconJButtonFromRate(menu.getButton(nBtnUsed),
                    IconsButton.values()[nBtnUsed++].getPath(), 25, menu.getWidth());
        }
    }

}
