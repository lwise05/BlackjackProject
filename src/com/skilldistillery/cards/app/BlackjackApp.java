package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;

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

		dealer();
		System.out.println();
		player();
//		hitStay();
		hitOrStay();
		dealerAfterPlayer();

	}

	public void player() {
		boolean keepgoing = true;
		dealer.shuffleDeck();
		System.out.println("Player's hand: ");
		player.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		player.showHand();
		System.out.println("Player hand total: " + player.handValue());
		while (keepgoing) {
			if (dealer.isBlackjack()) {
				System.out.println("Game over!");
				keepgoing = false;
			}
			if (dealer.isBust()) {
				System.out.println("Game over!");
				keepgoing = false;
			}
			keepgoing = false;

		}
	}

	public void dealer() {
		boolean keepgoing = true;
		dealer.shuffleDeck();
		System.out.println("Dealer's hand: ");
		System.out.println("Card faced down. ");
		dealer.hit(dealer.dealCard());
		dealer.showHand();
		dealer.hit(dealer.dealCard());
//		System.out.println("total: " + dealer.handValue());
		while (keepgoing) {
			if (dealer.isBlackjack()) {
				dealer.showHand();
				System.out.println("total: " + dealer.handValue());
				System.out.println("Game over!");
				keepgoing = false;
			}
			if (dealer.isBust()) {
				System.out.println("Game over!");
				dealer.showHand();
				System.out.println("total: " + dealer.handValue());
				keepgoing = false;
			}
			keepgoing = false;
		}
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
				System.out.println("Game over!");
				dealer.showHand();
				System.out.println("total: " + dealer.handValue());
				keepgoing = false;
			}
			if (dealer.isBust()) {
				System.out.println("Game over!");
				dealer.showHand();
				System.out.println("total: " + dealer.handValue());
				keepgoing = false;
			}
			keepgoing = false;

		}
	}

	public void hitOrStay() {
		boolean keepgoing = true;
		while (keepgoing) {
			System.out.println();
			System.out.println("Player, enter 1 to hit or 2 to stay: ");
			int hitOrStay = sc.nextInt();
			
			if(hitOrStay == 1){
				player.hit(dealer.dealCard());
				player.showHand();
				System.out.println("Player hand total: " + player.handValue());
			}
			if (player.isBlackjack()) {
				player.showHand();
				System.out.println("total: " + player.handValue());
				System.out.println("Game over!");
				keepgoing = false;
			}
			if (player.isBust()) {
				player.showHand();
				System.out.println("total: " + player.handValue());
				System.out.println("Game over!");
				keepgoing = false;
			}
			else if (hitOrStay == 2) {
				System.out.println("You want to stay. Now it's the dealer's turn. ");
				keepgoing = false;
			}
			keepgoing = false;
		}

	}

	public void hitStay() {
		System.out.println();
		System.out.println("Player, enter 1 to hit or 2 to stay: ");
		int hitOrStay = sc.nextInt();

		switch (hitOrStay) {
		case 1:
			dealer.shuffleDeck();
			player.hit(dealer.dealCard());
			player.showHand();
			System.out.println(player.handValue());
			if (player.isBlackjack()) {
				System.out.println("Game over!");
				player.showHand();
				System.out.println("total: " + player.handValue());
			System.out.println("Game over!");
			break;
			}
			if (player.isBust()) {
				System.out.println("Game over!");
				player.showHand();
				System.out.println("total: " + player.handValue());
				break;
			}
		case 2:
			System.out.println();
			System.out.println("You want to stay. Now it's the Dealer's turn. ");
			break;
		default:
			System.out.println("Oops! You entered an invalid option. Enter 1 or 2. ");
		}
	}

	

}
