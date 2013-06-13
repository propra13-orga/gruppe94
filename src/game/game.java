package game;



import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import menu.menu;

public class game extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Char cha;
	private ArrayList<Tree> trees;

	private ArrayList<Enemy> enemies;

	private Enemy enemy1;
	private goal goal;

	private Image image, imagescaled;
	private boolean ingame;
	private boolean win;
	private int G_WIDTH, G_HEIGHT;
	private int[] pos1; 	//sp�ter �ndern f�r verschiedene Maps
	private int[] pos2;
	private int[] posE1;
	private int[] posE2;
	private int mapNumber = 1;
	private Maps map;   			//zum holen von pos1 und pos2 f�r die B�ume der verschiedenen Maps
	
	public game() {
		
		addKeyListener(new KAdapter());
		setFocusable(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
		ingame = true;
		win = false;
		
		ImageIcon ii =                       //l�dt ein Grass image und skaliert es groesser damit es das Sichtfeld abdeckt
				new ImageIcon(this.getClass().getResource("images/grass.jpg"));
		image = ii.getImage();
		imagescaled = image.getScaledInstance(530, 530, UNDEFINED_CONDITION);
		
		
		setSize(500, 500);
		
		cha = new Char();
		
		map = new Maps();
		pos1 = map.getPos1();
		pos2 = map.getPos2();
		posE1 = map.getPosE1();
		posE2 = map.getPosE2();
		
		initTrees();
		initEnemies();
		
		enemy1 = new Enemy (400, 400);	// erstelle Enemy Objekt mit Koordinaten
		goal = new goal (300, 275);     // erstellt Ziel mit Koordinaten
		
		timer = new Timer(5, this);
		timer.start();
		repaint();
	}
	
	public void addNotify() {  //holt h�he und breite des Fensters um Game Over naricht mittig zu platzieren
		super.addNotify();
		G_WIDTH = getWidth();
		G_HEIGHT = getHeight();
	}
	
	public void initTrees() {
		trees = new ArrayList<Tree>();
		
		for (int i=0; i < pos1.length ; i++) {
			trees.add(new Tree(pos1[i], pos2[i]));
		}
	}
	
	public void initEnemies() {
		enemies = new ArrayList<Enemy>();
		
		for (int i=0; i < posE1.length ; i++) {
			enemies.add(new Enemy(posE1[i], posE2[i]));
		}
	}
	
	//ruft setMap aus Maps.java mit neuer mapnummer auf, aktualisiert position der baeume und setzt cha auf Anfangsposition
	public void changeMap(int i, int x, int y) {
		map.setMap(i);
		pos1 = map.getPos1();
		pos2 = map.getPos2();
		posE1 = map.getPosE1();
		posE2 = map.getPosE2();
		
		cha.setX(x);
		cha.setY(y);
		
		initTrees();
		initEnemies();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if (ingame) { //zeichne Character, B�ume usw.  wenn ingame = true ist
			
			Graphics2D g2d = (Graphics2D)g;
			
			g2d.drawImage(imagescaled, 0, 0, this);   // l�dt das Hintergrundbild
			
			if (cha.isVisible())
				g2d.drawImage(cha.getImage(), cha.getX(), cha.getY(), this);
			
			for (int i = 0; i <trees.size(); i++) {
				Tree t = (Tree) trees.get(i);
				g2d.drawImage(t.getImage(), t.getX(), t.getY(), this);
			
			}
			for (int k = 0; k<enemies.size(); k++) {		// zeichne Gegner
				Enemy e = (Enemy) enemies.get(k);
				g2d.drawImage(e.getImage(), e.getX(), e.getY(), this);
			}

			if (mapNumber == 3) g2d.drawImage(goal.getImage(), goal.getX(), goal.getY(),this);              //  zeichne Ziel auf karte 3
			
			g2d.setColor(Color.BLACK);
			g2d.drawString("Targets left: 1", 5, 15);
			}
		
		else {
			if (win) { //Naricht bei Sieg
				String msg = "YOU WIN";
				Font small = new Font ("Gewonnen", Font.BOLD, 14);
				FontMetrics metr = this.getFontMetrics(small);
				
				g.setColor(Color.black);
				g.setFont(small);
				g.drawString(msg, (G_WIDTH - metr.stringWidth(msg))/2, G_HEIGHT /2);
				
			}
			else { // Naricht bei Niederlage (wenn ingame falsch ist, aber kein Sieg = false ist)
				String msg = "Game Over";
				Font small = new Font ("Ende", Font.BOLD, 14);
				FontMetrics metr = this.getFontMetrics(small);
			
				g.setColor(Color.black);
				g.setFont(small);
				g.drawString(msg, (G_WIDTH - metr.stringWidth(msg))/2, G_HEIGHT / 2);

			}
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose(); //wie final verhindert �nderung des JFrames
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**if (cha.isVisible() == false) {
			ingame = false; //f�r ber�hrung mit Gegner
		}*/
		
		if(cha.getX()>490 && mapNumber==1){ //Mapwechsel von 1 zu 2
			changeMap(2, 40, 220); //ruft changeMap mit neuer Map-Nummer und x y (startposition 100,225) fuer char auf
			mapNumber++; //erhoeht die Map-Nummer fuer die if-abfrage
		}
		else if(cha.getY()>470 && mapNumber==2){
			changeMap(3, 40, 220);
			mapNumber++;
		}
		else if(cha.getX()<10 && mapNumber==2){ //Ausgaenge 2 zu 1 und 3 zu 2
			changeMap(1, 480, 225);
			mapNumber--;
		}
		else if(cha.getX()<10 && mapNumber==3){
			changeMap(2, 450, 460);
			mapNumber--;
		}
		
		cha.move();
		checkCollisions();
		repaint();
	}
	
	public void checkCollisions() {
		
		Rectangle rChar = cha.getBounds();
		
		for (int k = 0; k < enemies.size(); k++) {
			Enemy e = (Enemy) enemies.get(k);
			Rectangle rEnemy = e.getBounds();
			
			if (rChar.intersects(rEnemy)) { 		//Game over bei Ber�hrung eines Gegners
				ingame = false;		
			}  
		}
		
		Rectangle rGoal = goal.getBounds();
		Rectangle rEnemy = enemy1.getBounds();
		
		if (mapNumber == 2){
		if (rChar.intersects(rEnemy)){			//Game Over bei Ber�hung mit Gegner
			ingame = false;
		}}
		
		if (mapNumber == 3){
		if (rChar.intersects(rGoal)){
			ingame = false;
			win = true;
		}}
		
		for (int j = 0; j < trees.size(); j++) {
			Tree t = (Tree) trees.get(j);
			Rectangle rTree = t.getBounds();
			
			if (rChar.intersects(rTree)) { //stoppen bei ber�hrung mit einem baum
				
				if (cha.getDX() == 1) {
					cha.addX(-1);
				}
				
				if (cha.getDX() == -1) {
					cha.addX(1);
				}
				
				if (cha.getDY() == 1) {
					cha.addY(-1);
				}
				
				if (cha.getDY() == -1) {
					cha.addY(1);
				}
				
			} 
		}
	}
	
/*	public void initMap(int m) {
		int i = 0;
		int x = 0;
		int y = 0;
		char prototypemap[] = map.getMap(m);
		while(i < 50) {												//max wert noch �ndern
			
			switch(prototypemap[i]) {
			case '#' : {											// # : wall
				break;
			}
			case 's' : {											// s : spawn
				break;
			}
			case 'e' : {											// e : enemy
				break;
			}
			case 'b' : {											// b : boss
				break;
			}
			case 'g' : {											// g : goal
				break;
			}
			case 'i' : {											// i : item
				break;
			}
			case 'n' : {											// n : npc
				break;
			}
			default : {
				break;
			}
			}
			
		x = x + 50;
		if(i % 10 == 0) {
			y = y + 50;
		}
		i++;
		}
	}*/
	
	public class KAdapter extends KeyAdapter { 
		
		public void keyPressed(KeyEvent e) {
			if (ingame == false)
			{
				add(new menu());
			}
			else
			{
			cha.keyPressed(e);
			}
		}
		public void keyReleased(KeyEvent e) {
			cha.keyReleased(e);
		}
		
	}
}
