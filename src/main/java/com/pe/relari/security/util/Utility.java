package com.pe.relari.security.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private Utility() {}

    private static final String DATETIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
    public static final String TYPE_AUTHENTICATION = "Bearer";

    public static String formatDate(Date date) {
        return new SimpleDateFormat(DATETIME_PATTERN).format(date);
    }

    public static boolean validateDateExpiration(Date date) {
        return date.before(new Date());
    }

}
