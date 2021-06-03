package spaceSurvival.model.GUI.game;

public class EngineHUD {
    public static final long INIT_SCORE = 0L;
    public static final int INIT_ROUND = 1;
    public static final int INIT_HEART = 3;
    public static final int DECR_VALUE = 1;
    public static final int DEAD = 0;

    private final Chronometer chronometer;
    private long score;
    private int round;
    private int lives;

    public EngineHUD() {
        this.chronometer = new Chronometer();
        this.score = INIT_SCORE;
        this.round = INIT_ROUND;
        this.lives = INIT_HEART;
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
        this.round += DECR_VALUE;
    }

    public int getLives() {
        return this.lives;
    }

    public void setHeartShip(final int heartShip) {
        this.lives = heartShip;
    }

    public void increaseLives(final int amount){
        this.lives += amount;
    }
    
    public void decreaseLives(){
        this.lives -= DECR_VALUE;
    }

    public boolean isGameOver(){
        return this.lives == DEAD;
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
