package sound;

import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class Main2 {
 
    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Slider with change listener");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        // Set the panel to add buttons
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
         
        // Add status label to show the status of the slider
        JLabel status = new JLabel("Slide the slider and you can get its value", JLabel.CENTER);
         
//        // Set the slider
//        SpinnerModel spinnerModel = 
//        	      new SpinnerNumberModel(50, 0, 100, 10);
//        	    JSpinner spinner = new JSpinner(spinnerModel);
        	    
        	    BoundedRangeModel bRangeModel = 
        	    	      new DefaultBoundedRangeModel(50, 1, 0, 100);
        	    	    JSlider s = new JSlider();
        	    	    s.setMinorTickSpacing(10); 
        	    	    s.setSnapToTicks(true);

        	    // changing the stepSize at anytime
        	   // sm.setStepSize(newValue);
         
        // Add the slider to the panel
        panel1.add(s);
         
        // Set the window to be visible as the default to be false
        frame.add(panel1);
        frame.add(status);
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);
 
    }
 
}