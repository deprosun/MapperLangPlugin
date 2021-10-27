package com.deprosun.mapperlangplugin;

import com.deprosun.mapperlangplugin.psi.MapperLexerAdapter;
import com.deprosun.mapperlangplugin.psi.SimpleTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MapperSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey TOPIC =
            createTextAttributesKey("TOPIC", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey DOT =
            createTextAttributesKey("DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey LP =
            createTextAttributesKey("LP", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey ID =
            createTextAttributesKey("ID", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey[] TOPIC_KEYS = new TextAttributesKey[]{TOPIC};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DOT};
    private static final TextAttributesKey[] LP_KEYS = new TextAttributesKey[]{LP};
    private static final TextAttributesKey[] ID_KEYS = new TextAttributesKey[]{ID};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new MapperLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SimpleTypes.TOPIC)
                || tokenType.equals(SimpleTypes.FROM)
                || tokenType.equals(SimpleTypes.FILTER)
                || tokenType.equals(SimpleTypes.BROADCAST)
                || tokenType.equals(SimpleTypes.AS)) {
            return TOPIC_KEYS;
        } else if (tokenType.equals(SimpleTypes.DOT)) {
            return DOT_KEYS;
        } else if (tokenType.equals(SimpleTypes.LP) || tokenType.equals(SimpleTypes.RP)) {
            return LP_KEYS;
        } else if (tokenType.equals(SimpleTypes.ID)) {
            return ID_KEYS;
        } else {
            return EMPTY_KEYS;
        }

    }
}
