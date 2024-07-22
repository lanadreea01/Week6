package Week6;

import Week05.Card;

public class App {

	public App() {
		 Deck deck = new Deck();
		 deck.describe();
		
		 deck.shuffle();
		 Card drawnCard = deck.draw();
			drawnCard.describe();
}

public static void main(String[] args) {
   
    String player1Name = getPlayerName("Player 1");
    String player2Name = getPlayerName("Player 2");

    Player player1 = new Player(player1Name);
    Player player2 = new Player(player2Name);

   
    Deck deck = new Deck();
    deck.shuffle();

    Card drawnCard = deck.draw();
	drawnCard.describe();
    dealCards(deck, player1, 5);
    dealCards(deck, player2, 5);

   
    while (Players.getScore() < 50 ) {
        playTurn(player1, deck);
        playTurn(player2, deck);
    }

   
    Player winner = getWinner(player1, player2);
    if (winner != null) {
        System.out.println("Winner: " + winner.getName());
    } else {
        System.out.println("It's a tie!");
    }
}

public static String getPlayerName(String prompt) {
    System.out.print(prompt + " name: ");
    return null; 
}
public static void dealCards(Deck deck, Player player, int numCards) {
    for (int i = 0; i < numCards; i++) {
        player.draw(deck);
    }
}

public static void playTurn(Player player, Deck deck) {
   
    System.out.println(player.getName() + "'s turn!");
  
}
public static Player getWinner(Player player1, Player player2) {
    if (player1.getScore() > player2.getScore()) {
        return player1;
    } else if (player1.getScore() < player2.getScore()) {
        return player2;
    } else {
        return null; 
    }
}
}





