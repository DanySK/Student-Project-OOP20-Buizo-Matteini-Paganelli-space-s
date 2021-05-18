package model.GUI.game;

public class Chronometer extends Thread{
    private String timer;

    private int seconds;
    private int minutes;
    private int hours;

    private boolean play;
    private boolean state;

    public Chronometer(){
        super();
        this.timer = "00:00:00";
        this.play = false;
        this.state = false;
    }

    public String getTimer(){
        return this.timer;
    }

    public void finishGame(){
        this.state = false;
    }

    public void play(){
        this.play = true;
    }

    public boolean isPlay(){
        return this.play;
    }


    private void incrSecond(){
        this.seconds++;
    }

    private void control60(){
        if(this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
        }

        if(this.minutes == 60) {
            this.minutes = 0;
            this.hours++;
        }
    }

    private String controlFormat(final int number){
        return number < 10 ? "0" + number : Integer.toString(number);
    }

    private String makeFormatTimer(final String hours, final String minutes, final String seconds, final String split) {
        return hours + split + minutes + split + seconds;
    }


    private void pause(final int millis){
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        this.state = true;

        while(this.state){

            if(this.play) {
                this.incrSecond();
                this.control60();
                this.pause(1000);
            }
            this.timer = this.makeFormatTimer(
                    this.controlFormat(this.hours),
                    this.controlFormat(this.minutes),
                    this.controlFormat(this.seconds), ":");
        }
    }
}
