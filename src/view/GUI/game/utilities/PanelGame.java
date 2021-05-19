package view.GUI.game.utilities;

import model.gameObject.GameObject;
import model.gameObject.MainGameObject;
import model.gameObject.MovableGameObject;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import utilities.dimension.Screen;
import view.utilities.JImage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;

public class PanelGame extends JPanel {
    private final Map<GameObject, AffineTransform> gameObject;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.gameObject = new HashMap<>();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        this.gameObject.forEach((key, value) -> {
        	//g2d.setTransform(value);
            g2d.drawImage(this.getImageFromPath(key.getEngineImage()), value, null);
            RectBoundingBox rbb = (RectBoundingBox) key.getBoundingBox();
            g2d.drawRect((int)rbb.getULCorner().getX(), (int)rbb.getULCorner().getY(), (int)rbb.getWidth(), (int)rbb.getHeight() );
            this.drawLifeBar(g2d, (MainGameObject) key, value);
            this.drawLife(g2d, (MainGameObject) key, value);
        });
    }

    public void addGameObject(final GameObject gameObject, final AffineTransform transform) {
        this.gameObject.put(gameObject, transform);
        this.repaint();
    }

    public void deleteGameObject(final GameObject gameObject){
        this.gameObject.remove(gameObject);
        this.repaint();
    }

    private Image getImageFromPath(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }


    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){
        //final int x = (int)transform.getTranslateX();
        //final int y = (int) (transform.getTranslateY() + gameObject.getSize().getHeight() + 2);
//=======

        //final int x = (int) (transform.getTranslateX());
        //final int y = (int) ((transform.getTranslateY()) + (gameObject.getSize().getHeight() + 2));
    	
    	final double x = gameObject.getPosition().getX() * Math.cos(transform.getScaleX());
    	final double y = gameObject.getPosition().getY() * Math.sin(transform.getScaleY());

//>>>>>>> buizo

        //final double p2dX = gameObject.getPosition().x - (gameObject.getSize().getWidth()/2);
        //final double p2dY = gameObject.getPosition().y + (gameObject.getSize().getHeight()/2);
		final RectBoundingBox rect = (RectBoundingBox) gameObject.getBoundingBox();//.getULCorner().getX() - (gameObject.getSize().getWidth()/2);
		//        
		//final double x = rect.getBRCorner().getX() - (gameObject.getSize().getWidth());
		//final double y = rect.getBRCorner().getY();// + (gameObject.getSize().getWidth()/2);
        

        g2d.setColor(Color.WHITE);
        g2d.drawRect((int)x, (int)y, 100, 11);
        //g2d.drawRect((int)p2dX, (int)p2dY, 100, 11);
        //g2d.drawRect(transform, 100,11);
    }

    Integer i = 0;
    int x = 0;
    int y = 0;
    int newPosX = 0;
    int newPosY = 0;
    private void drawLife(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){
       // final int x = (int)transform.getTranslateX();
       // final int y = (int) (transform.getTranslateY() + gameObject.getSize().getHeight() + 3);
        final RectBoundingBox rect = (RectBoundingBox) gameObject.getBoundingBox();
        //final int x = (int) (((int) rect.getBRCorner().getX() - (gameObject.getSize().getWidth()) * transform.getScaleX()));
        //final int y = (int) (rect.getBRCorner().getY() * transform.getScaleY());
        
        //final int x = (int) rect.getULCorner().getX();// * transform.getScaleX());
//        final int x = (int) (transform.getTranslateX());
//        int factor = 1;
//        if(transform.getScaleY()<=0 && transform.getScaleY() >= -0.50) {
//        	factor = -1;
//        	}
//        else {
//        	factor = 1;
//        }
//        
//        final double factorY = gameObject.getSize().getHeight()  * transform.getScaleY() * (factor);
//        //int y = (int) (rect.getULCorner().getY() + factorY);
//        final int y = (int) (transform.getTranslateY() + factorY);
        
        
        double m00 = transform.getScaleX();
 
        double m01 = transform.getShearX();

        
        double m10 = transform.getShearY();
        double m11 = transform.getScaleY();
        
        
        //final int x = (int) gameObject.getPosition().getX();
        //final int y = (int) (gameObject.getPosition().getY()  + (gameObject.getSize().getHeight()));
        
        //final int x = (int) (rect.getBRCorner().getX() + gameObject.getSize().getWidth());
        //final int y = (int) (rect.getBRCorner().getY() + gameObject.getSize().getHeight());

//        if(i==0) {
//        	
//        	x = (int) (rect.getBRCorner().getX() - gameObject.getSize().getWidth());
//        	y = (int) (rect.getBRCorner().getY()+ gameObject.getSize().getHeight());
//        	i++;
//        }
        
         final int x = (int)transform.getTranslateX();
         final int y = (int) (transform.getTranslateY());//+ gameObject.getSize().getHeight() + 3);
        //double[] arrMatrix = new double[6];
 

        
//        for(int i = 0; i < arrMatrix.length; i++) {
//        	System.out.println("Indice arrMatrix["+i+"] -> " + arrMatrix[i]);
//        }
        //System.out.println("transform ScaleX (" + arrMatrix[0] + ";" + arrMatrix[1] + ")");
        //System.out.println("transform ScaleX (" + arrMatrix[3] + ";" + arrMatrix[4] + ")");
        //System.out.println("Factory Y" + factorY);
		//System.out.println("Scale X " + transform.getScaleX());
		//System.out.println("Scale Y " + transform.getScaleY());
        
        //System.out.println("a -> " + m00);
        //System.out.println("b -> " + m01);
        //System.out.println("m10 -> " + m10);
        //System.out.println("m11 -> " + m11);
        
        double b = m01;
        double a = m00;
        
        
        
        double angle = Math.atan2(-b, a);
        
        System.out.println(Math.toDegrees(angle));

        
        
        AffineTransform newAff = new AffineTransform();
        
        //transform.getRotateInstance();
       // AffineTransform.getRotateInstance(transform);
        //newAff.translate(transform.getTranslateX(), transform.getTranslateY());
        
        
        newAff.setToTranslation(transform.getTranslateX(), transform.getTranslateY());
        
        newAff.rotate(angle, gameObject.getPosition().getX(), gameObject.getPosition().getY());

        newAff.translate(0, gameObject.getSize().getHeight() * 2);
        System.out.println(gameObject.getPosition());
        System.out.println(Screen.POINT_CENTER_FULLSCREEN);
        
        //), gameObject.getSize().getWidth()/2, gameObject.getSize().getHeight()/2);
        
        
        g2d.setTransform(newAff);
        g2d.setColor(Color.GREEN);
        //System.out.println(transform.getTranslateX());	

       // x = x - (int)gameObject.getSize().getWidth()/2;
//        MovableGameObject mm = (MovableGameObject) gameObject;
//        newPosY = y +  (int) gameObject.getSize().getHeight()/2 + (int) mm.getVelocity().getY();
//        newPosX = x -  (int) gameObject.getSize().getWidth() /2 + (int) mm.getVelocity().getX();
        
        //System.out.println("newPosX ->" + newPosX);
        //System.out.println("newPosX ->" + newPosY);
        
        
        g2d.fillRect(x, y, 50, 11);
    }
}