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
package org.xgmtk.lore.builtin;

import org.xgmtk.lore.utils.Randomizer;

/**
 * TODO write JavaDoc comment.
 * 
 * Kind of dice.
 * 
 * @author kando
 *
 */
public enum Die {
	D100(100, 0),
	D30(30, 1),
	D20(20, 2),
	D12(12, 3),
	D10(10, 4),
	D8(8, 5),
	D6(6, 6),
	D4(4, 7),
	D3(3, 8),
	D2(2, 9)
	;
	
	public final static int KINDS = Die.values().length;
	public static final Randomizer RAND = new Randomizer();

	
	/**
	 * TODO write JavaDoc comment.
	 */
	public final int kind;
	/**
	 * TODO write JavaDoc comment.
	 */
	public final int nth;

	private final double mean;
	private final double variance;
	
	private Die(int kind, int nth){
		this.kind = kind;
		this.nth = nth;
		this.mean = (kind + 1)/2.0;
		double vsum = 0.0;
		for(int i = 1; i <= kind; ++i){
			double diff = i - this.mean;
			vsum += diff * diff;
		}
		this.variance = vsum /kind;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param kind
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Die get(int kind) throws IllegalArgumentException{
		for(Die d : Die.values()){
			if(d.kind == kind){
				return d;
			}
		}
		throw new IllegalArgumentException("D"+kind+" dice is not defined.");
	}

	public int min() {
		return 1;
	}
	
	public int max() {
		return this.kind;
	}
	
	public double mean() {
		return this.mean;
	}

	public double variance() {
		return this.variance;
	}

	public int roll() {
		double rd = RAND.get() * this.kind;
		return (int)Math.ceil(rd);
	}
}
