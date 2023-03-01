package pack;

public class Magic {
    public static String encryption(String text) {
        int s = 0;

        StringBuilder res = new StringBuilder();
        String str;
        final int[][] magicSquare = {{1, 14, 11, 8}, {15, 4, 5, 10}, {6, 9, 16, 3}, {12, 7, 2, 13}};
        String[][] Square = new String[4][4];

        for (int y = 0; y < 4; y += 1) {  // Заполняем квадрат для кодировки пропусками
            for (int x = 0; x < 4; x += 1) {
                Square[y][x] = " ";
            }
        }

        int nx = 0;
        int ny = 0;

        while (s < text.length()) {
            for (int i = 0; i < 16; i += 1) {
                if (s < text.length()) {
                    str = text.substring(s, s + 1);    // Выбираем символ
                    for (int y = 0; y < 4; y += 1) {
                        for (int x = 0; x < 4; x += 1) {
                            if (magicSquare[y][x] == i + 1) {  // Ищем соответствующий магическому квадрату индекс
                                nx = x;
                                ny = y;
                            }
                        }
                    }
                    Square[ny][nx] = str;   // Вносим символ в соответствующий индекс
                }
                s += 1;
            }

            for (int y = 0; y < 4; y += 1) {   // Составляем результирующую строку и очищаем квадрат для кодировки
                for (int x = 0; x < 4; x += 1) {
                    res.append(Square[y][x]);
                    Square[y][x] = " ";
                }
            }

        }
        return res.toString();
    }

    public static String decryption(String text) {
        int s = 0;
        String result;
        final int[][] magicSquare = {{1, 14, 11, 8}, {15, 4, 5, 10}, {6, 9, 16, 3}, {12, 7, 2, 13}};
        String[][] Square = new String[4][4];

        for (int y = 0; y < 4; y += 1) {
            for (int x = 0; x < 4; x += 1) {
                Square[y][x] = " ";
            }
        }

        StringBuilder res = new StringBuilder();

        while (s < text.length()) {

            for (int y = 0; y < 4; y += 1) {
                for (int x = 0; x < 4; x += 1) {
                    if (s < text.length()) {
                        Square[y][x] = text.substring(s, s + 1);   // Заполняем квадрат в соответствии с кодировкой
                        s += 1;
                    }
                }
            }

            for (int i = 0; i < 16; i += 1) {
                for (int y = 0; y < 4; y += 1) {
                    for (int x = 0; x < 4; x += 1) {
                        if (magicSquare[y][x] == i + 1) {
                            res.append(Square[y][x]);       // Достаем символы в нужном порядке и добавляем в результат
                        }
                    }
                }
            }

            for (int y = 0; y < 4; y += 1) {           // Заполняем пропусками для повторного использования
                for (int x = 0; x < 4; x += 1) {
                    Square[y][x] = " ";
                }
            }
        }
        result = res.toString();

        return result;
    }
}
