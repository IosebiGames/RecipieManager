package recepieSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Tools.Bounds;
import Tools.Button;
import Tools.Labels;
import Tools.Panel;
import main.App;
import com.formdev.flatlaf.FlatDarkLaf;

public class MoreTab {
	private JFrame window;
	private Panel p;
    private Labels l;
    private Button b;
    private App app;
	public JButton[] buttons = {
			new JButton("Request all Recepies"),
			new JButton("Close"),	
	};
	public JLabel[] labels = {
			new JLabel("Product:"),
		    new JLabel("Calories:"),
			new JLabel("Possible Vitamins:"),
			new JLabel("Fats:"),
		    new JLabel("Sodium:"),
		    new JLabel("Protein:"),
		    new JLabel("Water Content:"),
		    new JLabel("Allergens:"),
	};
	public JPanel[] panels = {
		    new JPanel()
	};
	private RecepieHandler rh;
    private Timer resetTimer;
    private int counter = 0;
    private JComboBox<?> productBox;
    private final String[] products = new String[] {"Meat", "Tomato Salad", "Chicken Salad", "Ice-Cream", "Burger"};
	{
		window = new JFrame("More Information");
	    productBox = new JComboBox<>(products);
	    
	    resetTimer = new Timer(1000, _ -> {
	    	 counter++;
	    	 if(counter == 4) {
	    		 counter = 0;
	    		 buttons[1].setBackground(Color.white);
	    		 resetTimer.stop();
	     	 }
	    });
	}
	public MoreTab(App app) {
		this.app = app;
	}
	public void openMoreTab() {
		p = new Panel(app.screen);
		l = new Labels(app.screen);
		b = new Button();
		rh = new RecepieHandler(app);
		resetTimer.start();
		window.setResizable(false);
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		
		window.setPreferredSize(new Dimension(306, 459));
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
		window.addWindowListener(new WindowH());

		p.createPanel(panels[0], Bounds.productPanelBounds, false);
		
		b.createButton(buttons[0], Bounds.requestButtonBounds, false, Color.white, Color.black, panels[0], true);
		b.createButton(buttons[1], Bounds.CloseButtonBounds, false, Color.white, Color.black, panels[0], true);
		
		l.createLabel(labels[0], createFont("Tahoma", Font.BOLD, 20), Color.black, Bounds. productLabelBounds, false, null);
		l.createLabel(labels[1], createFont("Times New Roman", Font.BOLD, 18), Color.black,  Bounds.CaloriesLabelBounds, false, panels[0]);
		l.createLabel(labels[2], createFont("Times New Roman", Font.BOLD, 16), Color.black, Bounds. VitaminLabelBounds, false, panels[0]);
		l.createLabel(labels[3], createFont("Times New Roman", Font.BOLD, 18), Color.black,  Bounds.FatLabelBounds, false, panels[0]);
		l.createLabel(labels[4], createFont("Times New Roman", Font.BOLD, 16), Color.black, Bounds. ProteinLabelBounds, false, panels[0]);
		l.createLabel(labels[5], createFont("Times New Roman", Font.BOLD, 16), Color.black,  Bounds.SodiumLabelBounds, false, panels[0]);
		l.createLabel(labels[6], createFont("Times New Roman", Font.BOLD, 16), Color.black, Bounds. WaterLabelBounds, false, panels[0]);
		l.createLabel(labels[7], createFont("Times New Roman", Font.BOLD, 16), Color.black,  Bounds.AllergenLabelBounds, false, panels[0]);
		
		productBox.setFocusable(false);
		
		productBox.setBounds( Bounds.productBoxBounds[0], Bounds. productBoxBounds[1],  Bounds.productBoxBounds[2], Bounds. productBoxBounds[3]);
		productBox.addActionListener(_ -> {
			 if(productBox.getSelectedIndex() == 0) {
				 displayInfo("Calories: 332", "Vitamin: B12, B6, Iron", "Protein: 26g", "Water: 60mg", "Sodium: 50g", "Fat: 17g (Satured 7g)", "Allergens: 1", "Meat");
			 }
			 if(productBox.getSelectedIndex() == 1) {
				 displayInfo("Calories: 120", "Vitamin: A, C, K, Folate", "Protein: 3g", "Sodium: 1.5g", "Water: 150g", "Fat: 4g", "Allergens: 1", "Tomato Salad");
			 }
			 if(productBox.getSelectedIndex() == 2) {
				 displayInfo("Calories: 300", "Vitamin: C, A, K, Folate", "Protein: 30mg", "Sodium: 350mg", "Water: 160g", "Fat: 4g", "Allergens: 1", "Chicken Salad");
			 }
			 if(productBox.getSelectedIndex() == 3) {
				 displayInfo("Calories: 250", "Vitamin: A, Calcium", "Protein: 6g", "Sodium: 350mg", "Water: 0.7g", "Fat: 14g", "Allergens: 1", "Ice-Cream");
			 }
			 if(productBox.getSelectedIndex() == 4) {
				 displayInfo("Calories: 500", "Vitamin: C, K", "Protein: 15g", "Sodium: 400mg", "Water: 90g", "Fat: 25g", "Allergens: 2", "Burger");
			 }
		});
		window.getContentPane().add(panels[0]);
		window.getContentPane().add(labels[0]);
		window.getContentPane().add(productBox);

		panels[0].add(labels[1]);
		panels[0].add(labels[2]);
		panels[0].add(labels[5]);
		panels[0].add(labels[4]);
		panels[0].add(labels[6]);
		panels[0].add(labels[7]);
		
		buttons[0].addActionListener(_ -> {
        	rh.writeRecepie("FoodRecepies.txt", "Meats: beef, salt, pepper, garlic. \nBurgers: beef patty, bun, lettuce, tomato. \nIce-Cream: milk, cream, sugar, egg yolks. \nTomato Salad: tomato, olive oil, salt, vinegar, onion. \nChicken Salad: mayonnaise, celery, lettuce. ");
        	rh.writeAllergen("FoodAllergens.txt", "Chicken Salad: Mayonnaise - can be allergic to some people, possible risk. \nlettuce - Pretty rare allergy. \nBurgers: Tomato - can be allergic to some people, low risk but possible. \nlettuce - Pretty rare allergy. \nMeats: Meat - can be allergic to some people, low risk in Many Regons but possible. \npepper - Pretty rare allergy. \nIce-Cream Milk - very high risk for someone with lactose intolerance. \nEgg yolks - Possible but rare allergy. Tomato: can be allergic to some people, low risk but possible. \nTomato Salad: olivie oil - No allergy but risky for people with high-cholesterol or digestive issues. \nChicken Salad: Mayonnaise - can be allergic to some people, possible risk. \nlettuce - Pretty rare allergy.");
            buttons[0].setEnabled(false);
		});
		buttons[1].addActionListener(_ -> {
			buttons[0].setEnabled(true); 
			displayInfo("Calories:", "Possible Vitamins:", "Protein:", "Sodium", "Water Content:", "Fat:", "Allergens:", "Product:");
			window.dispose();
		});
		
  	  try {
		  UIManager.setLookAndFeel(new FlatDarkLaf());
	  } catch (UnsupportedLookAndFeelException e) {
		  System.out.println("Failed to load Look and Feel: " + e.getMessage());
	  }
	}
	private Font createFont(String fontName, int type, int size) {
		return new Font(fontName, type, size);
	}
	private class WindowH extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
		     Toolkit.getDefaultToolkit().beep();
		     buttons[1].setBackground(Color.red);
		     resetTimer.start();
		}
	}
	private void displayInfo(String caloriesInf, String vitaminInf, String proteinInf, String sodiumInf, String waterInf, String FatInf, String allergenInf, String prodctInf) {
        labels[0].setText(prodctInf);
        labels[1].setText(caloriesInf);
        labels[2].setText(vitaminInf);
        labels[3].setText(proteinInf);
        labels[4].setText(sodiumInf);
        labels[5].setText(FatInf);
        labels[6].setText(waterInf);
        labels[7].setText(allergenInf);
 	}
}