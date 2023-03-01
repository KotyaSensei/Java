package pack;

public class Caesar {
    public static String encryption(String text) {
        StringBuilder res = new StringBuilder();
        int step = 13;
        text = text.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] lCh = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '}; // Создаем массивы алфавита

        for (int i = 0; i < textChar.length; i++) {
            int index = 0;
            if (Character.isLetter(textChar[i])) { // Проверяем, является ли символ буквой
                while (textChar[i] != lCh[index]) index++;
                index += step;
                if (index > 26) {
                    index -= 27;
                }
                textChar[i] = lCh[index];
            }
        }
        for (char c : textChar) { // Формирование итоговой строки
            res.append(c);
        }
        return res.toString(); // Возвращение результата
    }

    public static String decryption(String text) {
        int step = 13;
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] lCh = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

        for (int i = 0; i < textChar.length; i++) {
            int index = 0;
            if (Character.isLetter(textChar[i])) { // Проверяем, является ли символ буквой
                while (textChar[i] != lCh[index]) index++;
                index -= step;
                if (index < 0) {
                    index += 27;
                }
                textChar[i] = lCh[index];
            }
        }
        for (char c : textChar) { // Формирование итоговой строки
            res.append(c);
        }
        return res.toString(); // Возвращение результата
    }

}
