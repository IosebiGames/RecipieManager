package sound;

import javax.sound.sampled.*;
import java.net.*;

public class Sound {
	
	private URL sound = getClass().getResource("/sound/click_sound.wav");
	private Clip clip;
	
	public Sound() {
          try {
           clip = AudioSystem.getClip();
       	   clip.open(AudioSystem.getAudioInputStream(sound));
          }catch(Exception e) {
        	 IO.println("Failed to prepare the sound: " + e.getMessage());
        }
	}
	public void playSound() {
	     clip.start();
	}
}