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

	public void rule17(Card card) {
		if (hand.getHandValue() < 17) {
			hand.addCard(card);
		} else {
			System.out.println("I'll stay. ");

		}
	}

	public void newGame() {
		hand.clear();
	}

	public void shuffleDeck() {
		deck.shuffle();
	}

	@Override
	public void showHand() {
		hand.showHand();

	}
	public int handValue() {
		return hand.getHandValue();
	}

}
