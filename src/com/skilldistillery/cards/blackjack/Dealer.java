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
		if(deck.cardsLeftInDeck() < 8) {
			System.out.println("Only " + deck.cardsLeftInDeck() + " cards left in deck. \nNot enough cards for another game. \nExiting the game. \nThanks for playing! Good-bye!");
			return true;
		}
		return false;
	}
	
	public int cardsLeftInDeck() {
		return deck.cardsLeftInDeck();
	}
}
