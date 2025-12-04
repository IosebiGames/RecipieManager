package Tools;

import javax.swing.*;
import java.awt.*;

public class Seperators {
	
	private Screen screen;
	
	public Seperators(Screen s) {
		this.screen = s;
	}
	public void createSeperator(JLabel Seperatorlabel, Color backgroundColor, Font font, int[] bounds, boolean opaqueStatus) {
		Seperatorlabel.setBackground(backgroundColor);
		Seperatorlabel.setFont(font);
		Seperatorlabel.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		Seperatorlabel.setOpaque(opaqueStatus);
        screen.window.add(Seperatorlabel);
	}
}