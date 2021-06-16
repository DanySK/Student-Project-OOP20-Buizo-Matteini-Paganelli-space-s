package spacesurvival.model;

import spacesurvival.utilities.pathImage.AnimationEffect;
import spacesurvival.view.utilities.JImage;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EngineImage {
    private String path;
    private int width, height;
    private int scaleOf, respectTo;

    public EngineImage(){
        this.path = "";
        this.width = 0;
        this.height = 0;
        this.scaleOf = 0;
        this.respectTo = 0;
    }

    public EngineImage(final String path){
        this();
        this.path = path;
        this.setSize(EngineImage.getSizeFromImage(path));
    }

    public EngineImage(final String path, final int width, final int height) {
        this(path);
        this.setSize(width, height);
    }

    public EngineImage(final String path, final Dimension dimension) {
        this(path, dimension.width, dimension.height);
    }

    public EngineImage(final int scaleOf, final int respectTo, final String path) {
        this(path);
        this.setScale(scaleOf, respectTo);
    }

    public EngineImage(final EngineImage engineImage){
        this.path = engineImage.path;
        this.setScale(engineImage.getScaleOf(), engineImage.getRespectTo());
    }

    public String getPath() {
        return this.path;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getScaleOf() {
        return this.scaleOf;
    }

    public int getRespectTo(){
        return this.respectTo;
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }


    public void setPath(final String path) {
        this.path = path;
    }

    public void setScale(final int scaleOf, final int respectTo) {
        final Dimension sizeScale = EngineImage.getSizeImageFromScale(this.path, scaleOf, respectTo);
        this.scaleOf = scaleOf;
        this.respectTo = respectTo;
        this.setSize(sizeScale);
    }

    public void setScaleOf(final int scaleOf) {
        this.setScale(scaleOf, this.respectTo);
    }

    public void setRespectTo(final int respectTo){
        this.setScale(this.scaleOf, respectTo);
    }

    public void setSize(final int width, final int height){
        this.width = width;
        this.height = height;
    }

    public void setSize(final Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }


    @Override
    public String toString() {
        return "EngineImage{" 
                + "path='" + path + '\'' 
                + ", width=" + width + ", height=" + height 
                + ", scaleOf=" + scaleOf + ", respectTo=" + respectTo + '}';
    }


    public static Dimension getSizeImageFromScale(final String path, final int scaleOf, final int respectTo) {
        final Dimension dimension = new Dimension();
        try {
            final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource(path));
            dimension.width = (respectTo * scaleOf) / 1000;
            dimension.height = (img.getHeight() * dimension.width) / img.getWidth();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimension;
    }

    public static Dimension getSizeFromImage(final String path){
        final Dimension dimension = new Dimension(0, 0);
        try {
            final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource(path));
            dimension.width = img.getWidth();
            dimension.height = img.getHeight();
        } catch (IOException e) { e.printStackTrace(); }

        return dimension;
    }

    public static Image getImageFromEngine(final EngineImage image) {
        final JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }

    public static EngineImage getTransparentEngineImage(final EngineImage engineImage){
        final EngineImage transparent = new EngineImage(engineImage);
        transparent.setPath(AnimationEffect.NORMAL0);
        return transparent;
    }

}
