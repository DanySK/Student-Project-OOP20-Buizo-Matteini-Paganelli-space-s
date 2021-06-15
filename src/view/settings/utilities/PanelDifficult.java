package view.settings.utilities;

import model.GUI.settings.Difficulty;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelDifficult extends JPanel{
    private final JLabel lbTitle;
    private final ButtonGroup group;
    private final JRadioDifficult rbtEasy;
    private final JRadioDifficult rbtMedium;
    private final JRadioDifficult rbtHard;

    public PanelDifficult(){
        super(new BorderLayout());
        super.setFocusable(false);
        super.setOpaque(false);

        this.lbTitle = new JLabel();
        this.group = new ButtonGroup();
        this.rbtEasy = new JRadioDifficult();
        this.rbtMedium = new JRadioDifficult();
        this.rbtHard = new JRadioDifficult();

        this.createGraphics();
        this.createGroup();
    }

    private void createGraphics(){
        this.add(FactoryGUIs.encapsulatesInPanelFlow(this.lbTitle), BorderLayout.NORTH);
        this.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(this.rbtEasy,this.rbtMedium,this.rbtHard)), BorderLayout.CENTER);

    }

    private void createGroup(){
        this.group.add(this.rbtEasy);
        this.group.add(this.rbtMedium);
        this.group.add(this.rbtHard);
    }

    public void setFontTitleDifficult(final Font font){
        this.lbTitle.setFont(font);
    }

    public void setFontGroupRadioButton(final Font font){
        this.rbtEasy.setFont(font);
        this.rbtMedium.setFont(font);
        this.rbtHard.setFont(font);
    }

    public void setTitle(final String title){
        this.lbTitle.setText(title);
    }

    public void setAllForeground(final Color color){
        this.lbTitle.setForeground(color);
        this.rbtEasy.setForeground(color);
        this.rbtMedium.setForeground(color);
        this.rbtHard.setForeground(color);
    }

    public void setDifficultNames(final List<Difficulty> listDifficult){
        List<JRadioDifficult> listRadio = List.of(this.rbtEasy, this.rbtMedium, this.rbtHard);
        for (int i = 0; i < listDifficult.size(); i++){
            listRadio.get(i).setDifficulty(listDifficult.get(i));
            listRadio.get(i).setText(listDifficult.get(i).getName());
        }
    }

    public void setDifficult(final Difficulty difficulty) {
        List.of(this.rbtEasy, this.rbtMedium, this.rbtHard).stream()
                .filter(rbt -> rbt.getDifficulty() == difficulty)
                .forEach(rbt -> rbt.setSelected(true));
    }

    public List<JRadioDifficult> getDifficult(){
        return  List.of(this.rbtEasy, this.rbtMedium, this.rbtHard);
    }




}
