package com.aymanmz.game.elements;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    //Variables
    private Stack<Integer> stackOfCards = new Stack<>();

    //Constructor
    public Deck() {
        for (int i = 1; i <= 7; i++) {
            stackOfCards.push(i);
        }
    }

    //Getters
    public Stack<Integer> getStackOfCards() {
        return stackOfCards;
    }
    //Methods
    /**
     * Shuffles the contents of the stack around.
     */
    public void shuffleCards() {
        Collections.shuffle(stackOfCards);
    }
}
