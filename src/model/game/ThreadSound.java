package model.game;

import controller.GUI.CtrlGUI;
import controller.sound.CallerAudio;
import model.sound.CmdAudioType;
import model.sound.category.SoundLoop;
import utilities.DesignSound;

public class ThreadSound extends Thread{
    private boolean state = true;
    private CallerAudio callerAudio;
    private CtrlGUI ctrlGUI;

    public ThreadSound(){
    }

    public ThreadSound(final CallerAudio callerAudio, final CtrlGUI ctrlGUI){
        this.callerAudio = callerAudio;
        this.ctrlGUI = ctrlGUI;
    }

    @Override
    public synchronized void run() {

        while(state){
            System.out.println("Cambio dal thread");
            if(this.callerAudio.isNewSound(this.ctrlGUI.getCurrentSound())) {

                this.callerAudio.execute(CmdAudioType.AUDIO_OFF);
                this.callerAudio.setSound(new SoundLoop(this.ctrlGUI.getCurrentSound()));

                this.callerAudio.changeVolume(this.ctrlGUI.isActiveLoopUnitSound() ?
                        this.ctrlGUI.getCurrentLoopVolume() : DesignSound.SOUND_ZERO);

                this.callerAudio.execute(CmdAudioType.AUDIO_ON);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public CallerAudio getCallerAudio() {
        return this.callerAudio;
    }

    public void setCallerAudio(final CallerAudio callerAudio) {
        this.callerAudio = callerAudio;
    }

    public CtrlGUI getCtrlGUI() {
        return this.ctrlGUI;
    }

    public void setCtrlGUI(final CtrlGUI ctrlGUI) {
        this.ctrlGUI = ctrlGUI;
    }

    private void renderAudioLoop(){

    }
}
