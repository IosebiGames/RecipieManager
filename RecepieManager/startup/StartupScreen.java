package startup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.App;
import Tools.Bounds;

public class StartupScreen {
	
	private JFrame window;
	private JProgressBar bar;
	private int procentage = 0;
	public Timer timer;
	private boolean startup_permission = true;
	
	public StartupScreen() {
	   window = new JFrame("Recepie Manager");
	   window.setResizable(false);
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   window.setPreferredSize(new Dimension(270, 100));
       window.pack();
       window.setLocationRelativeTo(null);
       window.setVisible(true);
       window.getContentPane().setLayout(null);
   
       setIcon(new ImageIcon(getClass().getResource("/images/icon.png")));

       bar = createBar("Loading.....", 0, true, Bounds.BarBounds, Color.white, Color.red, window, false, true);
     
       timer = new Timer(100, new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   procentage++;
    		   bar.setValue(procentage);
    		   check(startup_permission);
    	   }			
       });
	}
	private void check(boolean p) {
		if(p) {
			if(procentage == 81) bar.setString("Almost there....");
			if(procentage == 91) bar.setString("Finishing up....");
			if(procentage == 97) bar.setString("Done....");
			if(procentage == 100) {
				procentage = 100; 
				window.dispose();
				new App();
			}
		}else {
			if(procentage == 81) bar.setString("Shutting down...");
			if(procentage == 91) System.exit(0);
		}
	}
	private void setIcon(ImageIcon icon) {
		window.setIconImage(icon.getImage());
    }
	private JProgressBar createBar(String text, int value, boolean visible, int[] bounds, Color bc, Color fg, JFrame window, boolean focusable, boolean extrab) {
		 bar = new JProgressBar();
		 bar.setFocusable(focusable);
		 bar.setValue(value);
		 bar.setString(text);
		 bar.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		 bar.setBackground(bc);
		 bar.setForeground(fg);
		 bar.setStringPainted(extrab);
		 window.add(bar);
		 return bar;
	}
}