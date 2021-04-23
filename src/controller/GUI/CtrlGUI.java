package controller.GUI;

import controller.GUI.command.SwitchGUI;
import controller.utilities.ListGUI;
import model.GUI.EngineGUI;
import model.sound.*;
import model.sound.category.SoundLoop;
import utilities.IdGUI;
import utilities.SoundPath;
import view.GUI.GUI;
import view.utilities.ButtonID;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CtrlGUI {
    private static final IdGUI FIRST_GUI = IdGUI.ID_MENU;
    private final ListGUI<IdGUI> chronology;
    private final List<EngineGUI> listEngine;
    private final List<GUI> listGUI;

    private final SwitchGUI switchGUI;

    private SoundPath soundPath;
    private final Logics logics;
    private final SoundObserver observerSoundLoop;


    public CtrlGUI(final List<ControllerGUI> listControlGUI){
        this.listGUI = new ArrayList<>();
        this.listEngine = new ArrayList<>();
        this.switchGUI = new SwitchGUI();

        listControlGUI.forEach(control -> {
            CtrlGUI.this.listGUI.add(control.getGUI());
            CtrlGUI.this.listEngine.add(control.getEngine());
        });

        this.chronology = new ListGUI<>() {{ add(FIRST_GUI); }};
        this.soundPath = FIRST_GUI.getSound();
        this.logics = new LogicsImpl();


        this.observerSoundLoop = new SoundLoop() {{ update(CtrlGUI.this.soundPath); }};

        this.linksAll();
        this.focusMenu();

        this.switchGUI.turnOnGUI(this.getEngine(FIRST_GUI), this.getGUI(FIRST_GUI));
    }

    private void linksAll(){
        for(GUI gui : this.listGUI) {
            for(ButtonID btn : gui.getButtonLinks()) {
                btn.addActionListener(e -> {
                    System.out.println("Premuto in: " + btn.getIdGUICurrent() + " Vado in: " + btn.getIdGUINext());

                    if(this.soundPath != btn.getIdGUINext().getSound()){
                        this.soundPath = btn.getIdGUINext().getSound();
                        this.observerSoundLoop.update(this.soundPath);
                    }

                    switch (btn.getIdGUINext()) {
                        case ID_QUIT -> this.quitAll();
                        case ID_BACK -> {
                            this.switchGUI.turnOnGUI(
                                    this.getEngine(this.chronology.penultimateElementOfList()),
                                    this.getGUI(this.chronology.penultimateElementOfList()));
                            this.switchGUI.turnOffGUI(
                                    this.getEngine(this.chronology.lastElementOfList()),
                                    this.getGUI(this.chronology.lastElementOfList()));
                            this.chronology.remove(this.chronology.lastElementOfList());
                        }
                        case ID_SOUND, ID_HELP -> {
                            this.chronology.add(btn.getIdGUINext());
                            this.switchGUI.turnOnGUI(
                                    this.getEngine(this.chronology.lastElementOfList()),
                                    this.getGUI(this.chronology.lastElementOfList()));
                        }
                        default -> {
                            this.chronology.add(btn.getIdGUINext());
                            this.switchGUI.turnOnGUI(
                                    this.getEngine(this.chronology.lastElementOfList()),
                                    this.getGUI(this.chronology.lastElementOfList()));
                            this.switchGUI.turnOffGUI(
                                    this.getEngine(this.chronology.penultimateElementOfList()),
                                    this.getGUI(this.chronology.penultimateElementOfList()));
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
                if(chronology.lastElementOfList() != IdGUI.ID_MENU && id == IdGUI.ID_MENU){
                    int sizeList = chronology.size() - 1;
                    while(sizeList > 0 && !chronology.get(sizeList).equals(IdGUI.ID_MENU)){
                        switchGUI.turnOffGUI(getEngine(chronology.get(sizeList)),
                                getGUI(chronology.get(sizeList)));
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

    private EngineGUI getEngine(IdGUI id){
        for (EngineGUI engine : this.listEngine) {
            if(engine.getId() == id){
                return engine;
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
