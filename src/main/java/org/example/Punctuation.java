package org.example;

/**
 * Клас, що представляє розділовий знак у реченні.
 */
public class Punctuation implements SentenceElement {
    private String symbol;

    /**
     * Конструктор для ініціалізації розділового знаку.
     *
     * @param symbol рядок, що містить розділовий знак
     */
    public Punctuation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getText() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}