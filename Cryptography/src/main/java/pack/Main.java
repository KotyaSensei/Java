package pack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String code = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите действие");
        System.out.println("1 - Шифрование");
        System.out.println("2 - Дешифрование");
        int action = Integer.parseInt(sc.nextLine());

        System.out.println("Выберите метод");
        System.out.println("1 - Алгоритм Цезаря");
        System.out.println("2 - Метод Хилла");
        System.out.println("3 - Магический квадрат");
        System.out.println("4 - Шифр Виженера");
        int alg = Integer.parseInt(sc.nextLine());

        System.out.println("Введите строку");
        String str = sc.nextLine();
        if (alg == 4) {
            System.out.println("Введите кодовое слово");
            code = sc.nextLine();
        }

        if (action == 1) {
            switch (alg) {
                case (1) -> System.out.println(Caesar.encryption(str));
                case (2) -> System.out.println(Hill.encryption(str));
                case (3) -> System.out.println(Magic.encryption(str));
                case (4) -> System.out.println(Vigener.encryption(str, code));
            }
        }

        if (action == 2) {
            switch (alg) {
                case (1) -> System.out.println(Caesar.decryption(str));
                case (2) -> System.out.println(Hill.decryption(str));
                case (3) -> System.out.println(Magic.decryption(str));
                case (4) -> System.out.println(Vigener.decryption(str, code));
            }
        }
    }
}

