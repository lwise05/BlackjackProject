package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), 
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");
	
	Suit (String suitType) {
	name = suitType;		
	}
	
	private final String name;
	
	@Override
	public String toString() {
		return name;
	}
}
