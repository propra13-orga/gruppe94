package game;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sounds {
	   
	        // Note: use .wav files
		/**
		 * Spiele Musik ab
		 * @param muse
		 */
	    	public static synchronized void play (int muse) {
	    	switch(muse) {
	    		case 1 : {
	    				try {
	    					Clip clip = AudioSystem.getClip();
	    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\trap.wav"));
	    					clip.open(inputStream);
	    					clip.start(); 
	    				} catch (Exception e) {
	    					System.out.println("play sound error: " + e.getMessage() + " for " + "trap.wav");
	    				}
	    				break;
	    		}
	    		case 2: {
	    				try {
	    					final Clip clip = AudioSystem.getClip();
	    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\Trololo.wav"));
	    					clip.open(inputStream);
	    					clip.start();
	    					
	    				} catch (Exception e) {
	    					System.out.println("play sound error: " + e.getMessage() + " for " + "Trololo.wav");
	    				}
	    				break;
	    		}
	    		case 3: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\obtain.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "obtain.wav");
    				}
    				break;
	    		}	   
	    		case 4: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\shot.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "shot.wav");
    				}
    				break;
	    		}	 	    	
	    		case 5: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\swing.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "swing.wav");
    				}
    				break;
	    		}	 	   	    		
	    		case 6: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\scream.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "scream.wav");
    				}
    				break;
	    		}		   
	    		case 7: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\levelup.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "levelup.wav");
    				}
    				break;
	    		}
	    		case 8: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\drinking.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "drinking.wav");
    				}
    				break;
	    		}
	    		case 9: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\sball.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "sball.wav");
    				}
    				break;
	    		}
	    		case 10: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\shuriken.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "shuriken.wav");
    				}
    				break;
	    		}
	    		case 11: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\dogsound.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "dogsound.wav");
    				}
    				break;
	    		}
	    		case 12: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\gscream.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "gscream.wav");
    				}
    				break;
	    		}
	    		case 13: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\bossscream.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "bossscream.wav");
    				}
    				break;
	    		}
	    		case 14: {
    				try {
    					final Clip clip = AudioSystem.getClip();
    					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src\\game\\sounds\\rittersound.wav"));
    					clip.open(inputStream);
    					clip.start();
    					
    				} catch (Exception e) {
    					System.out.println("play sound error: " + e.getMessage() + " for " + "rittersound.wav");
    				}
    				break;
	    		}
    			}
	    	
	    	
	        new Thread(new Runnable() { 
	            public void run() {
	            
	            }
	        }).start();
	    }
	}


