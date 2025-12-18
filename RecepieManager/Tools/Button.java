package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sound.Sound;

public class Button {
	public void createButton(JButton b, int[] bounds, boolean focusableStatus, Color backgroundColor, Color foregroundColor, JPanel panel, boolean visible) {
        b.setFocusable(focusableStatus);
        b.setBackground(backgroundColor);
        b.setForeground(foregroundColor);
        b.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    new Sound().playSound();	
			}        
        });
        panel.add(b);
	}
}
