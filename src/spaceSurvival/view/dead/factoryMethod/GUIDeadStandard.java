package spaceSurvival.view.dead.factoryMethod;

import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.dead.FactoryGUIDead;
import spaceSurvival.view.dead.GUIDead;

import spaceSurvival.view.dead.concrete.GUIDeadConcrete;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;

public class GUIDeadStandard implements FactoryGUIDead {
    @Override
    public GUIDead create() {
        final GUIDeadConcrete concrete = new GUIDeadConcrete();

        concrete.setFontTitleGUI(DesignGraphics.getFontForDead(DesignGraphics.SIZE_FONT_END));
        concrete.setForegroundTitle(Color.RED);
        concrete.setImageBackground(Background.DEAD2);

        this.createGraphics(concrete);

        return concrete;
    }

    private void createGraphics(final GUIDeadConcrete concrete){
        concrete.setLayout(new BorderLayout());
        

        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitleDead()), BorderLayout.SOUTH);


    }
}
