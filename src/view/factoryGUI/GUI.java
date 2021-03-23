package view.factoryGUI;

import utilities.IdGUI;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public interface GUI {


    public void setAllForeground(final Color color);

    public void setFontLbTitle(final Font font);

    public void setAllFontNotLbTitle(final Font font);


    public void validate();

    public void dispose();

    public void setVisible(boolean visible);


    public void setId(final IdGUI id);

    public IdGUI getId();

    public List<? extends JButton> getButtons();

    public List<ButtonID> getLinksButtons();




}
