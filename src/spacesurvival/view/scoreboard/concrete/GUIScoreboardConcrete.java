package spacesurvival.view.scoreboard.concrete;

import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.scoreboard.GUIScoreboard;
import spacesurvival.view.utilities.BtnAction;

import javax.swing.*;
import java.awt.*;


public class GUIScoreboardConcrete extends AbstractGUI implements GUIScoreboard {
    private static final long serialVersionUID = -108440081332913533L;
    
    private final JLabel lbTitle;
    private final JTextField txtSearchName;
    private final JButton btnSearch;
    private final List scoreboard;
    private final JScrollPane scrollerScoreboard;
    private final BtnAction btnBack;

    public GUIScoreboardConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.txtSearchName = new JTextField();
        this.btnSearch = new JButton();
        this.scoreboard = new List();
        this.scrollerScoreboard = new JScrollPane(scoreboard);
        this.btnBack = new BtnAction();
    }

    @Override
    public java.util.List<BtnAction> getBtnActionLinks() {
        return java.util.List.of(this.btnBack);
    }


    @Override
    public void setNameButtons(final java.util.List<String> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.getButton().get(i).setText(listName.get(i));
        }
    }

    @Override
    public void setBtnBackID(final LinkActionGUI mainAction, final LinkActionGUI action) {
        this.btnBack.setActionCurrent(mainAction);
        this.btnBack.setActionNext(action);
    }

    @Override
    public void setTitleGUI(final String title){
        this.lbTitle.setText(title);
    }

    @Override
    public void setFontGUI(final Font font){
        this.txtSearchName.setFont(font);
        this.btnSearch.setFont(font);
        this.scoreboard.setFont(font);
        this.btnBack.setFont(font);
    }

    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.btnSearch.setForeground(color);
        this.scoreboard.setForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public void setFontLbTitle(final Font font){
        this.lbTitle.setFont(font);
    }

    public java.util.List<JButton> getButton() {
        return java.util.List.of(this.btnSearch, this.btnBack);
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JTextField getTxtSearchName() {
        return txtSearchName;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public List getScoreboard() {
        return this.scoreboard;
    }

    public JScrollPane getScrollerScoreboard(){
        return this.scrollerScoreboard;
    }

    public JButton getBtnBack() {
        return btnBack;
    }



}
