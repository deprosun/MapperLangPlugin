package com.deprosun.mapperlangplugin;

import com.deprosun.mapperlangplugin.parser.MapperParser;
import com.deprosun.mapperlangplugin.psi.MapperFile;
import com.deprosun.mapperlangplugin.psi.MapperLanguage;
import com.deprosun.mapperlangplugin.psi.MapperLexerAdapter;
import com.deprosun.mapperlangplugin.psi.SimpleTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class MapperParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(SimpleTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(MapperLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new MapperLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new MapperParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new MapperFile(viewProvider);
    }

    public ParserDefinition.SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return ParserDefinition.SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return SimpleTypes.Factory.createElement(node);
    }
}
