package com.deprosun.mapperlangplugin.psi;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MapperFileType extends LanguageFileType {

    public static final MapperFileType INSTANCE = new MapperFileType();

    private MapperFileType() {
        super(MapperLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Mapper file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Mapper language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "mapper";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MapperIcon.ICON;
    }
}
