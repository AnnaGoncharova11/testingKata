class Computation {
    public static int computation(int a, int b, String sing) {
        if (a > 10 | a < 1 | b > 10 | b < 1) {
            throw new IllegalArgumentException("Числа должны быть в пределе от 1 до 10");

        }
        return switch (sing) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
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
}
