package org.example;

/**
 * Клас, що представляє окрему літеру тексту.
 */
public class Letter {
    private char character;

    /**
     * Конструктор для ініціалізації літери.
     *
     * @param character символ, який представляє літеру
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Метод для отримання символу літери.
     *
     * @return символ літери
     */
    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
