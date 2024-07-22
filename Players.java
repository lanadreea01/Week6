package Week6;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {
	

	public Players() {
		
	      Map<String, List<Card>> gameBoard = new HashMap<>();
	        int numberOfPlayers = 2;
	        gameBoard = createGame(numberOfPlayers);
	        System.out.println("-------------");
	        for (int i = 1; i <= numberOfPlayers; i ++)  {
	      	String playerName = "Player"  + i;
	        System.out.println(playerName + "\n---------");
	        List<Card> playerList = gameBoard.get(playerName);
	        for ( Card handCard : playerList)   {
	        	handCard.describe();
	        }
	        System.out.println("-------------");
			
	        }
	        
	        	
	        	
	        	}	
	
	
public static Map<String, List<Card>> createGame (int numOfPlayers)   {
	Map<String, List<Card>> finalGameBoard = new HashMap<>();
	Deck deck = new Deck();
	deck.shuffle();
	System.out.println("Deck has" + deck.getCards().size() + " cards!");
	for (int i =1; i <= numOfPlayers; i++)  { 
		List<Card> playerList = new ArrayList<>();
		String playerName = "Player" + i;
		finalGameBoard.put(playerName,  playerList);
				
	}
	for (int i = 0; i < 52/numOfPlayers; i ++)  {
		for ( int j = 1; j <= numOfPlayers; j ++)   {
			String playerName = "Player" + j;
			List<Card> playerList = finalGameBoard.get(playerName);
			playerList.add(deck.draw());
			finalGameBoard.replace(playerName, playerList);
		}
	}
	if (52%numOfPlayers != 0) {
		System.out.println("With" + numOfPlayers + " players --");
		System.out.println("Cards left in deck: " +52%numOfPlayers);
		
	} else {
		System.out.println("All cards have been dealt!");;
	}
	
	return finalGameBoard;
}


public static int getScore() {
	
	return 50;
}
}
class Player {
    private String name;
    private int score;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void draw(Deck deck) {
        hand.add(deck.draw());
    }

    public void incrementScore() {
        score++;
    }
}
