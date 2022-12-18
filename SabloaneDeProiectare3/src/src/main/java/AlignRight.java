package main.java;

import javax.naming.Context;

public class AlignRight implements AlignStrategy{
    @Override
    public void render(String text) {
        System.out.printf("### %s #\n",text);
    }
}
