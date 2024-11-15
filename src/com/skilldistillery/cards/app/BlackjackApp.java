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
		
	}
}
