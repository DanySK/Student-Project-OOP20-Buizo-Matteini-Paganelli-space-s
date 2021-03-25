package model.MyJImage;

public class JImageRateEngine {
    private int rate = 0;
    private String pathImg = "";

    public JImageRateEngine(){
    }

    public JImageRateEngine(final String pathImg){
        this.pathImg = pathImg;
    }

    public JImageRateEngine(final String pathImg, final int rate){
        this(pathImg);
        this.rate = rate;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getPathImg() {
        return this.pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }
}
