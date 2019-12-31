package com.mindera.school.music.ui;

public class StringCode {
    public static String capitalizeEachWord(String str){
        if(str == null || str.length() == 0)
            return "";

        if(str.length() == 1)
            return str.toUpperCase();

        String[] words = str.split(" ");

        StringBuilder sbCapitalizedWords = new StringBuilder(str.length());

        for(String word : words){

            if(word.length() > 1)
                sbCapitalizedWords
                        .append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1));
            else
                sbCapitalizedWords.append(word.toUpperCase());

            sbCapitalizedWords.append(" ");
        }

        return sbCapitalizedWords.toString().trim();
    }
}
