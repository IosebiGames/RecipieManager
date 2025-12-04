package Tools;

import javax.swing.*;
import java.awt.*;

public class Panel {

	private Screen screen;
	
	public Panel(Screen s) {
		this.screen = s;
	}
	public void createPanel(JPanel panel, int[] panelBounds, boolean focusableStatus) {
		panel.setLayout(null);
		panel.setBounds(panelBounds[0], panelBounds[1], panelBounds[2], panelBounds[3]);
		panel.setFocusable(focusableStatus);
	    addBorder(panel);
	    screen.window.add(panel);
	}
	public void addBorder(JPanel panel) {
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}