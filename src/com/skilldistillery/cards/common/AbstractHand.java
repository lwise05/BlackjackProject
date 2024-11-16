package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {

	protected List<Card> cardsInHand;

	public AbstractHand() {
		cardsInHand = new ArrayList<>();
	}

	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	public void clear() {
		// create new array??
		List<Card> newdeck = new ArrayList<>();
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return "AbstractHand [cardsInHand=" + cardsInHand + "]";
	}

	public void showHand() {
		for (Card card : cardsInHand) {
			System.out.println(card);
		}

	}

}
