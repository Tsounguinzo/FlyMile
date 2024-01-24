package com.example.FlyMile.AAscrapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fewMethodsMightBeForTheFuture {


    public static LocalDate extractDateFromUrl(String url) {

            var pattern = Pattern.compile(".*(\\d{4}-\\d{2}-\\d{2}).*");

            Matcher date = pattern.matcher(url);

        if (date.find()) {
            return Date.valueOf(date.group(1)).toLocalDate();
        } else {
            return null;
        }

    }
}
