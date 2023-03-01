package pack;

public class Vigener {
    public static String encryption(String text, String codeWord) {
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        codeWord = codeWord.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] codeChar = codeWord.toCharArray();
        final char[] Ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '}; // Создаем массивы алфавита

        int index;
        int codeIndex = 0;
        int step;

        for (int i = 0; i < textChar.length; i++) {
            step = 0;
            index = 0;
            while (codeChar[codeIndex] != Ch[step]) step++;  // Высчитываем шаг смещения по кодовому слову

            while (textChar[i] != Ch[index]) index++;   // Ищем индекс символа
            index += step;
            if (index > 27) { // Корректируем при выходе за границы
                index -= 28;
            }
            textChar[i] = Ch[index];   // Меняем символ
            codeIndex++; // Смещаем индекс для кодового слова
            if (codeIndex == codeWord.length()) {
                codeIndex = 0;
            }
        }

        for (char c : textChar) { // Формирование итоговой строки
            res.append(c);
        }
        return res.toString(); // Возвращение результата
    }

    public static String decryption(String text, String codeWord) {
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        codeWord = codeWord.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] codeChar = codeWord.toCharArray();
        final char[] Ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};// Создаем массивы алфавита

        int index;
        int codeIndex = 0;
        int step;

        for (int i = 0; i < textChar.length; i++) {
            step = 0;
            index = 0;
            while (codeChar[codeIndex] != Ch[step]) step++;

            while (textChar[i] != Ch[index]) index++;
            index -= step; // Смещаем индекс в обратную сторону
            if (index < 0) {
                index += 28;
            }
            textChar[i] = Ch[index];
            codeIndex++;
            if (codeIndex == codeWord.length()) {
                codeIndex = 0;
            }
        }

        for (char c : textChar) { // Формирование итоговой строки
            res.append(c);
        }
        return res.toString(); // Возвращение результата
    }
}
