package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player{
	// inherits hand from player
	// no get deck method 
	
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
}
