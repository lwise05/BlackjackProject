package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	// inherits hand from player
	// no get deck method

	private Deck deck;

	public Dealer() {
		deck = new Deck();
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public void hit(Card card) {
		hand.addCard(card);
	}

//	public void rule17(Card card) {
//		if (handValue() < 17) {
//			hit(card);
//		} else {
//			System.out.println("I'll stay. ");
//
//		}
//	}
	
	public boolean is17() {
		if (handValue() < 17) {
			hit(dealCard());
		}
		else {
			System.out.println("I'll stay");
		}
	
		return false;
	}

	public void newGame() {
		hand.clear();
	}

	public void shuffleDeck() {
		deck.shuffle();
	}


	public void showHand() {
		hand.showHand();

	}
	public int handValue() {
		return hand.getHandValue();
	}

}
