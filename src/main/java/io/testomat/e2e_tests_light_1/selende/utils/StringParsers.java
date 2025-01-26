package io.testomat.e2e_tests_light_1.selende.utils;

public class StringParsers {

    public static Integer parseIntegerFromString(String targetText) {
        String digitText = targetText.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

    public static Double parseDoubleFromString(String targetText) {
        String doubleText = targetText.replaceAll("[^\\d.]", ""); // Keeps only digits and the decimal point
        return Double.parseDouble(doubleText);
    }

}
