package game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Zoss {

	private int x, dx, dy, y, damage;
	private boolean visible = true;
	private int life = 1000;
	private Image image;
	
	public Zoss(int x, int y, int dir){
		ImageIcon ei = new ImageIcon(this.getClass().getResource("images/endboss.png"));
		image = ei.getImage();
		image = image.getScaledInstance(75, 75, -1);
		damage = 2;
		this.x = x;
		this.y = y;
		dx = 2;
		dy = 0;
	}
	
	public int getDmg() {
		return damage;
	}
	
	public int getLife (){
		return life;
	}
	
	public void damage (int dmg){
		this.life -= dmg;
	}
	
	public boolean isVisible () {
		return visible;
	}
	
	public void setVisible (boolean visible){
		this.visible = visible;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}


	public Image getImage(){
		return image;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 35, 35);
	}
	
	public Rectangle getBoundsZ() {
		return new Rectangle(x, y, 75, 75);
	}
	
	public void move() {
		x = x+dx;
		y = y+dy;
	
	}
	
	public void movecollide() {
		if (dx>0) {
			x = x-3;
			dx = 0;
			dy = 2;
		}
		else {if(dy > 0){
			y = y-3;
			dx = -2;
			dy = 0;
			}
		else if(dx < 0) {
			x = x+3;
			dx = 0;
			dy = -2;
		}else {
			y = y+3;
			dx = 2;
			dy = 0;
		}
		}
		
	}
}


