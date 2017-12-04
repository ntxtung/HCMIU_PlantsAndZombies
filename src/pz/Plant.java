package pz;

import java.util.ArrayList;
import com.Position;
import gui.PZGUI;

public abstract class Plant extends Character {

	//private Animation ani = new Animation();	
	private int framePassed = 0;
	private float scaleFactor = 0.2f;
	//===========================
	
	public int  getFramePassed() 				 {return framePassed;}
	public void setFramePassed(int framePassed)  {this.framePassed = framePassed;}

	/**
	 * Plant contructor
	 * @param name	Name of instance (optional)
	 * @param hp	Health power
	 * @param damage	Damage
	 * @param attackInterval	attack interval
	 * @param pos	Position
	 */
	public Plant(String name, Integer hp, int damage, int attackInterval, Position pos) {
		super(name, hp, damage, attackInterval, pos);
		loadAnimation(); 
		setFramePassed(0);
	}
	
	@Override
	public float getWidth() {
		return getAnimation().getWidth() * scaleFactor * PZGUI.resolutionRateWidth ;}	
	@Override
	public float getHeight() {
		return getAnimation().getHeight() * scaleFactor * PZGUI.resolutionRateHeight ;
	}
	
	public void draw() {
		getAnimation().draw(getPos().x, getPos().y, getWidth(), getHeight());
	}

	public abstract void attack(ArrayList<Bullet> bulletArrayList);
}
