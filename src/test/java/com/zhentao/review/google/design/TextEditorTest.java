package com.zhentao.review.google.design;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.zhentao.review.google.design.TextEditor.ListNode;
public class TextEditorTest {
    private static final ListNode TAIL = new ListNode();
    private TextEditor editor;

    @Before
    public void setup() {
        this.editor = new TextEditor();
    }
    @Test
    public void test() {
        assertThat(editor.toString(), is("|"));
        assertThat(editor.cursor(), is(TAIL));

        editor.insertCharacter('a');
        assertThat(editor.toString(), is("a|"));
        assertThat(editor.cursor(), is(TAIL));

        editor.insertCharacter('b');
        assertThat(editor.toString(), is("ab|"));
        assertThat(editor.cursor(), is(TAIL));

        editor.insertCharacter('c');
        assertThat(editor.toString(), is("abc|"));
        assertThat(editor.cursor(), is(TAIL));

        assertThat(editor.moveCursorRight(), is(false));
        assertThat(editor.toString(), is("abc|"));
        assertThat(editor.cursor(), is(TAIL));

        editor.moveCursorLeft();
        editor.moveCursorLeft();
        assertThat(editor.moveCursorRight(), is(true));
        assertThat(editor.toString(), is("ab|c"));
        assertThat(editor.cursor(), is(new ListNode('c')));

        assertThat(editor.moveCursorRight(), is(true));
        assertThat(editor.toString(), is("abc|"));
        assertThat(editor.cursor(), is(TAIL));

        editor.moveCursorLeft();
        assertThat(editor.toString(), is("ab|c"));
        assertThat(editor.cursor(), is(new ListNode('c')));

        editor.moveCursorLeft();
        assertThat(editor.toString(), is("a|bc"));
        assertThat(editor.cursor(), is(new ListNode('b')));

        editor.backspace();
        assertThat(editor.toString(), is("|bc"));
        assertThat(editor.cursor(), is(new ListNode('b')));

        assertThat(editor.moveCursorLeft(), is(false));
        assertThat(editor.toString(), is("|bc"));
        assertThat(editor.cursor(), is(new ListNode('b')));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("a|bc"));
        assertThat(editor.cursor(), is(new ListNode('b')));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("ab|c"));
        assertThat(editor.cursor(), is(new ListNode('c')));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc|"));
        assertThat(editor.cursor(), is(TAIL));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("ab|c"));
        assertThat(editor.cursor(), is(new ListNode('c')));

        assertThat(editor.undo(), is(true));
        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("ab|c"));
        assertThat(editor.cursor(), is(new ListNode('c')));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("abc|"));
        assertThat(editor.cursor(), is(TAIL));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("ab|"));
        assertThat(editor.cursor(), is(TAIL));

        assertThat(editor.undo(), is(true));
        assertThat(editor.toString(), is("a|"));
        assertThat(editor.cursor(), is(TAIL));
    }
}
