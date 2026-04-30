package org.example;

/**
 * Клас, що представляє слово. Складається з масиву літер.
 */
public class Word implements SentenceElement {
    private Letter[] letters;

    /**
     * Конструктор, який перетворює рядок на масив об'єктів Letter.
     *
     * @param word рядок, що містить слово
     */
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Повертає довжину слова для майбутнього сортування.
     *
     * @return кількість літер у слові
     */
    public int getLength() {
        return letters.length;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getCharacter());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word wordObj = (Word) obj;
        return this.getText().equalsIgnoreCase(wordObj.getText());
    }

    @Override
    public String toString() {
        return getText();
    }
}