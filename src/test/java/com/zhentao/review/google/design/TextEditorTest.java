package com.zhentao.review.google.design;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TextEditorTest {
    private TextEditor editor;
    
    @Before
    public void setup() {
        this.editor = new TextEditor();
    }
    @Test
    public void test() {
        assertThat(editor.toString(), is(""));
        assertThat(editor.cursor(), is(0));
        
        editor.insertCharacter('a');
        assertThat(editor.toString(), is("a"));
        assertThat(editor.cursor(), is(1));
        
        editor.insertCharacter('b');
        assertThat(editor.toString(), is("ab"));
        assertThat(editor.cursor(), is(2));
        
        editor.insertCharacter('c');
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(3));
        
        assertThat(editor.moveCursorRight(), is(false));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(3));
        
        editor.moveCursorLeft();
        editor.moveCursorLeft();
        assertThat(editor.moveCursorRight(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(2));
        
        assertThat(editor.moveCursorRight(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(3));
        
        editor.moveCursorLeft();
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(2));
        
        editor.moveCursorLeft();
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(1));
        
        editor.backspace();
        assertThat(editor.toString(), is("bc"));
        assertThat(editor.cursor(), is(0));
        
        assertThat(editor.moveCursorLeft(), is(false));
        assertThat(editor.toString(), is("bc"));
        assertThat(editor.cursor(), is(0));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(1));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(2));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(3));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(2));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(2));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc"));
        assertThat(editor.cursor(), is(3));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("ab"));
        assertThat(editor.cursor(), is(2));
        
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("a"));
        assertThat(editor.cursor(), is(1));
    }
}
