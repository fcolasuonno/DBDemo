package com.bitmastro.debenhams.demo.utils;

public class CurrencyFormatter {


    private static final char DECIMAL_SEPARATOR = '.';

    private static StringBuilder sb = new StringBuilder(10);

    public static String format(String input) {
        int index = input.lastIndexOf(DECIMAL_SEPARATOR);
        int length = input.length();
        if (index == -1) {
            sb.setLength(0);
            sb.append(input);
            sb.append(DECIMAL_SEPARATOR);
            sb.append("00");
            return sb.toString();
        } else if (length - index == 2) {
            sb.setLength(0);
            sb.append(input);
            sb.append('0');
            return sb.toString();
        }
        return input;
    }
}
