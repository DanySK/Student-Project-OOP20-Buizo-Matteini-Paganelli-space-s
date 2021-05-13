package view.GUI.pause.factoryMethod;


import model.GUI.pause.EnginePause;
import utilities.DesignSpace;
import utilities.dimension.ScaleOf;
import utilities.dimension.Screen;
import utilities.pathImage.Background;
import view.GUI.pause.FactoryGUIPause;
import view.GUI.pause.GUIPause;
import view.GUI.pause.concrete.GUIPauseConcrete;
import view.GUI.pause.utilities.IconsButton;
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
        concrete.setBounds(Screen.RECTANGLE_MINI);
        concrete.setBackgroundImage(Background.PAUSE);

        this.createGraphics(concrete);


        return concrete;
    }

    private void createGraphics(final GUIPauseConcrete concrete){
        concrete.setLayout(new BorderLayout());

        concrete.getButtonLinks().forEach(btn -> btn.setFocusable(false));

        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle()), BorderLayout.NORTH);

        concrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(concrete.getButtonLinks(), 5),
                BorderLayout.CENTER);

        for (int i = 0; i < concrete.getButtonLinks().size(); i++){
            FactoryGUIs.setIconJButtonFromRate(concrete.getButton(i), IconsButton.values()[i].getPath(),
                    ScaleOf.ICON_SMALL, EnginePause.DIMENSION.width);
        }

    }
}
