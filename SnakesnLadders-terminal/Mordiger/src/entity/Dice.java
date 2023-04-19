package entity;

import java.util.Random;

import interfaces.DiceInterface;

public class Dice implements DiceInterface {
	
	private Integer num;
	
	public Dice() {
		num = 1;
	}

	@Override
	public Integer getDiceNumber() {
		return this.num;
	}

	@Override
	public Integer rollDice() {
		return new Random().nextInt(6) + 1;
	}
	
}
