package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	// no other fields in this class
	private Dealer dealer;
	private Player player;
	private Scanner sc;

	private BlackjackApp() {
		dealer = new Dealer();
		player = new Player();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();

		app.startGame();
	}

	private void startGame() {

		// Dealer gives 2 visible cards to player, 1 visible card and 1 non visible card
		// player turn first (hit or stay), when "stay", dealer turn goes

		System.out.println("Let's play Blackjack! Enter 1 when you're ready to start. ");
		int userReady = sc.nextInt();

		player();
		System.out.println();
		dealer();
		hitOrStay();

	}

	public void player() {
		dealer.shuffleDeck();
		System.out.println("Player's hand: ");
		player.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		player.showHand();
		System.out.println("Player hand total: " + player.handValue());

	}

	public void dealer() {
		dealer.shuffleDeck();
		System.out.println("Dealer's hand: ");
		dealer.dealCard();
		Card card2 = dealer.dealCard();
		dealer.showHand();
		dealer.handValue();
		System.out.println("Dealer hand: Card faced down. " + card2);

	}

	public void hitOrStay() {
		boolean keepgoing = true;
		while (keepgoing) {
			System.out.println();
			System.out.println("Player, enter 1 to hit or 2 to stay: ");
			int hitOrStay = sc.nextInt();

			if(hitOrStay !=1 || hitOrStay !=2) {
				System.out.println("uh oh! Invalid entry, please enter 1 or 2. ");
			}
			if (hitOrStay == 1) {
				dealer.shuffleDeck();
				player.hit(dealer.dealCard());
				player.showHand();
				System.out.println(player.handValue());
				if(player.isBlackjack()) {
				}
				if(player.isBust()) {
					keepgoing = false;
				}

			}
			if (hitOrStay == 2) {
				System.out.println();
				System.out.println("You want to stay. Now it's the Dealer's turn. ");
				keepgoing = false;
			}
			
		}
	}

}
