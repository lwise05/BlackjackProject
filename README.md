# BlackjackProject

## Description 
This program simulates a one player Blackjack game. Once the user (player) starts the game, the dealer deals out the cards, 2 cards "face up" and visible to the player and 2 cards for the dealer, only one "face up" and visible to the player. The player is then prompted if they want to "hit" to add a card to their hand or "stay", which then starts the dealer's turn. The dealer is programmed to follow the "the rule of 17" and will automatically "hit" if their card total is below 17 and "stay" if their card total is 17 or higher. At any time if either the dealer or player "bust" (card total goes over 21) or "blackjack" (card total is 21), the program will automatically reveal the winner and their hand. If neither the player nor dealer had a "blackjack" or "bust" during their turn, their totals are compared at the end to decide who had the card total closest to 21 and who is the winner of the game. The player is prompted at the end of the game to answer if they want to play again or leave the game. The program tracks the card amount in the deck and adds a new deck if the card amount is getting low.

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

UPDATED: I added a containing loop to allow the player a choice to continue playing the game, logic to monitor the card amount in the deck and add a new deck to ensure player can continue playing, as well as cleaning up some of my previous logic (I previously could fall into an infinite loop). I felt like I did a better job this time, writing out my plans and commiting more regularly, as well as a better undestanding of how to complete the edits I wanted to make. It felt like this go around I understood how to apply methods with booleans in my Blackjack app class and the inheritance from parent classes.