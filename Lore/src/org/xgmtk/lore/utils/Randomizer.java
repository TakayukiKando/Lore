package org.xgmtk.lore.utils;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Randomizer {

	private Random rand;
	private Timer timer;
	
	public Randomizer(){
		this.rand = new Random();
		this.timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				rand.nextDouble();
			}
		}, 100L, 500L);
	}
	
	public synchronized double get() {
		return this.rand.nextDouble();
	}

}
