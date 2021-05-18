package model.GUI.game;

public class Chronometer extends Thread{
    private String timer;

    private int seconds;
    private int minutes;
    private int hours;

    private boolean go;

    public Chronometer(){
        super();
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
        this.go = false;
    }

    public String getTimer(){
        return this.timer;
    }

    public void arrest(){
        this.go = false;
    }

    private void pause(final int millis){
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void control60(){
        if(this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
        }

        if(this.minutes == 60) {
            this.minutes = 0;
            this.hours++;
        }
    }

    public String controlFormat(final int number){
        return number < 10 ? "0" + number : Integer.toString(number);
    }

    public String makeFormatTimer(final String hours, final String minutes, final String seconds, final String split) {
        return hours + split + minutes + split + seconds;
    }

    @Override
    public synchronized void run(){
        this.go = true;

        while(this.go){
            this.pause(1000);

            this.seconds++;
            this.control60();

            this.timer = this.makeFormatTimer(
                    this.controlFormat(this.hours),
                    this.controlFormat(this.minutes),
                    this.controlFormat(this.seconds), ":");

            System.out.println(this.getTimer());
        }
    }

    public static void main(String[] args) {
        Chronometer timer = new Chronometer();

        timer.start();


    }



}
