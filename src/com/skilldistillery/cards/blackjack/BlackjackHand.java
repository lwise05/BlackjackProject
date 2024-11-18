package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand {

	// no fields in this class

	public BlackjackHand() {

	}

	public boolean isBlackjack() {

		if (getHandValue() == 21) {
			System.out.println("Black Jack! Card total is 21! ");
		}
		return false;

	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println("Bust! Card total went over 21. You Lose. ");
		}
		return false;
	}

	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	@Override
	public int getHandValue() {
		int handvalue = 0;
		for (Card card : cardsInHand) {
			handvalue += card.getValue();
		}
		return handvalue;
	}

}
