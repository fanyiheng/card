package com.bx.card.util;

public class Strings {

    public static final String EMPTY_STR = "";

    public static String toString(Object obj){
        return toString(obj,EMPTY_STR);
    }

    public static boolean isEmpty(String str){
        return str == null ? true :(EMPTY_STR.equals(str.trim()));
    }

    public static String toString(Object obj, String defaultVal) {
        return obj==null ? defaultVal : obj.toString();
    }
}
