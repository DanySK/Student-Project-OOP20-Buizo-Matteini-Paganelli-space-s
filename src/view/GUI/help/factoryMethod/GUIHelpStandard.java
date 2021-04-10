package view.GUI.help.factoryMethod;

import view.GUI.help.concrete.GUIHelpConcrete;
import view.GUI.help.FactoryGUIHelp;
import view.GUI.help.GUIHelp;
import view.GUI.help.utilities.HelpPanel;
import utilities.DesignSpace;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;


public class GUIHelpStandard implements FactoryGUIHelp {
    private GUIHelpConcrete GUIHelpConcrete = new GUIHelpConcrete();

    @Override
    public GUIHelp create(){
        this.GUIHelpConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.GUIHelpConcrete.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.GUIHelpConcrete.setAllForeground(DesignSpace.color4);
        this.createGraphics();
        this.GUIHelpConcrete.validate();
        return this.GUIHelpConcrete;
    }

    private void createGraphics() {
        this.GUIHelpConcrete.setLayoutGUI(new BorderLayout());
        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        this.GUIHelpConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(this.GUIHelpConcrete.getLbTitle()),
                BorderLayout.NORTH);

        JPanel panelContainPanel = new JPanel(new GridBagLayout());
        panelContainPanel.setOpaque(false);

        for (HelpPanel panelHelp : this.GUIHelpConcrete.getHelpPanels()) {
            panelContainPanel.add(panelHelp, lim);
            lim.gridy++;
        }

        this.GUIHelpConcrete.add(panelContainPanel, BorderLayout.CENTER);
        FactoryGUIs.setTransparentDesignJButton(this.GUIHelpConcrete.getBtnBack());
        FactoryGUIs.setIconInJButtonMini(this.GUIHelpConcrete.getBtnBack(), "iconButton/back.png");
        this.GUIHelpConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(this.GUIHelpConcrete.getBtnBack()), BorderLayout.SOUTH);
    }


}
