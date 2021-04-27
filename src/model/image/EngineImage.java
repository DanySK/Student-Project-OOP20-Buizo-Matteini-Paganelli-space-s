package model.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EngineImage {
    private int width;
    private int height;
    private int rate;
    private String path;

    public EngineImage(){ }

    public EngineImage(final String path){
        this.path = path;
    }

    public EngineImage(final String path, final int rate){
        this(path);
        this.rate = rate;
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


    public int getWidth() {
        return this.width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public Dimension getSize(){
        return new Dimension(this.width, this.height);
    }

    public void setSize(final int width, final int height){
        this.width = width;
        this.height = height;
    }

    public void setSize(final Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }

    public void setSizeFromRate(final int rate, final int widthScreen){
        final Dimension dimension = EngineImage.getSizeImageFromRate(this.path, rate, widthScreen);
        this.width = dimension.width;;
        this.height = dimension.height;
    }

    @Override
    public String toString() {
        return "EngineImage{" +
                "width=" + width + ", height=" + height +
                ", path='" + path + '\'' + '}';
    }

    public static Dimension getSizeImageFromRate(final String path, final int rate, final int widthScreen){
        final Dimension dimension = new Dimension();
        try{
            final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource(path));
            dimension.width = (widthScreen * rate) / 1000;
            dimension.height = (img.getHeight() * dimension.width) / img.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimension;
    }
}
