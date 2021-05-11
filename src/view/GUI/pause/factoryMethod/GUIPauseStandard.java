package view.GUI.pause.factoryMethod;


import utilities.DesignSpace;
import utilities.DimensionScreen;
import view.GUI.pause.FactoryGUIPause;
import view.GUI.pause.GUIPause;
import view.GUI.pause.concrete.GUIPauseConcrete;
import view.utilities.FactoryGUIs;

import java.awt.*;

public class GUIPauseStandard implements FactoryGUIPause {

    @Override
    public GUIPause create() {
        final GUIPauseConcrete concrete = new GUIPauseConcrete();

        concrete.setFontGUITitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_H1));

        concrete.setForegroundGUI(DesignSpace.color4);
        concrete.setFontButtons(DesignSpace.FONT_MEDIUM_STANDARD);
        concrete.setBackgroundButtons(Color.WHITE);


        concrete.setBorder(3);
        concrete.setBounds(DimensionScreen.RECTANGLE_MINI);
        concrete.setBackgroundImage("background/transparent.png");

        this.createGraphics(concrete);


        return concrete;
    }

    private void createGraphics(final GUIPauseConcrete concrete){
        concrete.setLayout(new BorderLayout());

        concrete.getButtonLinks().forEach(btn -> btn.setFocusable(false));



        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle()), BorderLayout.NORTH);

        concrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(concrete.getButtonLinks(), 5),
                BorderLayout.CENTER);

    }
}
