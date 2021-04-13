package view.GUI;

import utilities.IdGUI;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public interface GUI {

    public void dispose();

    public void setVisible(boolean visible);

    public void setId(final IdGUI id);

    public IdGUI getId();

    public List<ButtonID> getButtonLinks();
}
