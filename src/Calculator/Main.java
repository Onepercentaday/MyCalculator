package Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Input");
        Scanner in = new Scanner(System.in);
        String vvod = in.nextLine().trim();
        System.out.println("Output");
        System.out.println(calc(vvod));
    }

    public static String calc(String input) throws Exception {
        int a, b;
        int result;
        String retResult = "";
        String[] romeDigit = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        String[] arabDigit = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        String[] strArray = input.split(" ");
        int len_srtArray = strArray.length;
        if (len_srtArray != 3) {
            throw new Exception("//т.к. ввод не по шаблону");
        }
        if ((Arrays.asList(arabDigit).containsAll(List.of(strArray[0], strArray[2])))) {
            a = Integer.parseInt(strArray[0]);
            b = Integer.parseInt(strArray[2]);
            if ((1 <= a) && (a <= 10) && (1 <= b) && (b <= 10)) {
                //выводится строка
                switch (strArray[1]) {
                    case "+":
                        result = a + b;
                        retResult = String.valueOf(result);
                        break;
                    case "-":
                        result = a - b;
                        retResult = String.valueOf(result);
                        break;
                    case "*":
                        result = a * b;
                        retResult = String.valueOf(result);
                        break;
                    case "/":
                        result = a / b;
                        retResult = String.valueOf(result);
                        break;
                }

            } else {
                throw new Exception("//т.к. числа должны быть от 1 до 10");
            }
        } else if ((Arrays.asList(romeDigit).containsAll(List.of(strArray[0], strArray[2])))) {
            RomanEnum roman = RomanEnum.valueOf(strArray[0]);
            RomanEnum roman1 = RomanEnum.valueOf(strArray[2]);
            a = roman.toInt();
            b = roman1.toInt();
            if ((1 <= a) && (a <= 10) && (1 <= b) && (b <= 10)) {
                switch (strArray[1]) {
                    case "+":
                        result = a + b;
                        retResult = String.valueOf(RomanEnum.values()[result]);
                        break;
                    case "-":
                        result = a - b;
                        if (result < 1) {
                            throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                        } else {
                            retResult = String.valueOf(RomanEnum.values()[result]);
                        }
                        break;
                    case "*":
                        result = a * b;
                        retResult = String.valueOf(RomanEnum.values()[result]);
                        break;
                    case "/":
                        result = a / b;
                        if (result < 1) {
                            throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                        } else {
                            retResult = String.valueOf(RomanEnum.values()[result]);
                        }
                        break;
                }

            } else {
                throw new Exception("//т.к. числа должны быть от I до X");

            }
        } else {
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }
        return retResult;
    }
}



