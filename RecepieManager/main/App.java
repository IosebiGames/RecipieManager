package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import Tools.*;
import Tools.Button;
import Tools.Panel;
import recipieSystem.MoreTab;
import recipieSystem.RecipieHandler;

import com.formdev.flatlaf.FlatDarkLaf;

public class App {
	public Screen screen;
	private Seperators sp;
	private Labels lb;
	private TextBox tb;
	private Panel panel;
	private Button button;
	private Decorator dec;
	private RecipieHandler rh;
    public MoreTab mt;
    public Bounds b;
    public JLabel[] labels = {
			new JLabel("Foods & Drinks"), 
			new JLabel(""), 
			new JLabel(""), 
			new JLabel("Recepies"),
			new JLabel(""),
			new JLabel(""),
			new JLabel(""), 
			new JLabel(""), 
			new JLabel(""), 
			new JLabel("Allergens:"),
			new JLabel(""),
			new JLabel("Total Sum:"),
			new JLabel(""),
			new JLabel(""), 
			new JLabel(""),
			new JLabel(""),
			new JLabel(""), 
			new JLabel(""), 
			new JLabel("")
	};
	public JButton[] buttons = {
			new JButton("Burgers:"),
			new JButton("Steak:"),
			new JButton("Ice-Cream:"),
			new JButton("Chicken Salad:"),
			new JButton("Tomato Salad:"),
			new JButton("Next"),
			new JButton("More")
	};
	public JPanel[] panels = {
			new JPanel(),
			new JPanel(),
			new JPanel(),
			new JPanel(),
			new JPanel(),
	};
	public Font[] fonts = {
		new Font("Tahoma", Font.BOLD, 2),
		new Font("Sitka Text", Font.BOLD, 31),
		new Font("Trebuchet MS", Font.BOLD, 18),
	};
	{
		screen = new Screen();
		sp = new Seperators(screen);
		lb = new Labels(screen);
		tb = new TextBox(this);
		panel = new Panel(screen);
		button = new Button();
		dec = new Decorator(this);
		rh = new RecipieHandler(this);
		mt = new MoreTab(this);
        b = new Bounds();
	}
	public App() { 
		screen.createWindow();

		panel.createPanel(panels[0], Bounds.foodPanelBounds, false);
		panel.createPanel(panels[1], Bounds.recipiePanelBounds, false);
		panel.createPanel(panels[2], Bounds.allergenPanelBounds, false);
		panel.createPanel(panels[3], Bounds.sumPanelBounds, false);
		panel.createPanel(panels[4], Bounds.InformationPanelBounds, false);
		
		lb.createLabel(labels[0], fonts[1], Color.yellow, Bounds.foodsLabelBounds, false, panels[0]);
		lb.createLabel(labels[1], null, null, Bounds.DrinkLabelBounds, false, panels[0]);
		lb.createLabel(labels[2], null, null, Bounds.burgerLabelBounds, false, panels[0]);
		lb.createLabel(labels[3], fonts[1], Color.green, Bounds.recipiesLabelBounds, false, panels[1]);
		lb.createLabel(labels[4], null, null, Bounds.burgerFieldLabelBounds, false, panels[1]);
		lb.createLabel(labels[5], null, null, Bounds.DrinkFieldLabelBounds, false, panels[1]);
		lb.createLabel(labels[6], null, null, Bounds.IceCreamFieldLabelBounds, false, panels[1]);
		lb.createLabel(labels[7],null, null, Bounds.TomatoSaladFieldBounds, false, panels[1]);
		lb.createLabel(labels[8], null, null, Bounds.ChickenSaladFieldBounds, false, panels[1]);
		lb.createLabel(labels[9], fonts[1], Color.red, Bounds.allergenLabelBounds, false, panels[2]);
		lb.createLabel(labels[10], null, null, Bounds.AllergenAmountLabelBounds, false, panels[2]);
		lb.createLabel(labels[11], fonts[1], Color.blue, Bounds.totalSumLabelBounds, false, panels[3]);
		lb.createLabel(labels[12], fonts[2], Color.blue, Bounds.SumNumberLabelBounds, false, panels[3]);
		
		button.createButton(buttons[0], Bounds.burgersButtonBounds, false, Color.white, Color.black, panels[1], true);
		button.createButton(buttons[1], Bounds.drinksButtonBounds, false, Color.white, Color.black, panels[1], true);
		button.createButton(buttons[2], Bounds.IceCreamButtonBounds, false, Color.white, Color.black, panels[1], true);
		button.createButton(buttons[3], Bounds.ChickenSaladButtonBounds, false, Color.white, Color.black, panels[1], true);
		button.createButton(buttons[4], Bounds.TomatoSaladButtonBounds, false, Color.white, Color.black, panels[1], true);
		button.createButton(buttons[5], Bounds.NextButtonBounds, false, Color.white, Color.black, panels[0], true);
		button.createButton(buttons[6], Bounds.MoreButtonBounds, false, Color.white, Color.black, panels[2], false);
		
		sp.createSeperator(labels[13], Color.black, fonts[0], Bounds.seperator1Bounds, true);
		sp.createSeperator(labels[14], Color.black, fonts[0], Bounds.seperator2Bounds, true);
		sp.createSeperator(labels[15], Color.black, fonts[0], Bounds.seperator3Bounds, true);
		sp.createSeperator(labels[16], Color.black, fonts[0], Bounds.seperator4Bounds, true);
		sp.createSeperator(labels[17], Color.black, fonts[0], Bounds.seperator5Bounds, true);
		
	    try {
			dec.decorate();
		} catch (IOException e) {
		    System.out.println("Failed to decorate: " + e.getMessage());
		}
	    rh.startRecepieSystem();
	    
	    tb.validate(); 
	}
	public static void main(String[] args) {
	      javax.swing.SwingUtilities.invokeLater(() -> {
	    	  try {
	    		  UIManager.setLookAndFeel(new FlatDarkLaf());
	    	  } catch (UnsupportedLookAndFeelException e) {
	    		  System.out.println("Failed to load Look and Feel: " + e.getMessage());
	    	  }
			 new startup.StartupScreen().timer.start();
	     });
	}
}
