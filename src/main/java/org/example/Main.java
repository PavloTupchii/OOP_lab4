package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Головний клас програми, що містить виконавчий метод.
 * Реалізує перевірку роботи парсера тексту та виконання дій з Лабораторної №3.
 */
public class Main {

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {

        // =====================================================================
        // ЧАСТИНА 1: Демонстрація роботи класів Літера, Слово, Речення, Текст
        // =====================================================================

        // Рядок із зайвими пробілами та табуляціями (\t - це символ табуляції)
        String rawString = "Це\t  текст  для   лабораторної   роботи.   Він містить   зайві    пробіли!";

        // Створюємо об'єкт Text, який автоматично очистить текст та розіб'є його на елементи
        Text parsedText = new Text(rawString);

        System.out.println("--- 1. Демонстрація парсингу тексту ---");
        System.out.println("Оригінал: " + rawString);
        System.out.println("Очищений: " + parsedText.toString());
        System.out.println();

        // =====================================================================
        // ЧАСТИНА 2: Дія з Лабораторної №3 (Сортування та пошук об'єктів)
        // =====================================================================

        // Створюємо масив об'єктів типу Word (нашого створеного класу)
        Word[] wordsArray = {
                new Word("університет"),
                new Word("кіт"),
                new Word("програмування"),
                new Word("сонце"),
                new Word("код")
        };

        System.out.println("--- 2. Дія з Лабораторної №3 (Сортування та пошук) ---");
        System.out.println("Початковий масив слів:");
        System.out.println(Arrays.toString(wordsArray));

        // Сортування №1: За довжиною слова (спадання) - аналог сортування за ціною з Лаб 3
        Arrays.sort(wordsArray, Comparator.comparing(Word::getLength).reversed());
        System.out.println("\nСортування за довжиною (спадання):");
        System.out.println(Arrays.toString(wordsArray));

        // Сортування №2: За довжиною слова (зростання) - аналог сортування за об'ємом з Лаб 3
        Arrays.sort(wordsArray, Comparator.comparing(Word::getLength));
        System.out.println("\nСортування за довжиною (зростання):");
        System.out.println(Arrays.toString(wordsArray));

        // Пошук ідентичного об'єкта за допомогою перевизначеного equals
        Word targetWord = new Word("сонце");
        System.out.println("\nШукаємо об'єкт: " + targetWord.getText());

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(targetWord)) {
                System.out.println("Об'єкт знайдено під індексом: " + i);
            }
        }
    }
}