package spacesurvival.view.dead.factorymethod;

import java.awt.BorderLayout;
import java.awt.Color;
import spacesurvival.utilities.path.Background;
import spacesurvival.view.dead.FactoryGUIDead;
import spacesurvival.view.dead.GUIDead;
import spacesurvival.view.dead.concrete.GUIDeadConcrete;
import spacesurvival.view.utilities.GraphicsUtils;
import spacesurvival.view.utilities.FactoryGUIs;


public class GUIDeadStandard implements FactoryGUIDead {
    @Override
    public GUIDead create() {
        final GUIDeadConcrete concrete = new GUIDeadConcrete();

        concrete.setFontTitleGUI(GraphicsUtils.getFontForDead(GraphicsUtils.SIZE_FONT_H0));
        concrete.setFontGUI(GraphicsUtils.getFontForDead(GraphicsUtils.SIZE_FONT_H2));
        concrete.setForegroundTitle(Color.RED);
        concrete.setForegroundGUI(Color.RED);
        concrete.setImageBackground(Background.DEAD2);

        this.createGraphics(concrete);

        return concrete;
    }

    private void createGraphics(final GUIDeadConcrete concrete) {
        concrete.setLayout(new BorderLayout());

        concrete.getBtnActionLinks().forEach(FactoryGUIs::setTransparentJButton);

        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitleDead()), BorderLayout.CENTER);

        concrete.add(FactoryGUIs.createPanelGridBagUnionComponentsHorizontal(concrete.getBtnActionLinks(),
                FactoryGUIs.INSET_H1),
                BorderLayout.SOUTH);
    }
}
