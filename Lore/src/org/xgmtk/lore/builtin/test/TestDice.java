/*
 * [Apache License 2.0]
 * Copyright 2014 T.Kando and Inuyama-ya sanpu.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xgmtk.lore.builtin.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.xgmtk.lore.builtin.Dice;
import org.xgmtk.lore.builtin.Die;

public class TestDice {
	
	public static final Dice[] allDice;
	private static final int TRIALS = 10000;
	
	static{
		Dice[] dice = new Dice[Die.KINDS];
		for(Die d : Die.values()){
			dice[d.nth] = new Dice(1, d);
		}
		allDice = dice;
	}

	@Test
	public void testArithmetics(){
		Dice dice = Dice.ZERO;
		for(Dice d : allDice){
			dice = dice.add(d);
		}
		
		Dice dicec = new Dice(dice);
		assertThat(dicec, is(dice));
		assertThat(dicec.hashCode(), is(dice.hashCode()));
		assertThat(dicec, not(sameInstance(dice)));

		Dice dice2a = dice.add(dice);
		Dice dice2m = dice.mul(2);
		assertThat(dice2a, is(dice2m));
		assertThat(dice2a.hashCode(), is(dice2m.hashCode()));
		assertThat(dice2a, not(sameInstance(dice2m)));
		
		Dice dice2d6m7 = (new Dice(2, Die.D6)).sub(7);
		Dice diced6md6 = (new Dice(1, Die.D6)).sub(new Dice(1, Die.D6));
		assertThat(dice2d6m7.max(), is(diced6md6.max()));
		assertThat(dice2d6m7.min(), is(diced6md6.min()));
		assertThat(diced6md6, is(dice2d6m7));
		Dice dicend6md6 = diced6md6.mul(-1);
		assertThat(dicend6md6, is(diced6md6));
				
		Dice dicexn2 = dice.mul(-2);
//		dicexn2.dump(System.err, "dicexn2");
		Dice dice2nmd = dicexn2.add(dice);
		Dice dice1m2d = dice.sub(dice.mul(2));
//		dice2nmd.dump(System.err, "dice2nmd");
//		dice1m2d.dump(System.err, "dice1m2d");
		assertThat(dice2nmd.max(), is(dice1m2d.max()));
		assertThat(dice2nmd.min(), is(dice1m2d.min()));
		assertThat(dice2nmd, is(dice1m2d));
		assertThat(dice2nmd.hashCode(), is(dice1m2d.hashCode()));
		assertThat(dice2nmd, not(sameInstance(dice1m2d)));
	}
	
	@Test
	public void testStat(){
		Dice dice_3 = new Dice(3);
		
		assertThat(dice_3.min(), is(3));
		assertThat(dice_3.max(), is(3));
		assertThat(dice_3.mean(), is(3.0));
		assertThat(dice_3.variance(), is(0.0));
		assertThat(dice_3.isNumber(), is(true));
		assertThat(dice_3.getConstant(), is(3));
		
		Dice diced6 = new Dice(1, Die.D6);
		
		assertThat(diced6.min(), is(1));
		assertThat(diced6.max(), is(6));
		assertThat(diced6.mean(), is(3.5));
		double vsum = 0.0;
		for(int i = 1; i <= 6; ++i){
			double diff = i - 3.5;
			vsum += diff * diff;
		}
		double var = vsum /6;
		assertThat(diced6.variance(), is(var));
		assertThat(diced6.isNumber(), is(false));
		assertThat(diced6.getConstant(), is(0));

		Dice dice2d6p6 = new Dice(2, Die.D6).add(6);
		
		assertThat(dice2d6p6.min(), is(8));
		assertThat(dice2d6p6.max(), is(18));
		assertThat(dice2d6p6.mean(), is(13.0));
		assertThat((((25*1+16*2+9*3+4*4+1*5)*2)/36.0), is(var*2));
		assertThat(dice2d6p6.variance(), is(var*2));
		assertThat(dice2d6p6.isNumber(), is(false));
		assertThat(dice2d6p6.getConstant(), is(6));

		Dice dice2d6m6 = (new Dice(2, Die.D6)).sub(7);
		assertThat(dice2d6m6.min(), is(-5));
		assertThat(dice2d6m6.max(), is(5));
		assertThat(dice2d6m6.mean(), is(0.0));
		assertThat(dice2d6m6.variance(), is(var*2));
		assertThat(dice2d6p6.isNumber(), is(false));
		assertThat(dice2d6p6.getConstant(), is(6));
	}
	
	public static class Roller{
		private Dice dice;
		private int[] results;
		private double mean;
		
		public Roller(Dice dice, int trials){
			this.dice = dice;
			this.results = new int[trials];
			for(int i = 0; i < this.results.length; ++i){
				this.results[i] = dice.roll();
			}
			this.mean = 0.0;
		}
		
		public void assertMinMax(){
			for(int r : this.results){
				assertThat(r <= dice.max(), is(true));
				assertThat(dice.min() <= r, is(true));
			}
		}
		
		public void assertMean(double allowableError){
			double sum = 0.0;
			for(int r : this.results){
				sum += r;
			}
			this.mean = sum / this.results.length;
//			System.err.println("Actual mean: "+this.mean +", Expected mean: "+ dice.mean());
			assertThat(Math.abs(this.mean - dice.mean()) < allowableError, is(true));
		}
		
		public void assertVariance(double allowableError){
			double sum = 0.0;
			for(int r : this.results){
				double diff = this.mean - r;
				sum += diff * diff;
			}
			double variance = sum / this.results.length;
//			System.err.println("Actual variance: "+variance +", Expected variance: "+ dice.variance());
			assertThat(Math.abs(variance - dice.variance()) < allowableError, is(true));
		}
	}
	
	@Test
	public void testRoll(){
		Dice dice_3 = new Dice(3);
		Roller r = new Roller(dice_3, TRIALS);
		r.assertMinMax();
		r.assertMean(1.0E-9);
		r.assertVariance(1.0E-9);
		
		Dice diced6 = new Dice(1, Die.D6);
		r = new Roller(diced6, TRIALS);
		r.assertMinMax();
		r.assertMean(0.1);
		r.assertVariance(0.1);
		
		Dice dice2d6p6 = new Dice(2, Die.D6).add(6);
		r = new Roller(dice2d6p6, TRIALS);
		r.assertMinMax();
		r.assertMean(0.1);
		r.assertVariance(0.1);
	}
}
