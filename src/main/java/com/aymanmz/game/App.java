package com.aymanmz.game;

import com.aymanmz.game.elements.Deck;

import java.util.Scanner;

public class App {
    private final Scanner userInput = new Scanner(System.in);
    private final Deck deck = new Deck();


    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    private void run() {
        displayGreetings();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = takeIntInput();
            running = chooseFromMainMenu(selection);
        }
    }

    /**
     * Used to display the greeting when the program is displayed for the first time.
     */
    private void displayGreetings() {
        System.out.println("-----------------------------------");
        System.out.println("|  WELCOME TO THE DECK SHUFFLER!  |");
        System.out.println("-----------------------------------");
    }

    /**
     * Displays the menu options for the user.
     */
    private void displayMenu() {
        System.out.println("1. Show the cards inside the deck.");
        System.out.println("2. Shuffle the deck");
        System.out.println("3. Exit");
    }

    /**
     * Displays the cards inside the deck in order.
     */
    private void displayDeck() {
        Boolean isItFirstCard = true;
        for (Integer card : deck.getStackOfCards()) {
            if (!isItFirstCard) {
                System.out.print(", " + card);
            } else {
                System.out.print(card);
                isItFirstCard = false;
            }
        }
        System.out.printf(".%n%n");
    }

    /**
     * Takes an input from the user and turns into an Integer.
     *
     * @return will always be an Integer, regardless if it is positive or negative.
     */
    private Integer takeIntInput() {
        Integer result = null;
        while (result == null) {
            System.out.printf("%nWhat would you like to do? Select an option: ");
            String inputAsString = userInput.nextLine();
            try {
                result = Integer.parseInt(inputAsString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
        return result;
    }

    /**
     * A method that takes a number and checks if it matches one of the main menu option
     *
     * @param selection if the number matches one of the if statements, execute that one.
     * @return a boolean that determines whether to loop through the menu or not.
     */
    private boolean chooseFromMainMenu(int selection) {
        boolean result = true;
        if (selection == 1) {
            System.out.print("Cards inside the deck: ");
            displayDeck();
        } else if (selection == 2) {
            deck.shuffleCards();
            System.out.printf("The cards have been shuffled%n%n");
        } else if (selection == 3) {
            result = false;
        } else {
            System.out.printf("Please select one of the option numbers!%n%n");
        }
        return result;
    }
}
