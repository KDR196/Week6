package week06;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int score;
    private String name;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    // Method to describe the player and their hand
    public void describe() {
        System.out.println("Player: " + name + ", Score: " + score);
        System.out.println("Hand:");
        for (Card card : hand) {
            card.describe();
        }
    }

    // Method to flip the top card of the hand
    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null; // Return null if hand is empty
    }

    // Method to draw a card from a deck and add it to the hand
    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    // Method to increment the player's score
    public void incrementScore() {
        score++;
    }
    
    // Method to get the player's name
    public String getName() {
        return name;
    }
    
    // Method to get the player's score
    public int getScore() {
        return score;
    }
}