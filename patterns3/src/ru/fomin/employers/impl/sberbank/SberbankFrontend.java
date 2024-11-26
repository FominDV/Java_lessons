package ru.fomin.employers.impl.sberbank;

import ru.fomin.employers.Frontend;

public class SberbankFrontend implements Frontend {

    @Override
    public String writeHtml(String description) {
        return "Good html that contains DOM tree";
    }

    @Override
    public void writeJavaScriptCode(String description) {
        System.out.println("Was used React");
    }

}
