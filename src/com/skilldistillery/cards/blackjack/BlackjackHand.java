package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand {

	// no fields in this class

	public BlackjackHand() {

	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
//		return getHandValue() > 21 ? true : false;
		if (getHandValue() > 21) {
			return true;
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
