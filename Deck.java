package week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    // Constructor to populate the deck with 52 cards
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    // Method to populate the deck with 52 cards
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                String name = getValueName(value) + " of " + suit;
                cards.add(new Card(value, name));
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw the top card from the deck
    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    // get the name of the card if royal
    private String getValueName(int value) {
        switch (value) {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return String.valueOf(value);
        }
    }
}