package spaceSurvival.view.GUI.scoreboard.concrete;

import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.AbstractGUI;
import spaceSurvival.view.GUI.scoreboard.GUIScoreboard;
import spaceSurvival.view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;


public class GUIScoreboardConcrete extends AbstractGUI implements GUIScoreboard {
    private final JLabel lbTitle;
    private final JTextField txtSearchName;
    private final JButton btnSearch;
    private final List scoreboard;
    private final ButtonID btnBack;

    public GUIScoreboardConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.txtSearchName = new JTextField();
        this.btnSearch = new JButton();
        this.scoreboard = new List();
        this.btnBack = new ButtonID();
    }

    @Override
    public java.util.List<ButtonID> getButtonLinks() {
        return java.util.List.of(this.btnBack);
    }


    @Override
    public void setNameButtons(java.util.List<String> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.getButton().get(i).setText(listName.get(i));
        }
    }

    @Override
    public void setBtnBackID(IdGUI intoID) {
        this.btnBack.setIdGUICurrent(this.getId());
        this.btnBack.setIdGUINext(intoID);
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
        return scoreboard;
    }

    public JButton getBtnBack() {
        return btnBack;
    }



}
