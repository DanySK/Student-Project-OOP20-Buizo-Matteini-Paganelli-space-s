package view.GUI.game.utilities;

import model.gameObject.AbstractGameObject;
import model.image.EngineImage;
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
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        this.gameObject.forEach((key, value) -> {
            g2d.drawImage(this.getImageFromPath(key.getEngineImage()), value, null);

            this.drawLifeBar(g2d, key, value);
            this.drawLife(g2d, key, value);
        });
    }

    public void addGameObject(final AbstractGameObject gameObject, final AffineTransform transform) {
        this.gameObject.put(gameObject, transform);
        this.repaint();
    }

    public void deleteGameObject(final AbstractGameObject gameObject){
        this.gameObject.remove(gameObject);
        this.repaint();
    }

    private Image getImageFromPath(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }

    private void drawLifeBar(final Graphics2D g2d, final AbstractGameObject gameObject, final AffineTransform transform){
        final int x = (int)transform.getTranslateX();
        final int y = (int) (transform.getTranslateY() + gameObject.getSize().getHeight() + 2);

        g2d.setColor(Color.WHITE);
        g2d.drawRect(x, y, 100, 11);
    }

    private void drawLife(final Graphics2D g2d, final AbstractGameObject gameObject, final AffineTransform transform){
        final int x = (int)transform.getTranslateX();
        final int y = (int) (transform.getTranslateY() + gameObject.getSize().getHeight() + 3);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y, 50, 11);
    }
}