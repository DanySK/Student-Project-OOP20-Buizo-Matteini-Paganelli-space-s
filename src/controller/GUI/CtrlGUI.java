package controller.GUI;

import controller.GUI.Command.CmdEngine;
import controller.GUI.Command.CmdOFF;
import controller.GUI.Command.CmdON;
import model.GUI.EngineGUI;
import model.sound.*;
import utilities.IdGUI;
import utilities.SoundType;
import view.GUI.GUI;
import view.utilities.ButtonID;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CtrlGUI {
    private static final IdGUI FIRST_GUI = IdGUI.ID_MENU;
    private final List<IdGUI> chronology;
    private final List<EngineGUI> listEngine;
    private final List<GUI> listGUI;

    private SoundType soundType;

    private final Logics logics;
    private final SoundObserver observerSoundLoop;


    public CtrlGUI(final List<ControllerGUI> listControlGUI){
        this.listGUI = new ArrayList<>();
        this.listEngine = new ArrayList<>();
        listControlGUI.forEach(control -> {
            CtrlGUI.this.listGUI.add(control.getGUI());
            CtrlGUI.this.listEngine.add(control.getEngine());
        });
        this.chronology = new ArrayList<>(List.of(FIRST_GUI));
        this.soundType = FIRST_GUI.getSound();
        this.logics = new LogicsImpl();
        this.observerSoundLoop = new SoundLoop();

        this.linksAll();
        this.focusMenu();
    }

    private void linksAll(){
        this.observerSoundLoop.update(soundType);
        for(GUI gui : this.listGUI) {
            for(ButtonID btn : gui.getButtonLinks()) {
                btn.addActionListener(e -> {
                    System.out.println("Premuto in: " + btn.getIdGUICurrent() + " Vado in: " + btn.getIdGUINext());

                    if(this.soundType != btn.getIdGUINext().getSound()){
                        this.soundType = btn.getIdGUINext().getSound();
                        this.observerSoundLoop.update(this.soundType);
                    }
                    
                    switch (btn.getIdGUINext()) {
                        case ID_QUIT -> this.quitAll();
                        case ID_BACK -> {
                            this.turnOnGUI(this.penultimateElementOfList());
                            this.turnOffGUI(this.lastElementOfList());
                            this.chronology.remove(this.lastElementOfList());
                        }
                        case ID_SOUND, ID_HELP -> {
                            this.chronology.add(btn.getIdGUINext());
                            this.turnOnGUI(this.lastElementOfList());
                        }
                        default -> {
                            this.chronology.add(btn.getIdGUINext());
                            this.turnOnGUI(this.lastElementOfList());
                            this.turnOffGUI(this.penultimateElementOfList());
                        }
                    }
                    System.out.println("list" + this.chronology);

                });
            }
        }
    }

    private void focusMenu(){
        this.listGUI.forEach(gui -> gui.addMouseListener(this.getMouseListener(gui.getId())));
    }

    private MouseListener getMouseListener(final IdGUI id){
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) {
                if(lastElementOfList() != IdGUI.ID_MENU && id == IdGUI.ID_MENU){
                    int sizeList = chronology.size() - 1;
                    while(sizeList > 0 && !chronology.get(sizeList).equals(IdGUI.ID_MENU)){
                        turnOffGUI(chronology.get(sizeList));
                        chronology.remove(sizeList--);
                    }
                }
                System.out.println("list" + chronology);
            }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        };
    }

    public void turnOnGUI(final IdGUI id){
        CmdEngine onCmdEngine = new CmdON();
        onCmdEngine.execute(this.getEngine(id))
                .execute(this.getGUI(id));
    }

    public void turnOffGUI(final IdGUI id){
        CmdEngine offCmdEngine = new CmdOFF();
        offCmdEngine.execute(this.getEngine(id))
                .execute(this.getGUI(id));
    }

    private IdGUI lastElementOfList(){
        return this.chronology.get(this.chronology.size() - 1);
    }

    private IdGUI penultimateElementOfList(){
        return this.chronology.get(this.chronology.size() - 2);
    }

    private EngineGUI getEngine(IdGUI id){
        for (EngineGUI enigne : this.listEngine) {
            if(enigne.getId() == id){
                return enigne;
            }
        }
        return null;
    }

    private view.GUI.GUI getGUI(IdGUI id){
        for (GUI gui : this.listGUI) {
            if(gui.getId() == id){
                return gui;
            }
        }
        return null;
    }

    private void quitAll(){
        for (GUI gui : this.listGUI) {
            gui.close();
        }
    }
}
