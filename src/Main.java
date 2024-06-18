import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию." +
                " Каждый символ вводится через пробел. Допустимые символы (+,-,*,/)"
        );
        Scanner scan = new Scanner(System.in);
        String consoleText = scan.nextLine();
        String[] storage = splitString(consoleText);
        int a;
        int b;
        String sign = storage[1];
        try {
            a = Integer.parseInt(storage[0]);
            b = Integer.parseInt(storage[2]);
            int answer = computation(a, b, sign);
            System.out.println(storage[0] + " " + sign + " " + storage[2] + " = " + answer);
        } catch (NumberFormatException e) {
            a = romanInArabConvert(storage[0]);
            b = romanInArabConvert(storage[2]);
            int answer = computation(a, b, sign);
            String convertAnswer = convertToRoman (answer);
            System.out.println(storage[0] + " " + sign + " " + storage[2] + " = " + convertAnswer);
        }
    }

    public static int computation(int a, int b, String znak) {
        if (a > 10 | a < 1 | b > 10 | b < 1) {
            System.out.println("Числа должны быть в пределе от 1 до 10");
        }
        return switch (znak) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Введены неверные операции");
        };
    }

    public static int romanInArabConvert(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new IllegalArgumentException("Введены неверные операции");
        };
    }

    public static String[] splitString(String array) {
        String[] strings = array.split(" ");
        if (strings.length < 3 | strings.length > 3) {
            throw new IllegalArgumentException("Ввели некорректные данные");
        }
        return strings;
    }

    public static String convertToRoman(int numArabian) {
        String[] roman = {
                "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}
