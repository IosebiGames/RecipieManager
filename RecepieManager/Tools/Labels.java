package Tools;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Labels {
	private Screen screen;

	public Labels(Screen s) {
		this.screen = s;
	}

	public void createLabel(JLabel label, Font font, Color foregroundColor, int[] labelBounds, boolean focusableStatus, JPanel partPanel) {
		label.setBounds(labelBounds[0], labelBounds[1], labelBounds[2], labelBounds[3]);
		label.setFocusable(focusableStatus);
		label.setForeground(foregroundColor);
		label.setFont(font);
		this.screen.window.add(label);
		if (partPanel != null) {
			partPanel.add(label);
		}
	}
}