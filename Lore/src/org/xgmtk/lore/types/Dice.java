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
package org.xgmtk.lore.types;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class Dice {
	public static final Dice ZERO = new Dice();

	private int[] terms;
	private int constant;
	
	protected Dice(){
		this.terms = new int[Die.KINDS];
		for(Die d: Die.values()){
			this.terms[d.nth] = 0;
		}
		this.constant = 0;
	}
	
	/**
	 * Constructor for dice which contains only one kind.
	 * @param number
	 * @param kind
	 */
	public Dice(int number, Die kind) {
		this();
		addDice(number, kind);
	}
	
	/**
	 * Constructor for constant number.
	 * @param number
	 */
	public Dice(int number) {
		this();
		this.constant += number;
	}

	private final void addDice(int number, Die kind) {
		if(number == 0){
			return;
		}else if(number > 0){
			this.terms[kind.nth] += number;
		}else{
			int positive = - number;
			this.terms[kind.nth] += positive;
			this.constant -= (1 + kind.max()) * positive;
		}
	}

	/**
	 * Copy constructor.
	 * 
	 * @param dice
	 */
	public Dice(Dice dice){
		this();
		for(Die d: Die.values()){
			this.terms[d.nth] = dice.terms[d.nth];
		}
		this.constant += dice.constant;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Dice)){
			return false;
		}
		Dice d = (Dice)o;
		for(int i = 0; i < this.terms.length; ++i){
			if(this.terms[i] != d.terms[i]){
				return false;
			}
		}
		return this.constant == d.constant;
	}
	
	@Override
	public int hashCode(){
		return Arrays.hashCode(this.terms)+Integer.hashCode(this.constant);
	}
	
	/**
	 * Addition.
	 * 
	 * @param dice
	 * @return
	 */
	public Dice add(Dice dice) {
		Dice r = new Dice(this);
		for(Die d: Die.values()){
			r.addDice(dice.terms[d.nth], d);
		}
		r.constant += dice.constant;
		return r;
	}

	/**
	 * Addition.
	 * 
	 * @param n
	 * @return
	 */
	public Dice add(int n) {
		return this.add(new Dice(n));
	}

	/**
	 * Subtraction.
	 * 
	 * @param dice
	 * @return
	 */
	public Dice sub(Dice dice) {
		Dice r = new Dice(this);
		for(Die d: Die.values()){
			r.addDice(-dice.terms[d.nth], d);
		}
		r.constant -= dice.constant;
		return r;
	}
	
	/**
	 * Subtraction.
	 * 
	 * @param n
	 * @return
	 */
	public Dice sub(int n) {
		return this.sub(new Dice(n));
	}

	/**
	 * Multiplication.
	 * 
	 * @param factor
	 * @return
	 */
	public Dice mul(int factor) {
		Dice r = new Dice();
		int f = Math.abs(factor);
		for(Die d: Die.values()){
			r.terms[d.nth] = this.terms[d.nth] * f;
		}
		r.constant = this.constant * f;
		if(factor < 0){
			r = ZERO.sub(r);
		}
		return r;
	}

	public int min() {
		int r = this.constant;
		for(Die d : Die.values()){
			r += this.terms[d.nth]*d.min();
		}
		return r;
	}

	public int max() {
		int r = this.constant;
		for(Die d : Die.values()){
			r += this.terms[d.nth]*d.max();
		}
		return r;
	}

	public double mean() {
		double r = this.constant;
		for(Die d : Die.values()){
			r += this.terms[d.nth]*d.mean();
		}
		return r;
	}

	public double variance() {
		double r = 0.0;
		for(Die d : Die.values()){
			r += this.terms[d.nth]*d.variance();
		}
		return r;
	}

	public int roll() {
		int r = this.constant;
		for(Die d : Die.values()){
			int factor = this.terms[d.nth];
			for(int i = 0; i < factor; ++i){
				r += d.roll();
			}
		}
		return r;
	}
	
	public void dump(PrintStream ps, String name){
		this.dump(new PrintWriter(new OutputStreamWriter(ps)), name);
	}

	public void dump(PrintWriter pw, String name){
		pw.println(name+" {");
		pw.flush();
		for(Die d : Die.values()){
			pw.println("\t"+d+": "+this.terms[d.nth]);
			pw.flush();
		}
		pw.println(name+"} + ("+this.constant+")");
		pw.flush();
	}

	public boolean isNumber() {
		for(Die d : Die.values()){
			if(this.terms[d.nth] != 0){
				return false;
			}
		}
		return true;
	}
	
	public int getConstant(){
		return this.constant;
	}
}
