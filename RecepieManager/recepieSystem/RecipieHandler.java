package recipieSystem;

import javax.swing.*;
import java.io.*;
import main.App;

public class RecipieHandler {

	private App app;
	private int counter = 0, allergenAmount = 0;
	private Timer timer;
	
	public RecipieHandler(App app) {
		this.app = app;
	}
	public void startRecepieSystem() {
		timer = new Timer(1000, _ -> {
		     counter++;
				if(counter == 20) {
					app.labels[4].setText("");
					app.labels[5].setText("");
					app.labels[6].setText("");
					app.labels[7].setText("");
					app.labels[8].setText("");
                    app.labels[10].setText("");
                 	counter = 0;
					allergenAmount = 0;
					app.buttons[0].setEnabled(true);
					app.buttons[1].setEnabled(true);
                    app.buttons[2].setEnabled(true);
                    app.buttons[4].setEnabled(true);
                    app.buttons[3].setEnabled(true);
                    app.buttons[6].setVisible(false);
			  
                    timer.stop();
				}
		});
		timer.start();
		
		app.buttons[0].addActionListener(_ -> {
			timer.start();
			app.labels[4].setText("beef patty, bun, lettuce, tomato");
		    allergenAmount += 1; 
			app.labels[10].setText("" + allergenAmount);
			app.buttons[0].setEnabled(false);
	        app.buttons[6].setVisible(true);
	        app.buttons[6].addActionListener(_ -> {
	        	app.mt.openMoreTab();
	        });
		});
		app.buttons[1].addActionListener(_ -> {
			app.labels[5].setText("beef, salt, pepper, garlic");
			allergenAmount +=1;
			app.labels[10].setText("" + allergenAmount);
			app.buttons[1].setEnabled(false);
		});
		app.buttons[2].addActionListener(_ -> {
			app.labels[6].setText("milk, cream, sugar, egg yolks");
			allergenAmount +=1;
			app.labels[10].setText("" + allergenAmount);
			app.buttons[2].setEnabled(false);
		});
		app.buttons[4].addActionListener(_ -> {
			app.labels[7].setText("tomato, olive oil, salt, vinegar");
			allergenAmount +=1;
			app.labels[10].setText("" + allergenAmount);
			app.buttons[4].setEnabled(false);
		});
		app.buttons[3].addActionListener(_ -> {
			app.labels[8].setText("mayonnaise, celery, lettuce");
			allergenAmount +=1;
			app.labels[10].setText("" + allergenAmount);
			app.buttons[3].setEnabled(false);
		});			
	}
	public void writeAllergen(String fileName, String Allergen) {
		try {
			System.setOut(new PrintStream(fileName));
			System.out.println(Allergen);
		}catch(IOException e) {
			IO.println("Can't write Allergen: " + e.getMessage());
		}
	}
	public void writeRecepie(String fileName, String recepie) {
		try {
			System.setOut(new PrintStream(fileName));
			System.out.println(recepie);
		}catch(IOException e) {
			IO.println("Can't write Recepie: " + e.getMessage());
		}
	}
}
