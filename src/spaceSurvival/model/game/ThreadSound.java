package spaceSurvival.model.game;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.controller.GUI.CtrlSound;
import spaceSurvival.controller.sound.CallerAudio;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.sound.category.SoundLoop;
import spaceSurvival.utilities.DesignSound;

public class ThreadSound extends Thread{
    private boolean state = true;
    private CallerAudio callerAudio;
    private CtrlSound ctrlSound;

    public ThreadSound(){
    }

    public ThreadSound(final CallerAudio callerAudio, final CtrlSound ctrlGUI){
        this.callerAudio = callerAudio;
        this.ctrlSound = ctrlGUI;
    }

    @Override
    public synchronized void run() {

        while(state){
            System.out.println("Cambio dal thread");
//            if(this.callerAudio.isNewSound(this.ctrlGUI.getCurrentSound())) {
//
//                this.callerAudio.execute(CmdAudioType.AUDIO_OFF);
//                this.callerAudio.setSound(new SoundLoop(this.ctrlGUI.getCurrentSound()));
//
//                this.callerAudio.changeVolume(this.ctrlGUI.isActiveLoopUnitSound() ?
//                        this.ctrlGUI.getCurrentLoopVolume() : DesignSound.SOUND_ZERO);
//
//                this.callerAudio.execute(CmdAudioType.AUDIO_ON);
//            }
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

//    public CtrlGUI getCtrlGUI() {
//        return this.ctrlGUI;
//    }
//
//    public void setCtrlGUI(final CtrlGUI ctrlGUI) {
//        this.ctrlGUI = ctrlGUI;
//    }

    private void renderAudioLoop(){

    }
}
