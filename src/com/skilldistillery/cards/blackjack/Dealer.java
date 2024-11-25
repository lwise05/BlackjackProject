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

	public boolean isBlackjack() {
		return hand.isBlackjack();
	}

	public boolean isBust() {
		return hand.isBust();
	}
	
	public boolean checkDeck() {
		if(deck.cardsLeftInDeck() <= 10) {
			newDeck();
			System.out.println(deck.cardsLeftInDeck());
			return true;
		}
		return false;
	}
	
	public int cardsLeftInDeck() {
		return deck.cardsLeftInDeck();
	}
	
	public void newDeck() {
		deck = new Deck();
		}
}
