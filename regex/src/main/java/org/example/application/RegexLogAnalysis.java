package org.example.application;

import java.util.regex.*;

public class RegexLogAnalysis {
    public static void main(String[] args) {
        String log = "ERROR: 2024-08-23 12:34:56 - Something went wrong";
        String pattern = "ERROR: (\\d{4}-\\d{2}-\\d{2}) (\\d{2}:\\d{2}:\\d{2})";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(log);

        if (matcher.find()) {
            System.out.println("Date: " + matcher.group(1));
            System.out.println("Time: " + matcher.group(2));
        }
    }
}
