package view.GUI.pause.concrete;

import model.GUI.pause.EnginePause;
import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.pause.GUIPause;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIPauseConcrete extends AbstractGUI implements GUIPause {
    private final JLabel lbTitle;
    private final List<ButtonID> links;

    public GUIPauseConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.links = Stream.generate(ButtonID::new)
                .limit(EnginePause.N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return this.links;
    }


    @Override
    public void setNameButtons(final List<String> listNames) {
        for(int i = 0; i < EnginePause.N_BUTTONS; i++){
            this.links.get(i).setText(listNames.get(i));
        }
    }

    @Override
    public void setIdButtons(final List<IdGUI> linksID) {
        for(int i = 0; i < linksID.size(); i++){
            this.links.get(i).setIdGUICurrent(this.getId());
            this.links.get(i).setIdGUINext(linksID.get(i));
        }
    }

    @Override
    public ButtonID getButton(int ind) {
        return this.links.get(ind);
    }


    @Override
    public void setFontGUITitle(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.links.forEach(btn -> btn.setForeground(color));
    }

    @Override
    public void setFontButtons(final Font font) {
        this.links.forEach(link -> link.setFont(font));
    }

    @Override
    public void setBackgroundButtons(final Color color) {
        this.links.forEach(btn -> btn.setBackground(color));
    }

    public JLabel getLbTitle(){
        return this.lbTitle;
    }

}
