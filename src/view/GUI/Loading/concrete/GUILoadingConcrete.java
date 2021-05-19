package view.GUI.Loading.concrete;

import factorys.StaticFactoryGUI;
import utilities.DesignSpace;
import utilities.pathImage.Background;
import view.GUI.AbstractGUI;
import view.GUI.Loading.FactoryGUILoading;
import view.GUI.Loading.GUILoading;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUILoadingConcrete extends AbstractGUI implements GUILoading {

    private final JLabel lbTitle;
    private final JProgressBar progressBar;

    public GUILoadingConcrete(){
        super();
        this.lbTitle = new JLabel("SPACE MALAAAAaaaaaAA");
        this.progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of();
    }

    public void setFontLbtitle(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setForegroundGUI(final Color color){
        this.lbTitle.setForeground(color);
    }

    public JLabel getLbTitle() {
        return this.lbTitle;
    }

    public JProgressBar getProgressBar() {
        return this.progressBar;
    }


}
