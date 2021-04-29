package model.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EngineImage {
    private int width, height;
    private int scaleOf, respectTo;
    private String path;

    public EngineImage(){ }

    public EngineImage(final String path){
        this.path = path;
        this.setSize(EngineImage.getSizeFromImage(path));
    }

    public EngineImage(final String path, final int width, final int height){
        this(path);
        this.width = width;
        this.height = height;
    }

    public EngineImage(final String path, final Dimension dimension){
        this(path, dimension.width, dimension.height);
    }

    public EngineImage(final int scaleOf, final int respectTo, final String path){
        this(path);
        this.scaleOf = scaleOf;
        this.respectTo = respectTo;
        this.setSizeFromRate(respectTo, scaleOf);
    }

    public String getPath() {
        return this.path;
    }

    public int getWidth() {
        return this.width;
    }

    public int getScaleOf() {
        return this.scaleOf;
    }

    public int getRespectTo(){
        return this.respectTo;
    }

    public Dimension getSize(){
        return new Dimension(this.width, this.height);
    }


    public void setPath(final String path) {
        this.path = path;
        this.setSize(EngineImage.getSizeFromImage(this.path));
    }

    public void setScaleOfRespect(final int scaleOf, final int respectTo) {
        this.scaleOf = scaleOf;
        this.respectTo = respectTo;
        this.setSizeFromRate(this.scaleOf, respectTo);
    }

    public void setScaleToRespect(final int scaleOf) {
        this.setScaleOfRespect(scaleOf, this.respectTo);
    }

    public void setSize(final int width, final int height){
        this.width = width;
        this.height = height;
    }

    public void setSize(final Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }

    private void setSizeFromRate(final int rate, final int widthScreen){
        final Dimension dimension = EngineImage.getSizeImageFromRate(this.path, rate, widthScreen);
        this.scaleOf = rate;
        this.width = dimension.width;
        this.height = dimension.height;
        this.respectTo = widthScreen;
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

    public static Dimension getSizeFromImage(final String path){
        final Dimension dimension = new Dimension();
        try {
            final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource(path));
            dimension.width = img.getWidth();
            dimension.height = img.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimension;
    }

    @Override
    public String toString() {
        return "EngineImage{" +
                "width=" + width + ", height=" + height +
                ", path='" + path + '\'' + '}';
    }
}
