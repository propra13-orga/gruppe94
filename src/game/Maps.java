package game;



public class Maps {
	
	private int i=1;
	
	
	public void setMap(int map){
		i = map;
	}
	
	private int pos11[] = {0, 50, 100, 0, 50, 100, 150, 150, 200, 200, 250, 250, 300, 300, 350, 350, 400, 400, 450, 450, 0, 0, 0, 0, 0, 0, 0};
	private int pos12[] =  {0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 
			200, 200, 200, 200, 300, 350, 350, 250, 300, 350, 
			0, 50, 100,
			150, 150, 150, 
			50, 70, 90, 110, 130, 150,
			480, 480 , 480, 480, 480 , 480, 480, 480 , 480,
			0, 50, 100, 150, 200, 250, 300, 350, 400,
			-20, -20, -20, -20, -20, -20,
			280, 310, 280, 310, 290};
	private int pos13[] = {0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 
			480, 480 , 480, 480, 480 , 480, 480, 480,
			0, 50, 100, 150, 200, 250, 300, 350, 400, 450,
			-20, -20, -20, -20, -20, -20,
		    50, 50, 50, 100, 100, 150, 200, 250, 300, 350, 400,
		    400 , 400, 400, 400 , 400,
		    200, 250, 300, 350, 400,
		    190, 190, 190, 160, 160, 160,
		  	90, 120, 90, 90, 90, 90,
		  	250, 300};
	
	private int pos21[] = {0, 50, 100, 400, 350, 300, 150, 250, 150, 250, 150, 250, 150, 250, 150, 250, 150, 250, 150, 250, 50, 100, 150 ,200, 250, 300, 350};
	private int pos22[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			50, 80, 110, 140, 90, 90, 130, 160 , 160, 160,
			350, 350, 350,
			300, 320, 340,
			260, 260, 260, 260, 260, 260
			, 50, 100, 150, 200, 250, 300, 350, 400, 450,
			440, 440, 440, 440, 440, 440, 440, 440, 440,
			 50, 100, 150, 250, 300, 400,
			 260, 260, 280, 280, 310};
	private int pos23[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			50, 100, 150, 200, 250, 300, 350, 400,
			440, 440, 440, 440, 440, 440, 440, 440, 440, 440,
			 50, 100, 150, 250, 300, 400,
			70, 120, 150, 70, 70, 70, 70, 70, 70, 70, 70,
			110, 160, 210, 260, 310,
			360, 360, 360, 360, 360,
			140, 180, 220, 260, 300, 330,
			150, 190, 250, 300, 350, 400,
			140, 140};

	private int posE1[] = {70, 250, 135, 185};		// Gegner Koordinaten
	private int posE2[] = {70, 70, 70};
	private int posE3[] = {100, 320, 235};
	
	private int posE11[] = {200, 300, 130, 390};
	private int posE22[] = {170, 220, 270};
	private int posE33[] = {115, 140, 300};
	
	public int[] getPosE1() {
		if (i == 1) {
			return posE1;
		}
		
		if (i == 2) {
			return posE2;
		}
		
		if (i == 3) {
			return posE3;
		}
		else {
			return posE1; //noch �ndern zu einer Fehlermeldung
		}
	}
	
	public int[] getPosE2() {
		if (i == 1) {
			i = i + 1;
			return posE11;
		}
		
		if (i == 2) {
			i = i + 1;
			return posE22;
		}
		
		if (i == 3) {
			i = i + 1;
			return posE33;
		}
		else {
			return posE11; //noch �ndern zu einer Fehlermeldung
		}
	}
	
	public int[] getPos1() {
		
		if (i == 1) {
			return pos11;
		}
		
		if (i == 2) {
			return pos12;
		}
		
		if (i == 3) {
			return pos13;
		}
		else {
			return pos11; //noch �ndern zu einer Fehlermeldung
		}
	}
	
	public int[] getPos2() {

		if (i == 1) {
			i = i + 1;
			return pos21;
		}
		
		if (i == 2) {
			i = i + 1;
			return pos22;
		}
		
		if (i == 3) {
			i = i + 1;
			return pos23;
		}
		else {
			return pos21; //noch �ndern zu einer Fehlermeldung
		}
	}
}
