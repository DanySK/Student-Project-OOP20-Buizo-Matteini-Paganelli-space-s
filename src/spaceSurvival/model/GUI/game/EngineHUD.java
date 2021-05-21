package spaceSurvival.model.GUI.game;

public class EngineHUD {
    public static final long INIT_SCORE = 0L;
    public static final int INIT_ROUND = 1;
    public static final int INIT_HEART = 3;
    public static final int DEAD = 0;

    private final Chronometer chronometer;
    private long score;
    private int round;
    private int heartShip;

    public EngineHUD(){
        this.chronometer = new Chronometer();
        this.score = INIT_SCORE;
        this.round = INIT_ROUND;
        this.heartShip = INIT_HEART;
    }

    public long getScore() {
        return this.score;
    }

    public void incrScore(final long score) {
        this.score += score;
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(final int round) {
        this.round = round;
    }

    public void incrRound(){
        this.round++;
    }

    public int getHeartShip() {
        return this.heartShip;
    }

    public void setHeartShip(final int heartShip) {
        this.heartShip = heartShip;
    }

    public void decrHeartShip(){
        this.heartShip--;
    }

    public boolean isGameOver(){
        return this.heartShip == DEAD;
    }

    public boolean isStartTimer(){
        return this.chronometer.isPlay();
    }

    public String getTimer(){
        return this.chronometer.getTimer();
    }

    public void initTimer(){
        this.chronometer.start();
    }

    public void startTimer(){
        this.chronometer.play();
    }
}
