package com.deprosun.mapperlangplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MapperFile extends PsiFileBase {

    public MapperFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MapperLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MapperFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Simple File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}