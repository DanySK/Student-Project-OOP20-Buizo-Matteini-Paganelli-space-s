package spacesurvival.view.game.utilities;

import spacesurvival.model.World;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Optional;

public class PanelBulletGame extends JPanel {
    private static final long serialVersionUID = -7694414073000255484L;
    private Optional<World> world;

    public PanelBulletGame(){
        super();
        super.setOpaque(false);

        this.world = Optional.empty();
    }

    public void setWorld(final World world) {
        this.world = Optional.of(world);
    }

    @Override
    public final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        this.world.get().getAllBullets().forEach(bullets -> {
            g2d.setTransform(bullets.getTransform());
            g2d.drawImage(bullets.getImgBody(), 0, 0, null);
            g2d.drawImage(bullets.getImgEffect(), 0, 0, null);
        });
    }

}
