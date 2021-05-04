package view.GUI.game.utilities;

import model.environment.Point2D;
import model.gameObject.AbstractGameObject;
import model.gameObject.asteroid.Asteroid;
import model.gameObject.weapon.Weapon;
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

        final AbstractGameObject asteroid = new Asteroid(
                new EngineImage(100, DimensionScreen.WIDTH_FULL_SCREEN, IconPath.ICON_BULLET),
                50,50, new Dimension(130, 130), new Point2D(200, 200),
                null, null, null);

        transform.translate(asteroid.getPosition().getX(), asteroid.getPosition().getY());
        this.addGameObject(asteroid, transform);


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