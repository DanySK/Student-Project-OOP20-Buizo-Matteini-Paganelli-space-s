package spaceSurvival.view.pause.factoryMethod;

import spaceSurvival.model.GUI.pause.EnginePause;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.pause.FactoryGUIPause;
import spaceSurvival.view.pause.GUIPause;
import spaceSurvival.view.pause.concrete.GUIPauseConcrete;
import spaceSurvival.view.pause.utilities.IconsButton;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;

public class GUIPauseStandard implements FactoryGUIPause {

    @Override
    public GUIPause create() {
        final GUIPauseConcrete concrete = new GUIPauseConcrete();

        concrete.setFontGUITitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));

        concrete.setForegroundGUI(DesignGraphics.color4);
        concrete.setFontButtons(DesignGraphics.FONT_MEDIUM_STANDARD);
        concrete.setBackgroundButtons(Color.WHITE);


        concrete.setBorder(DesignGraphics.color4, 3);
        concrete.setBounds(Screen.RECTANGLE_MINI);
        concrete.setImageBackground(Background.PAUSE);

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
                    ScaleOf.ICON_SMALL, EnginePause.RECTANGLE.width);
        }

    }
}
