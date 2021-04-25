package model.image;

import utilities.DimensionScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EngineImage {
    private int width = 0;
    private int height = 0;
    private int rate = 0;
    private String path;

    public EngineImage(){
        this.width = DimensionScreen.WIDTH_FULL_SCREEN;
        this.height = DimensionScreen.HEIGHT_FULL_SCREEN;
    }

    public EngineImage(final String path){
        this();
        this.path = path;
    }

    public EngineImage(final String path, final int width, final int height){
        this(path);
        this.width = width;
        this.height = height;
    }

    public EngineImage(final String path, final Dimension dimension){
        this(path, dimension.width, dimension.height);
    }

    public EngineImage(final int widthScreen, final int rate, final String path){
        this(path);
        this.rate = rate;
        this.setSizeFromRate(widthScreen, this.rate);
    }

    public EngineImage(final String path, final int rate){
        this(path);
        this.rate = rate;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public void setSize(final Dimension dimension){
        this.width = dimension.width;
        this.height = dimension.height;
    }

    public Dimension getSize(){
        return new Dimension(this.width, this.height);
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSizeFromRate(final int rate, final int widthScreen){
        final Dimension dimension = EngineImage.getSizeFromRate(this.path, rate, widthScreen);
        this.width = dimension.width;;
        this.height = dimension.height;
    }

    @Override
    public String toString() {
        return "EngineImage{" +
                "width=" + width +
                ", height=" + height +
                ", path='" + path + '\'' +
                '}';
    }


    public static Dimension getSizeFromRate(final String path, final int rate, final int widthScreen){
        final Dimension dimension = new Dimension();
        try{
            final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource(path));
            dimension.width = widthScreen * rate / 1000;
            dimension.height = img.getHeight() * dimension.width / img.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimension;
    }
}
