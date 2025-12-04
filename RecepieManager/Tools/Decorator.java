package Tools;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import main.App;
import sound.Sound;

public class Decorator implements java.awt.event.ActionListener {

    private App app;
    private boolean showingNext = false;
    private Timer imageTimer;
    private int counter = 0;
    private JMenuItem Burgerpick, Drinkpick;
    private JPopupMenu popup1, popup2;
    private int addings = 0;
    
    {
    	Burgerpick = new JMenuItem("Pick (60$)");
    	Drinkpick = new JMenuItem("Pick (90$)");
    	popup1 = new JPopupMenu();
    	popup2 = new JPopupMenu();
    }
    public Decorator(App app) {
        this.app = app;
    }
    public void decorate() {
    	Burgerpick.setFocusable(false);
        Burgerpick.setBackground(Color.white);
        Burgerpick.setForeground(Color.black);
        Burgerpick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    addings += 60;
			    Burgerpick.setEnabled(false);
			    app.labels[12].setText("" + addings);
			}        	
        });
        Drinkpick.setFocusable(false);
        Drinkpick.setBackground(Color.white);
        Drinkpick.setForeground(Color.black);
        Drinkpick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    addings += 90;
			    app.labels[12].setText("" + addings);
			}        	
        });
        popup1.add(Burgerpick);
        popup1.setFocusable(false);
        
        popup2.add(Drinkpick);
        popup2.setFocusable(false);
        
        app.labels[2].setToolTipText("Burgers");
        app.labels[2].setIcon(new ImageIcon(getClass().getResource("/images/Burger.png")));
        app.labels[2].setBorder(BorderFactory.createLineBorder(Color.black));
        app.labels[2].setComponentPopupMenu(popup1);
        app.labels[1].setToolTipText("Salads");
        app.labels[1].setIcon(new ImageIcon(getClass().getResource("/images/TomatoSalad.png")));
        app.labels[1].setBorder(BorderFactory.createLineBorder(Color.black));
        app.labels[1].setComponentPopupMenu(popup2);
        app.buttons[5].addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        new Sound().playSound();
    	if (e.getSource() == app.buttons[5]) {
    		Burgerpick.setEnabled(true);
        	if (!showingNext) {
        		app.labels[2].setIcon(new ImageIcon(getClass().getResource("/images/Steak.png")));
                app.labels[1].setIcon(new ImageIcon(getClass().getResource("/images/ChickenSalad.png")));
                app.labels[2].setToolTipText("Steak");
                app.labels[1].setToolTipText("Chicken Salad");
                app.buttons[5].setText("Back");
                showingNext = true;
                
                counter = 0;

                imageTimer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        counter++;
                        if (counter == 5) {
                            app.labels[1].setIcon(new ImageIcon(getClass().getResource("/images/IceCream.png")));
                            app.labels[1].setToolTipText("Ice Cream");
                        }
                        if (counter == 12) {
                            app.labels[1].setIcon(new ImageIcon(getClass().getResource("/images/ChickenSalad.png")));
                            app.labels[1].setToolTipText("Chicken Salad");
                            counter = 0; 
                        }
                    }
                });
                imageTimer.start();
            } else {
            	Burgerpick.setEnabled(false);
                app.labels[2].setIcon(new ImageIcon(getClass().getResource("/images/Burger.png")));
                app.labels[1].setIcon(new ImageIcon(getClass().getResource("/images/TomatoSalad.png")));
                app.labels[2].setToolTipText("Burgers");
                app.labels[1].setToolTipText("Salads");
                app.buttons[5].setText("Next");
                showingNext = false;
                
                if (imageTimer != null) {
                    imageTimer.stop();
                    counter = 0;
                }
            }
        }
    }
}