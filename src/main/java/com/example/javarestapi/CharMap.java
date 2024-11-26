package com.example.javarestapi;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CharMap {
    private final String[][] map;
    private boolean caseSensitive = false;

    public CharMap(String map, String mapTo, boolean caseSensitive) {
        this.caseSensitive = caseSensitive;

        this.map = new String[][] {map.split(""), mapTo.split("")};
    }

    public CharMap(String map, String mapTo) {
        this.map = new String[][] {map.split(""), mapTo.split("")};
    }

    public String translate(String str) {

        String translated = str;

        for (int i = 0; i < this.map[0].length; i++) {
            Pattern regex = Pattern.compile(this.map[0][i],
                    this.caseSensitive ? Pattern.CASE_INSENSITIVE : 0);

            translated = translated.replaceAll(regex.toString(), this.map[1][i]);
        }

        return translated;
    }

    public String[][] getMap() {
        return this.map;
    }

    public void setCaseSensitive(boolean cs) {
        this.caseSensitive = cs;
    }

    public boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.map);
    }
}
