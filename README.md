# BlackjackProject

## Description 
This program is a single person Blackjack game. Once the user (player) starts the game, the dealer deals 2 cards to the player and themself mimicking the blackjack ruling (both of the player's cards are revealed but only one of the dealer's cards is). If either the dealer or player "bust" (card total goes over 21) or "blackjack" (card total is 21), the program will notify them of the winner and reveal the cards then end the game. If neither "bust" or "blackjack", the player is able to "hit" to add a card to their total or "stay", which then starts the dealer's turn. The dealer is programmed to follow the "the rule of 17" and will automatically "hit" if their card total is below 17 and "stay" if their card total is over 17. There are "blackjack" and "bust"
checks after the player and dealer's turn. If neither the player nor dealer had a "blackjack" or "bust" during their turn, their totals are compared to decide who had the card total closest to 21 and who is the winner of the game.

## Technologies Used
* Java
	* Eclipse
	* Sublime
	* Git/GitHub
	* MacOS Terminal 

## Concepts Used
* Java
	* Object Oriented Design : Abstraction, Inheritance, Polymorphism and Encapsulation.
	* UML diagram
	* Enums
	* ArrayLists
	* While/Do While loops
	* For Each loops
	* Booleans
	* If statements
	* Writing methods for game logic

## Lessons Learned
Commit, commit, commit! No manner how little the edit, commit! I continued to edit my program without commiting and I dug myself into a hole to the point that previous logic that was successful, was no longer working and I had to pull the last commit and startover which set me back. I also realized that I need to do a better job of writing out my plans and organizing my code before starting, like writing out the steps in the comments (no detail is too small!) vs trying to keep it all in my head. I also used the "rubber ducky" method of explaining my problems outloud, which helped me problem solve some simple issues. I also keep trying to use a single method to do various logic which makes it much more difficult to do and resulted in coupling. This program was very challenging for me and eventhough I wasn't able to get the end result I was hoping for (looping the program so the player could choose to continue to play and factoring for user error), I was able to get a better understanding of return types (I've usually stuck to using "void" when creating my own methods) and parameters, decoupling methods, DRY and seeing the benefit of more planning and alternative problem solving methods.