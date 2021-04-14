package view.GUI;

import utilities.IdGUI;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.List;

public interface GUI {
    public void addMouseListener(final MouseListener mouseListener);

    public void dispose();

    public void setVisible(boolean visible);

    public void setId(final IdGUI id);

    public IdGUI getId();

    public List<ButtonID> getButtonLinks();

    public void close();
}
