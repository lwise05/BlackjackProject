package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	//only one field in this class
	// no list of cards in this class
	// no get hand method
	
	protected BlackjackHand hand;
	
	
	public Player () {
	 hand = new BlackjackHand();
	 
	}
	
	public void hit(Card card) {
		hand.addCard(card);
	}
	
	
}
