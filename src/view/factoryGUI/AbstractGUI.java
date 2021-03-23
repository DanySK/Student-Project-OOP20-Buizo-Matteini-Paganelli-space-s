package view.factoryGUI;

import utilities.DesignSpace;
import utilities.IdGUI;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public abstract class AbstractGUI extends JFrame{
    protected URL imgURL;
    protected ImageIcon icon;

    protected JPanel panel;
    protected IdGUI id;

    public AbstractGUI() {
        super("Space Survival");
        this.imgURL = ClassLoader.getSystemResource("background/background2.png");
        this.icon = new ImageIcon(this.imgURL);
        FactoryGUIs.resizeImage(DesignSpace.GUI_WIDTH, DesignSpace.GUI_HEIGHT,this.icon);
        this.panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, DesignSpace.GUI_WIDTH, DesignSpace.GUI_HEIGHT);

    }

    public void setLayoutGUI(final LayoutManager layout){
        this.panel.setLayout(layout);
    }

    public void setBackgroundGUI(final Color color) {
        this.panel.setBackground(color);
    }

    public IdGUI getId(){
        return this.id;
    }

    public void setId(final IdGUI id){
        this.id = id;
    }

    public void setBackgroundImg(final String pathImg){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.icon.setImage(new ImageIcon(this.imgURL).getImage());
        FactoryGUIs.resizeImage(DesignSpace.GUI_WIDTH, DesignSpace.GUI_HEIGHT,this.icon);
    }

}
