package com.deprosun.mapperlangplugin.psi;

import com.intellij.lang.Language;

public class MapperLanguage extends Language {

    public static final MapperLanguage INSTANCE = new MapperLanguage();

    private MapperLanguage() {
        super("Mapper");
    }
}