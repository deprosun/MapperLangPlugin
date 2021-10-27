package com.deprosun.mapperlangplugin.psi;

import com.deprosun.mapperlangplugin.lexer._MapperLexer;
import com.intellij.lexer.FlexAdapter;

public class MapperLexerAdapter extends FlexAdapter {
    public MapperLexerAdapter() {
        super(new _MapperLexer(null));
    }
}
