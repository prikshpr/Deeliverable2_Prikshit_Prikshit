/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author 20pri
 */

import java.util.*;

public class ConcretePlayer extends Player {
    private final Queue<Card> hand;

    public ConcretePlayer(String name) {
        super(name);
        hand = new LinkedList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        return hand.poll();
    }

    public int getHandSize() {
        return hand.size();
    }

    @Override
    public void play() {
        // Not used in War specifically
    }
}