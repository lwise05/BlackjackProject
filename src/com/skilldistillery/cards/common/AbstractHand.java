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

	public List<Card> clear() {
		// create new array??
		cardsInHand = new ArrayList<>();
		return cardsInHand;
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
