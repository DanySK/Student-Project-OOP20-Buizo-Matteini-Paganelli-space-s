package view.GUI.pause.factoryMethod;


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

        concrete.setBackgroundImage("background/transparent.png");
        concrete.setBorder(3);
        concrete.setBounds(DimensionScreen.RECTANGLE_MINI);

        this.createGraphics(concrete);


        return concrete;
    }

    private void createGraphics(final GUIPauseConcrete concrete){
        concrete.setLayout(new BorderLayout());

        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle()), BorderLayout.NORTH);

        concrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(concrete.getButtonLinks(), 5),
                BorderLayout.CENTER);

    }
}
