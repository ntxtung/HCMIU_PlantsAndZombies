package pz.plant;

import java.util.ArrayList;

import com.Position;

import gui.AnimationLoader;
import pz.Bullet;

public class Peashooter2 extends pz.Plant {
	
	private static int _hp = 100;
	private static int _damage = 20;
	private static int _attackInterval = 100;
	//private static float scaleFactor = 0.2f;
	public Peashooter2(Position pos) {
		super("Peashooter2", _hp, _damage, _attackInterval, pos);
	}
	
	@Override
	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/PeaShooter/Idle", 30));
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		if (getFramePassed() == getAttackInterval()) {
			bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f) , 
														  (getPos().y + getHeight() * 0.15f), 
														  getDamage()));
		}
		else
			if (getFramePassed() == getAttackInterval()+10) {
				bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f) , 
						  									  (getPos().y + getHeight() * 0.15f), 
						  									  getDamage()));
				setFramePassed(0);
			}
		
		setFramePassed(getFramePassed()+1);
	}

	@Override
	public void move() {

	}
}