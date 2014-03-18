/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package Kompression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Florian Bauer on 10.02.14. flbaue@posteo.de
 */
public class RunLength {

    private static final String MARKER = "Z";

    public static void main(String[] args) {

        String result = new RunLength().compress(args[0]);
        System.out.println(result);
    }

    public String compress(String input) {

        List<String> groups = new ArrayList<>();

        Pattern p = Pattern.compile("(.)\1*");
        Matcher m = p.matcher(input);
        while (m.find()) {
            String x = m.group(1);
            String x2 = input.substring(m.start(), m.end());
            groups.add(x);
        }


        return "";
    }
}
