package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;

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
		System.out.println("Let's play Blackjack! Enter 1 when you're ready to start. ");
		int userReady = sc.nextInt();

//		dealer();
//		System.out.println();
//		player();
//		hitOrStay();
//		
//		dealerAfterPlayer();
//		compareHandValues();
//		
		boolean winner = true;
		do {
			// 1. shuffle cards
			dealer.shuffleDeck();
			// 2.dealer deals cards to self
			dealerGetsCards();
			// 3. dealer deals cards to player
			System.out.println();
			playerGetsCards();
			// 4. method to check if dealer has bj or bust
			
			if (dealerIsBlackjackOrBust ()) {
				winner = false;
			}
//			if (dealer.isBlackjack()) {
//				System.out.println();
//				System.out.println("Blackjack! Dealer wins.");
//				System.out.println("Dealer's hand: ");
//				dealer.showHand();
//				System.out.println("Dealer's total: " + dealer.handValue());
//				winner = false;
//			}
//			if (dealer.isBust()) {
//				System.out.println();
//				System.out.println("Bust! Player wins");
//				System.out.println("Dealer's hand: ");
//				dealer.showHand();
//				System.out.println("Dealer's total: " + dealer.handValue());
//				System.out.println("Player's total: " + player.handValue());
//				winner = false;
//			}

			// 5.method to check if player has bj or bust
			if (playerIsBlackjackOrBust ()) {
				winner = false;
			}
			
//			if (player.isBlackjack()) {
//				System.out.println();
//				System.out.println("Blackjack! Player wins.");
//				player.showHand();
//				winner = false;
//			}
//			if (player.isBust()) {
//				System.out.println();
//				System.out.println("Bust! Dealer wins");
//				player.showHand();
//				System.out.println("Player's total: " + player.handValue());
//				System.out.println("Dealer's hand: ");
//				dealer.showHand();
//				System.out.println("Dealer's total: " + dealer.handValue());
//				winner = false;
//			}
			
			// 6. player hit or stay
			if (player.handValue() < 20) {
				hitOrStay();
			}

			// 7. method to check if player has bj or bust
			if (playerIsBlackjackOrBust ()) {
				winner =false;
			}
//			if (player.isBlackjack()) {
//				System.out.println();
//				System.out.println("Blackjack! Player wins.");
//				player.showHand();
//				winner = false;
//			}
//			if (player.isBust()) {
//				System.out.println();
//				System.out.println("Bust! Dealer wins");
//				System.out.println("Player's total: " + player.handValue());
//				System.out.println("Dealer's hand: ");
//				dealer.showHand();
//				System.out.println("Dealer's total: " + dealer.handValue());
//				winner = false;
//			}
			// 8. dealer hits or stays
			
			while (player.handValue() < 21 && dealer.handValue() < 17) {
				System.out.println();
				System.out.println("Dealer's hand: ");
				dealer.showHand();
				System.out.println("Dealer's total: " + dealer.handValue());
				System.out.println("Dealer hits.");
				dealer.hit(dealer.dealCard());
				dealer.showHand();
				System.out.println("Dealer's total: " + dealer.handValue());
			}
			if (dealer.handValue() > 17 && dealer.handValue() < 21) {
				System.out.println("Dealer stays. ");
				System.out.println();
				System.out.println("Dealer's hand: ");
				dealer.showHand();
				System.out.println("Dealer's total: " + dealer.handValue());
				
			}
			// 9. method to check if dealer has bj or bust
			
			if (dealerIsBlackjackOrBust ()) {
				winner = false;
			}
//			if (dealer.isBlackjack()) {
//				System.out.println();
//				System.out.println("Blackjack! Dealer wins.");
//				player.showHand();
//				winner = false;
//			}
//			if (dealer.isBust()) {
//				System.out.println();
//				System.out.println("Bust! Player wins");
//				System.out.println("Dealer's total: " + dealer.handValue());
//				System.out.println();
//				System.out.println("Player's hand:");
//				player.showHand();
//				System.out.println("Player's total: " + player.handValue());
//				winner = false;
//			}
			// 10. compare cards
			compareHandValues();
			winner = false;
		} while (winner);

	}

	public void playerGetsCards() {
		System.out.println("Player's hand: ");
		player.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		player.showHand();
		System.out.println("Player hand total: " + player.handValue());
	}

	public void dealerGetsCards() {
		System.out.println("Dealer's hand: ");
		System.out.println("Card faced down. ");
		dealer.hit(dealer.dealCard());
		dealer.showHand();
		dealer.hit(dealer.dealCard());

	}

	public void dealerAfterPlayer() {
		boolean keepgoing = true;
		System.out.println();
		dealer.showHand();
		System.out.println(dealer.handValue());
		while (keepgoing) {
			if (dealer.is17()) {
			}
			if (dealer.isBlackjack()) {
				System.out.println("Blackjack! Dealer wins.");
				player.showHand();
				keepgoing = false;
			}
			if (dealer.isBust()) {
				System.out.println("Bust! Player wins");
				System.out.println("Dealer's total: " + dealer.handValue());
				System.out.println("Player's total: " + player.handValue());
				keepgoing = false;
			}
			keepgoing = false;

		}
	}

	public void hitOrStay() {
		boolean keepgoing = true;
		while (keepgoing) {
			if (player.handValue() > 21) {
				keepgoing = false;
				break;
			}
			System.out.println();
			System.out.println("Player, enter 1 to hit or 2 to stay: ");
			int hitOrStay = sc.nextInt();

			if (hitOrStay == 1) {
				player.hit(dealer.dealCard());
				player.showHand();
				System.out.println("Player hand total: " + player.handValue());
			}
			if (hitOrStay == 2) {
				System.out.println("You want to stay. Now it's the dealer's turn. ");
				keepgoing = false;
			}
		}

	}

	public void compareHandValues() {

		if (dealer.handValue() > player.handValue() && dealer.handValue() < 21) {
			System.out.println();
			System.out.println("Dealer wins!");
			System.out.println();
			System.out.println("Dealer's hand: ");
			dealer.showHand();
			System.out.println("Dealer's hand total: " + dealer.handValue());
		}
		if (dealer.handValue() < player.handValue() && player.handValue() < 21) {
			System.out.println();
			System.out.println("Player wins!");
			System.out.println();
			System.out.println("Player's hand: ");
			player.showHand();
			System.out.println("Player's hand total: " + player.handValue());
		} else if (dealer.handValue() == player.handValue()) {
			System.out.println();
			System.out.println("Tie! Player and Dealer have same hand value. ");
			System.out.println();
			System.out.println("Dealer's hand: ");
			dealer.showHand();
			System.out.println("Dealer's hand total: " + dealer.handValue());
			System.out.println();
			System.out.println("Player's hand: ");
			player.showHand();
			System.out.println("Player's hand total: " + player.handValue());

		}
	}
	public boolean dealerIsBlackjackOrBust () {
		if (dealer.isBlackjack()) {
			System.out.println();
			System.out.println("Blackjack! Dealer wins.");
			System.out.println("Dealer's hand: ");
			dealer.showHand();
			System.out.println("Dealer's total: " + dealer.handValue());
			return true;
		}
		if (dealer.isBust()) {
			System.out.println();
			System.out.println("Bust! Player wins");
			System.out.println("Dealer's hand: ");
			dealer.showHand();
			System.out.println("Dealer's total: " + dealer.handValue());
			System.out.println("Player's total: " + player.handValue());
			return true;
		}
		else {
			return false;
	}
		
	}
	
	public boolean playerIsBlackjackOrBust () {
		if (player.isBlackjack()) {
			System.out.println();
			System.out.println("Blackjack! Player wins.");
			System.out.println("Player's hand: ");
			player.showHand();
			System.out.println("Player's total: " + player.handValue());
			return true;
		}
		if (player.isBust()) {
			System.out.println();
			System.out.println("Bust! Dealer wins");
			System.out.println("Player's hand: ");
			player.showHand();
			System.out.println("Player's total: " + player.handValue());
			System.out.println();
			System.out.println("Dealer's hand: ");
			dealer.showHand();
			System.out.println("Dealer's total: " + dealer.handValue());
			return true;
	}
		else {
			return false;
		}
		
	}
}