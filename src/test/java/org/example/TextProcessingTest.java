package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас для тестування логіки Лабораторної роботи №4.
 */
class TextProcessingTest {

    @Test
    void testWordEqualsAndLength() {
        Word word1 = new Word("java");
        Word word2 = new Word("java");
        Word word3 = new Word("код");

        // Перевіряємо, чи правильно рахується довжина
        assertEquals(4, word1.getLength(), "Довжина слова 'java' має бути 4");
        assertEquals(3, word3.getLength(), "Довжина слова 'код' має бути 3");

        // Перевіряємо роботу нашого перевизначеного методу equals
        assertEquals(word1, word2, "Слова з однаковими літерами мають бути рівні");
        assertNotEquals(word1, word3, "Різні слова не повинні бути рівними");
    }

    @Test
    void testTextParsingAndCleaning() {
        // Текст із купою зайвих пробілів та табуляцій
        String rawText = "Це   текст  із зайвими\tпробілами.   І ще одне   речення!";
        Text text = new Text(rawText);

        // Перевіряємо, чи парсер зліпив усе з одним пробілом
        String expectedText = "Це текст із зайвими пробілами. І ще одне речення!";
        assertEquals(expectedText, text.toString(), "Текст має бути очищений від зайвих пробілів");

        // Перевіряємо, чи правильно текст розбився на речення
        assertEquals(2, text.getSentences().length, "Текст має складатися з 2 речень");
    }

    @Test
    void testWordSorting() {
        Word[] words = {
                new Word("університет"), // довжина 11
                new Word("кіт"),         // довжина 3
                new Word("сонце")        // довжина 5
        };

        // Сортуємо за зростанням (за довжиною)
        Arrays.sort(words, Comparator.comparing(Word::getLength));

        // Перевіряємо правильність порядку після сортування
        assertEquals("кіт", words[0].getText());
        assertEquals("сонце", words[1].getText());
        assertEquals("університет", words[2].getText());
    }
}