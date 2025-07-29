/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author 20pri
 */
public class WarGame extends Game {
    private int rounds = 0;
    private final int maxRounds = 100;

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        while (players.get(0) instanceof ConcretePlayer && players.get(1) instanceof ConcretePlayer &&
               ((ConcretePlayer) players.get(0)).getHandSize() > 0 &&
               ((ConcretePlayer) players.get(1)).getHandSize() > 0 &&
               rounds < maxRounds) {

            rounds++;
            System.out.println("\nRound " + rounds);

            Card card1 = ((ConcretePlayer) players.get(0)).playCard();
            Card card2 = ((ConcretePlayer) players.get(1)).playCard();

            System.out.println(players.get(0).getName() + " plays " + card1);
            System.out.println(players.get(1).getName() + " plays " + card2);

            int value1 = ((PlayingCard) card1).getValue();
            int value2 = ((PlayingCard) card2).getValue();

            if (value1 > value2) {
                System.out.println(players.get(0).getName() + " wins the round!");
                ((ConcretePlayer) players.get(0)).addCard(card1);
                ((ConcretePlayer) players.get(0)).addCard(card2);
            } else if (value1 < value2) {
                System.out.println(players.get(1).getName() + " wins the round!");
                ((ConcretePlayer) players.get(1)).addCard(card1);
                ((ConcretePlayer) players.get(1)).addCard(card2);
            } else {
                System.out.println("It's a tie! Both cards lost.");
                // No one gets cards
            }
        }

        System.out.println("\nGame Over! Winner: " + declareWinner());
    }

    @Override
    public String declareWinner() {
        int hand1 = ((ConcretePlayer) players.get(0)).getHandSize();
        int hand2 = ((ConcretePlayer) players.get(1)).getHandSize();
        if (hand1 > hand2) {
            return players.get(0).getName();
        } else if (hand2 > hand1) {
            return players.get(1).getName();
        } else {
            return "It's a tie!";
        }
    }
}