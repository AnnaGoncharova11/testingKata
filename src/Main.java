import java.util.Scanner;

public abstract class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию." +
                " Каждый символ вводится через пробел. Допустимые символы (+,-,*,/)");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        calc(input);
    }

    public static String calc(String input) {
        String[] storage = Computation.splitString(input);
        int a;
        int b;
        String sign = storage[1];
        try {
            a = Integer.parseInt(storage[0]);
            b = Integer.parseInt(storage[2]);
            int answer = Computation.computation(a, b, sign);
            System.out.println(answer);
            return String.valueOf(answer);
        } catch (NumberFormatException e) {
            a = RomanNumber.romanInArabConvert(storage[0]);
            b = RomanNumber.romanInArabConvert(storage[2]);
            int answer = Computation.computation(a, b, sign);
            String convertAnswer = RomanNumber.convertToRoman(answer);
            System.out.println(convertAnswer);
            return convertAnswer;
        }
    }
}
