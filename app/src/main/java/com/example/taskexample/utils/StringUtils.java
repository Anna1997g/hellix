package com.example.taskexample.utils;

public final class StringUtils {

    public static String replaceCustomFromHtml(String value) {
        return value.replaceAll("\\&ldquo;|\\&rdquo;|&rsquo;", "\"")
                .replaceAll("\\<br />", "\n")
                .replaceAll("\\<strong>|\\</strong>", "");
    }
}
