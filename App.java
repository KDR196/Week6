package week06;

public class App {                         // This is so I can run Thread.sleep(1000); and watch the game print out
    public static void main(String[] args) throws InterruptedException {
        // Instantiate a Deck and two Players
        Deck deck = new Deck();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Shuffle the deck
        deck.shuffle();

        // Draw cards for both players
        for (int i = 0; i < 52; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        // Flip cards and compare values
        for (int i = 0; i < 26; i++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();

            // Describe flipped cards
            System.out.println("Turn " + (i + 1) + ":");
            System.out.println(player1.getName() + " flipped:");
            Thread.sleep(500);
            card1.describe();
            System.out.println(player2.getName() + " flipped:");
            Thread.sleep(500);
            card2.describe();

            // Compare values and update scores
            if (card1 != null && card2 != null) {
                int value1 = card1.getValue();
                int value2 = card2.getValue();

                if (value1 > value2) {
                    player1.incrementScore();
                    System.out.println("Player 1 wins this turn!");
                    Thread.sleep(500);
                } else if (value2 > value1) {
                    player2.incrementScore();
                    System.out.println("Player 2 wins this turn!");
                    Thread.sleep(500);
                } else {
                    System.out.println("It's a tie!");
                    Thread.sleep(500);
                }
            }

            // Print updated scores
            System.out.println("Updated scores:");
            Thread.sleep(500);
            System.out.println(player1.getName() + ": " + player1.getScore());
            Thread.sleep(500);
            System.out.println(player2.getName() + ": " + player2.getScore());
            Thread.sleep(500);
        }

        // Print final scores
        System.out.println("\nFinal scores:");
        Thread.sleep(500);
        System.out.println(player1.getName() + ": " + player1.getScore());
        Thread.sleep(500);
        System.out.println(player2.getName() + ": " + player2.getScore());
        Thread.sleep(500);

        // Determine winner or draw
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Player 1 wins!");
            Thread.sleep(500);
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println("Player 2 wins!");
            Thread.sleep(500);
        } else {
            System.out.println("It's a draw!");
            Thread.sleep(500);
        }
    }
}