package spaceSurvival.view.loading.concrete;

import spaceSurvival.view.AbstractGUI;
import spaceSurvival.view.loading.GUILoading;
import spaceSurvival.view.loading.utilities.LoadingBar;
import spaceSurvival.view.utilities.BtnAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUILoadingConcrete extends AbstractGUI implements GUILoading {
    private final JLabel lbTitle;
    private final LoadingBar progressBar;

    public GUILoadingConcrete(){
        super();
        this.lbTitle = new JLabel("SPACE SURVIVAL");
        this.progressBar = new LoadingBar();
    }

    @Override
    public List<BtnAction> getButtonLinks() {
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


    @Override
    public void setLoading(int value) {
        this.progressBar.setValue(value);
    }


}
