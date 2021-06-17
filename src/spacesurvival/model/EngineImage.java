package spacesurvival.model;

import spacesurvival.utilities.path.AnimationEffect;
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

    /**
     * Return the images's path.
     * @return a path string 
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Set the image's path.
     * 
     * @param path the image's path 
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Return the images's width.
     * @return return the images's width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return the images's height.
     * @return return the images's height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Return the images's scale.
     * @return return the images's scale
     */
    public int getScaleOf() {
        return this.scaleOf;
    }
    
    /**
     * Set the image's scale.
     * 
     * @param scaleOf image's scale
     */
    public void setScaleOf(final int scaleOf) {
        this.setScale(scaleOf, this.respectTo);
    }
    
    /**
     * Set the image's scale respect to other scale.
     * 
     * @param scaleOf image's scale
     * @param respectTo image's respect to
     */
    public void setScale(final int scaleOf, final int respectTo) {
        final Dimension sizeScale = EngineImage.getSizeImageFromScale(this.path, scaleOf, respectTo);
        this.scaleOf = scaleOf;
        this.respectTo = respectTo;
        this.setSize(sizeScale);
    }

    public int getRespectTo(){
        return this.respectTo;
    }
    
    public void setRespectTo(final int respectTo) {
        this.setScale(this.scaleOf, respectTo);
    }

    /**
     * Return the image's dimension.
     * 
     * @return the image's dimension 
     */
    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    /**
     * Set image's size from width and height.
     * 
     * @param width image's width
     * @param height image's height
     */
    public void setSize(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Set image's size from a Dimension.
     * 
     * @param dimension image's dimension
     */
    public void setSize(final Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }

    /**
     * Return the image.
     * 
     * @return the image
     */
    public final Image getImage() {
        return EngineImage.getImageFromEngine(this);
    }

    /**
     * Return a describing string of the engine image.
     * 
     * @return a describing string
     */
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

    /**
     * Return a Dimension from an image path.
     * 
     * @param path the image's path
     * @return dimension the Dimension of the image
     */
    public static Dimension getSizeFromImage(final String path) {
        final Dimension dimension = new Dimension(0, 0);
        try {
            final BufferedImage img = ImageIO.read(ClassLoader.getSystemResource(path));
            dimension.width = img.getWidth();
            dimension.height = img.getHeight();
        } catch (IOException e) { 
            e.printStackTrace(); 
        }

        return dimension;
    }

    /**
     * Return an image from another EngineImage.
     * 
     * @param image the other EngineImage's image
     * @return the Image 
     */
    public static Image getImageFromEngine(final EngineImage image) {
        final JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }

    /**
     * Return a transparent engine image.
     * 
     * @param engineImage to set transparent
     * @return transparent EngineImage transparent
     */
    public static EngineImage getTransparentEngineImage(final EngineImage engineImage) {
        final EngineImage transparent = new EngineImage(engineImage);
        transparent.setPath(AnimationEffect.NORMAL0);
        return transparent;
    }

}
