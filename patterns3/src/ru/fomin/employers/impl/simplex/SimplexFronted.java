package ru.fomin.employers.impl.simplex;

import ru.fomin.employers.Frontend;

public class SimplexFronted implements Frontend {
    @Override
    public String writeHtml(String description) {
        return "Good html but without DOM tree";
    }

    @Override
    public void writeJavaScriptCode(String description) {
        System.out.println("Was used only JavaScript");
    }
}
