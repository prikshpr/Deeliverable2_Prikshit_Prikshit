/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author 20pri
 */
public class StartGame {
    public static void main(String[] args) {
        WarGame game = new WarGame("War");

        ConcretePlayer player1 = new ConcretePlayer("Alice");
        ConcretePlayer player2 = new ConcretePlayer("Bob");

        game.addPlayer(player1);
        game.addPlayer(player2);

        GroupOfCards deck = new GroupOfCards();
        deck.shuffle();

        // Distribute cards evenly
        boolean toggle = true;
        while (!deck.isEmpty()) {
            if (toggle) {
                player1.addCard(deck.drawCard());
            } else {
                player2.addCard(deck.drawCard());
            }
            toggle = !toggle;
        }

        game.play();
    }
}