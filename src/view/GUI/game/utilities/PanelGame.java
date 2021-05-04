package view.GUI.game.utilities;

import model.common.P2d;
import model.gameObject.AbstractGameObject;
import model.gameObject.asteroid.Asteroid;
import model.image.EngineImage;
import utilities.DimensionScreen;
import utilities.IconPath;
import view.utilities.JImage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;

public class PanelGame extends JPanel {
    private final Map<AbstractGameObject, AffineTransform> gameObject;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.gameObject = new HashMap<>();

        super.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        final AffineTransform transform = new AffineTransform();


        this.addGameObject(new Asteroid(new EngineImage(30, DimensionScreen.WIDTH_FULL_SCREEN, IconPath.ICON_BULLET),
                50,50, new Dimension(30, 30), new P2d(200, 200), null, null,
                null), transform);

//        transform.translate(asteroid.getPosition().getX(), asteroid.getPosition().getY());
//        this.addGameObject(asteroid, transform);


        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        this.gameObject.forEach((key, value) -> g2d.drawImage(
                this.getImageFromPath(key.getImageEngine()), value, null));
    }

    public void addGameObject(final AbstractGameObject gameObject, final AffineTransform transform) {
        this.gameObject.put(gameObject, transform);
        this.repaint();
    }

    private Image getImageFromPath(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }

}