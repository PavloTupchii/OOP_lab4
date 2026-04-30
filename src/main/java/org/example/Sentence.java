package org.example;

/**
 * Клас, що представляє речення. Складається з масиву слів та розділових знаків.
 */
public class Sentence {
    private SentenceElement[] elements;

    /**
     * Конструктор, що приймає готовий масив елементів речення.
     *
     * @param elements масив об'єктів SentenceElement
     */
    public Sentence(SentenceElement[] elements) {
        this.elements = elements;
    }

    /**
     * Метод для отримання тексту всього речення.
     *
     * @return рядок з текстом речення
     */
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            SentenceElement element = elements[i];

            // Додаємо пробіл перед словом, якщо це не перше слово в реченні
            if (i > 0 && element instanceof Word) {
                sb.append(" ");
            }

            sb.append(element.getText());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getText();
    }
}