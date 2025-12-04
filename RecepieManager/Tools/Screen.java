package Tools;

import javax.swing.*;
import java.awt.*;

public class Screen {
	
	public JFrame window;
	
	public void createWindow() {
		window = new JFrame("Recepie Manager");
		window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(804, 484));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.getContentPane().setLayout(null);
        
        setIcon(new ImageIcon(getClass().getResource("/images/icon.png")));
	}
	private void setIcon(ImageIcon icon) {
		window.setIconImage(icon.getImage());
	}
}