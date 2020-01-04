package com.mindera.school.music.ui;

public class StringCode {
    public static String capitalizeEachWord(String str) {
        if (str == null || str.length() == 0)
            return "";

        if (str.length() == 1)
            return str.toUpperCase();

        String[] words = str.split(" ");

        StringBuilder sbCapitalizedWords = new StringBuilder(str.length());

        for (String word : words) {

            if (word.length() > 1)
                sbCapitalizedWords
                        .append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase());
            else
                sbCapitalizedWords.append(word.toUpperCase());

            sbCapitalizedWords.append(" ");
        }

        return sbCapitalizedWords.toString().trim();
    }

    public static String capitalizeFirstWordOfSentences(String str) {
        if (str == null || str.length() == 0)
            return "";

        if (str.length() == 1)
            return str.toUpperCase();

        str = str.trim();

        String[] words = str.split(" ");

        StringBuilder sbCapitalizedWords = new StringBuilder(str.length());


        words[0] = sbCapitalizedWords
                .append(words[0].substring(0, 1).toUpperCase())
                .append(words[0].substring(1).toLowerCase()).toString();

        sbCapitalizedWords.append(" ");


        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > 1 && words[i].substring(words[i].length() - 1).equals(".")) {
                sbCapitalizedWords
                        .append(words[i].toLowerCase());

                sbCapitalizedWords.append(" ");

                words[i + 1] = sbCapitalizedWords
                        .append(words[i + 1].substring(0, 1).toUpperCase())
                        .append(words[i + 1].substring(1).toLowerCase()).toString();
                i++;
            } else {
                sbCapitalizedWords
                        .append(words[i].toLowerCase());
            }

            sbCapitalizedWords.append(" ");
        }

        return sbCapitalizedWords.toString().trim();
    }
}
