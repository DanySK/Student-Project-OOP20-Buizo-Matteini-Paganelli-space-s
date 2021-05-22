import spaceSurvival.model.ImageDesign;
import spaceSurvival.view.utilities.JImage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Prova {

    public static void main(String[] args) {
        new Prova();
    }

    public Prova() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private float progress = 1f;
        private BufferedImage potion;
        private BufferedImage potionBar;

        public TestPane() {
            try {
                potion = ImageIO.read(getClass().getResource("loading.png"));
                potion = (BufferedImage) potion.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setOpaque(false);

            setForeground(Color.BLUE);
            setBackground(Color.GRAY);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progress -= 0.01;
                    if (progress <= 0.001) {
                        ((Timer) e.getSource()).stop();
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public void invalidate() {
            super.invalidate();
            potionBar = null;
        }

        @Override
        public Dimension getPreferredSize() {
            FontMetrics fm = getFontMetrics(getFont());
            return new Dimension(200, Math.max(50, fm.getHeight() + 4));
        }

        protected void createPotionBar() {

            if (potionBar == null) {
                if (getWidth() > 0 && getHeight() > 0) {
                    FontMetrics fm = getFontMetrics(getFont());
                    int height = Math.max(50, fm.getHeight() + 4);
                    potionBar = new BufferedImage(getWidth() - 4, height, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2d = potionBar.createGraphics();
                    int x = 0;
                    int y = (height - potion.getHeight()) / 2;
                    while (x < getWidth() - 4) {
                        g2d.drawImage(potion, x, y, this);
                        x += potion.getWidth();
                    }
                    g2d.dispose();
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            createPotionBar();
            super.paintComponent(g);

            int width = getWidth() - 4;
            int height = getHeight() - 4;
            int x = 2;
            int y = 2;

            g.setColor(getBackground());
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);

            int progressWidth = (int) (width * progress);
            BufferedImage progressImage = potionBar.getSubimage(0, 0, progressWidth, potionBar.getHeight());
            g.drawImage(progressImage, x, y, this);

            FontMetrics fm = g.getFontMetrics();
            String value = NumberFormat.getPercentInstance().format(progress);
            x = x + ((width - fm.stringWidth(value)) / 2);
            y = y + ((height - fm.getHeight()) / 2);

            g.setColor(Color.WHITE);
            g.drawString(value, x, y + fm.getAscent());

        }
    }

    private Image getImageFromEngine(final ImageDesign image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }
}