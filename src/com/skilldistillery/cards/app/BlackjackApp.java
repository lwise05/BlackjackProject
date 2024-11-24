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
			dealerIsBlackjackOrBust();
			
			// 5.method to check if player has bj or bust
			playerIsBlackjackOrBust();
				
			// 6. player hit or stay
			if (dealer.handValue() <21 && player.handValue()< 21) {
				hitOrStay();
			}
			// 7. method to check if player has bj or bust
			playerIsBlackjackOrBust();
			// 8. dealer hits or stays
			
			if (player.handValue() <= 20) {
				rule17();
			}
			
			// 9. method to check if dealer has bj or bust
			dealerIsBlackjackOrBust();
			// 10. compare cards
			compareHandValues();
//			winner = false;
			
			// 11. continue playing
			if(continuePlaying()) {
				winner = true;
			}
			else {
				winner = false;
			}
		
				
		} while (winner);

	}
	
	

	public void dealerGetsCards() {
		System.out.println("Dealer's hand: ");
		System.out.println("Card faced down. ");
		dealer.hit(dealer.dealCard());
		dealer.showHand();
		dealer.hit(dealer.dealCard());
	}

	public void playerGetsCards() {
		System.out.println("Player's hand: ");
		player.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		player.showHand();
		System.out.println("Player hand total: " + player.handValue());
	}

	public boolean dealerIsBlackjackOrBust() {
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
			System.out.println();
			System.out.println("Player's hand: ");
			player.showHand();
			System.out.println("Player's total: " + player.handValue());
			return true;
		} else {
			return false;
		}

	}

	public boolean playerIsBlackjackOrBust() {
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
			System.out.println();
			System.out.println("Dealer's hand: ");
			dealer.showHand();
			System.out.println("Dealer's total: " + dealer.handValue());
			return true;
		} else {
			return false;
		}

	}

	public void hitOrStay() {
		boolean keepgoing = true;
		while (keepgoing) {
			if (player.handValue() >= 21) {
				keepgoing = false;
				break;
			}
			System.out.println();
			System.out.println("Player, enter 1 to hit or 2 to stay: ");
			int hitOrStay = sc.nextInt();

			if (hitOrStay == 1) {
				player.hit(dealer.dealCard());
				System.out.println("Player's hand: ");
				player.showHand();
				System.out.println("Player hand total: " + player.handValue());
			}
			if (player.handValue() > 21) {
				keepgoing = false;
				break;
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

	public void rule17() {
		boolean keepgoing = true;
		System.out.println();
		System.out.println("Dealer's hand: ");
		dealer.showHand();
		System.out.println("Dealer's total: " + dealer.handValue());
		while (keepgoing) {
			if (dealer.handValue() < 17) {

				System.out.println();
				System.out.println("Dealer hits.");
				dealer.hit(dealer.dealCard());
				dealer.showHand();
				System.out.println("Dealer's total: " + dealer.handValue());
			}
			if (dealer.handValue() >= 17 && dealer.handValue() < 21) {
				System.out.println();
				System.out.println("Dealer stays. ");
				keepgoing = false;
				break;
			}

			else if (dealer.handValue() >= 21) {
				keepgoing = false;
				break;
			}

		}
	}
	
	public boolean continuePlaying() {
		System.out.println();
		System.out.println("Would you like to play again? Enter 1 to play again or 2 to quit the game.");
		int userReady = sc.nextInt();			
		if (userReady == 1) {
			System.out.println();
			System.out.println("Dealer is shuffling and dealing new cards!");
			System.out.println();
			dealer.newGame();
			player.newGame();
			return true;
		}
		if (userReady == 2) {
			System.out.println();
			System.out.println("You are leaving the game! Bye-Bye!");
			return false;
		}
		return false;
		}

}