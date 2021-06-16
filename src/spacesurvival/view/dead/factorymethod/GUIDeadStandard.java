package spacesurvival.view.dead.factorymethod;

import spacesurvival.utilities.path.Background;
import spacesurvival.view.dead.FactoryGUIDead;
import spacesurvival.view.dead.GUIDead;

import spacesurvival.view.dead.concrete.GUIDeadConcrete;
import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.*;

public class GUIDeadStandard implements FactoryGUIDead {
    @Override
    public GUIDead create() {
        final GUIDeadConcrete concrete = new GUIDeadConcrete();

        concrete.setFontTitleGUI(DesignGraphics.getFontForDead(DesignGraphics.SIZE_FONT_END));
        concrete.setFontGUI(DesignGraphics.getFontForDead(DesignGraphics.SIZE_FONT_H1));
        concrete.setForegroundTitle(Color.RED);
        concrete.setForegroundGUI(Color.RED);
        concrete.setImageBackground(Background.DEAD2);

        this.createGraphics(concrete);

        return concrete;
    }

    private void createGraphics(final GUIDeadConcrete concrete){
        concrete.setLayout(new BorderLayout());

        concrete.getBtnActionLinks().forEach(FactoryGUIs::setTransparentDesignJButton);

        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitleDead()), BorderLayout.CENTER);

        concrete.add(FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(concrete.getBtnActionLinks(),
                        FactoryGUIs.INSET_H1),
                BorderLayout.SOUTH);


    }
}
