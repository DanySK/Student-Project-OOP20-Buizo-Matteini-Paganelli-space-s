package model.MyJImage;

import java.awt.*;

public class MyJImageEngine {
    private int width = 0;
    private int height = 0;
    private String path;

    public MyJImageEngine(final int width, final int height, final String path){
        this.width = width;
        this.height = height;
        this.path = path;
    }

    public MyJImageEngine(final String path){
        this.path = path;
    }

    public MyJImageEngine(final Dimension dimension, final String path){
        this.width = dimension.width;
        this.height = dimension.height;
        this.path = path;
    }

    public Dimension getDimensionImage(){
        return new Dimension(this.width, this.height);
    }

    public void setDimensionImage(final Dimension dimension){
        this.width = dimension.width;
        this.height = dimension.height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPath() {
        return path;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyJImageEngine{" +
                "width=" + width +
                ", height=" + height +
                ", path='" + path + '\'' +
                '}';
    }
}
