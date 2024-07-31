package com.addmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMethod {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            String delimiterPart = numbers.substring(2, delimiterEndIndex);
            
            if (delimiterPart.startsWith("[")) {
                StringBuilder delimitersPattern = new StringBuilder();
                Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
                while (matcher.find()) {
                    delimitersPattern.append(Pattern.quote(matcher.group(1))).append("|");
                }
                delimitersPattern.setLength(delimitersPattern.length() - 1); // Remove trailing |
                delimiter = delimitersPattern.toString();
            } else {
                delimiter = Pattern.quote(delimiterPart);
            }
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] numArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String num : numArray) {
            if (!num.trim().isEmpty()) {
                int number = Integer.parseInt(num.trim());
                if (number < 0) {
                    negativeNumbers.add(number);
                } else {
                    sum += number;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
