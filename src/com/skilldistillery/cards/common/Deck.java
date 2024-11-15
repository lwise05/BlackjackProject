package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	// no getCards method!!

	private List<Card> cards = new ArrayList<>(52);

	public Deck() { // by putting the list in the deck constructor, ensures it's inside when a new deck is constructed

		// no point to use for loop since no need for index and just needing to iterate from first-last

		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				cards.add(new Card(suits, ranks));
			}

		}
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

}
