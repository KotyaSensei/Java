package pack;

public class Hill {
    public static String encryption(String text) {
        StringBuilder res = new StringBuilder();
        int code = 0;
        text = text.toLowerCase();
        text = text.replaceAll("\\s+", "");

        if (text.length() % 3 == 1) {  // Сохраняем кратность
            text = text + "jj"; // "j" реже всех других букв встречается в конце слов
        } else if (text.length() % 3 == 2) {
            text = text + "j";
        }

        char[] textChar = text.toCharArray();
        final char[] Ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] codeList = new int[textChar.length];
        int matriceLength = textChar.length / 3;


        int[][] codeMatrice = new int[3][matriceLength];

        int[][] encryptionMatrice = {{6, 24, 1}, {13, 16, 10}, {20, 17, 15}};
        for (int i = 0; i < textChar.length; i++) {
            switch (textChar[i]) {
                case ('a') -> code = 0;
                case ('b') -> code = 1;
                case ('c') -> code = 2;
                case ('d') -> code = 3;
                case ('e') -> code = 4;
                case ('f') -> code = 5;
                case ('g') -> code = 6;
                case ('h') -> code = 7;
                case ('i') -> code = 8;
                case ('j') -> code = 9;
                case ('k') -> code = 10;
                case ('l') -> code = 11;
                case ('m') -> code = 12;
                case ('n') -> code = 13;
                case ('o') -> code = 14;
                case ('p') -> code = 15;
                case ('q') -> code = 16;
                case ('r') -> code = 17;
                case ('s') -> code = 18;
                case ('t') -> code = 19;
                case ('u') -> code = 20;
                case ('v') -> code = 21;
                case ('w') -> code = 22;
                case ('x') -> code = 23;
                case ('y') -> code = 24;
                case ('z') -> code = 25;
            }
            codeList[i] = code;
        }
        int j = 0;
        int i = 0;
        for (int x : codeList) {
            codeMatrice[i][j] = x;
            i += 1;
            if (i == 3) {
                i = 0;
                j += 1;
            }
        }
        int[][] encryptionCodeMatrice = new int[3][matriceLength];

        for (int l = 0; l < matriceLength; l++) {
            encryptionCodeMatrice[0][l] = (encryptionMatrice[0][0] * codeMatrice[0][l] +
                    encryptionMatrice[0][1] * codeMatrice[1][l] + encryptionMatrice[0][2] * codeMatrice[2][l]) % 26;
            encryptionCodeMatrice[1][l] = (encryptionMatrice[1][0] * codeMatrice[0][l] +
                    encryptionMatrice[1][1] * codeMatrice[1][l] + encryptionMatrice[1][2] * codeMatrice[2][l]) % 26;
            encryptionCodeMatrice[2][l] = (encryptionMatrice[2][0] * codeMatrice[0][l] +
                    encryptionMatrice[2][1] * codeMatrice[1][l] + encryptionMatrice[2][2] * codeMatrice[2][l]) % 26;
        }

        for (j = 0; j < matriceLength; j++) {
            for (i = 0; i < 3; i++) {
                res.append(Ch[encryptionCodeMatrice[i][j]]);
            }
        }

        return res.toString();
    }

    public static String decryption(String text) {
        StringBuilder res = new StringBuilder();
        int code = 0;
        text = text.toLowerCase();
        text = text.replaceAll("\\s+", "");
        char[] textChar = text.toCharArray();
        final char[] Ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] codeList = new int[textChar.length];
        int matriceLength = textChar.length / 3;

        if (textChar.length % 3 != 0) {
            matriceLength += 1;
        }

        int[][] codeMatrice = new int[3][matriceLength];
        int[][] decryptionMatrice = {{8, 5, 10}, {21, 8, 21}, {21, 12, 8}};
        for (int i = 0; i < textChar.length; i++) {
            switch (textChar[i]) {
                case ('a') -> code = 0;
                case ('b') -> code = 1;
                case ('c') -> code = 2;
                case ('d') -> code = 3;
                case ('e') -> code = 4;
                case ('f') -> code = 5;
                case ('g') -> code = 6;
                case ('h') -> code = 7;
                case ('i') -> code = 8;
                case ('j') -> code = 9;
                case ('k') -> code = 10;
                case ('l') -> code = 11;
                case ('m') -> code = 12;
                case ('n') -> code = 13;
                case ('o') -> code = 14;
                case ('p') -> code = 15;
                case ('q') -> code = 16;
                case ('r') -> code = 17;
                case ('s') -> code = 18;
                case ('t') -> code = 19;
                case ('u') -> code = 20;
                case ('v') -> code = 21;
                case ('w') -> code = 22;
                case ('x') -> code = 23;
                case ('y') -> code = 24;
                case ('z') -> code = 25;
            }
            codeList[i] = code;
        }
        int j = 0;
        int i = 0;
        for (int x : codeList) {
            codeMatrice[i][j] = x;
            i += 1;
            if (i == 3) {
                i = 0;
                j += 1;
            }
        }

        int[][] decryptionCodeMatrice = new int[3][matriceLength];
        for (int l = 0; l < matriceLength; l++) {
            decryptionCodeMatrice[0][l] = (decryptionMatrice[0][0] * codeMatrice[0][l] +
                    decryptionMatrice[0][1] * codeMatrice[1][l] + decryptionMatrice[0][2] * codeMatrice[2][l]) % 26;
            decryptionCodeMatrice[1][l] = (decryptionMatrice[1][0] * codeMatrice[0][l] +
                    decryptionMatrice[1][1] * codeMatrice[1][l] + decryptionMatrice[1][2] * codeMatrice[2][l]) % 26;
            decryptionCodeMatrice[2][l] = (decryptionMatrice[2][0] * codeMatrice[0][l] +
                    decryptionMatrice[2][1] * codeMatrice[1][l] + decryptionMatrice[2][2] * codeMatrice[2][l]) % 26;
        }

        for (j = 0; j < matriceLength; j++) {
            for (i = 0; i < 3; i++) {
                res.append(Ch[decryptionCodeMatrice[i][j]]);
            }
        }

        while (res.toString().endsWith("j")) {
            res = new StringBuilder(res.substring(0, res.length() - 1)); // Удаляем добавленные для кратности символы
        }

        return res.toString();
    }
}
