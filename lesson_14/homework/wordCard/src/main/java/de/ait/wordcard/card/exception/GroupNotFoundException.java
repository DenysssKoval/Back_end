package de.ait.wordcard.card.exception;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String message) {
        super(message);
    }
}
