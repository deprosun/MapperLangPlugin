package com.deprosun.mapperlangplugin.psi;

import com.intellij.psi.tree.IElementType;

public class MapperElementType extends IElementType {
    public MapperElementType(String debugName) {
        super(debugName, MapperLanguage.INSTANCE);
    }
}
