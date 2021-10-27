package com.deprosun.mapperlangplugin.psi;

import com.intellij.psi.tree.IElementType;

public class MapperTokenType extends IElementType {

    public MapperTokenType(String debugName) {
        super(debugName, MapperLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "MapperTokenType." + super.toString();
    }
}
