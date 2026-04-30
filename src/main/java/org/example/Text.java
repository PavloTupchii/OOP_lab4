package org.example;

/**
 * Клас, що представляє текст. Складається з масиву речень.
 */
public class Text {
    private Sentence[] sentences;

    /**
     * Конструктор, який очищає текст від зайвих пробілів та розбиває його на речення.
     *
     * @param rawText вхідний рядок тексту
     */
    public Text(String rawText) {
        // 1. Заміна послідовності табуляцій та пробілів одним пробілом (вимога завдання)
        String cleanedText = rawText.replaceAll("[\\s\\t]+", " ").trim();

        // 2. Розбиваємо текст на речення (по крапці, знаку оклику чи питання)
        // Регулярний вираз (?<=[.!?]) залишає сам розділовий знак у складі речення
        String[] sentenceStrings = cleanedText.split("(?<=[.!?])\\s*");

        sentences = new Sentence[sentenceStrings.length];

        // 3. Парсимо кожне речення окремо
        for (int i = 0; i < sentenceStrings.length; i++) {
            sentences[i] = parseSentence(sentenceStrings[i]);
        }
    }

    /**
     * Допоміжний метод для розбиття рядка-речення на слова та розділові знаки.
     */
    private Sentence parseSentence(String sentenceString) {
        // Розбиваємо речення так, щоб розділові знаки відокремлювалися від слів
        String[] tokens = sentenceString.split("(?=[.,!?])|\\s+");

        // Рахуємо фактичну кількість елементів (щоб відкинути можливі порожні рядки)
        int elementCount = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) elementCount++;
        }

        SentenceElement[] elements = new SentenceElement[elementCount];
        int index = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            // Якщо токен складається лише з розділового знаку
            if (token.matches("[,.!?]")) {
                elements[index++] = new Punctuation(token);
            } else {
                // Інакше це слово
                elements[index++] = new Word(token);
            }
        }

        return new Sentence(elements);
    }

    /**
     * Повертає масив речень, з яких складається текст.
     *
     * @return масив об'єктів Sentence
     */
    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.getText()).append(" ");
        }
        return sb.toString().trim();
    }
}