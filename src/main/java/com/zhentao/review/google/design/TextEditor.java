package com.zhentao.review.google.design;

import java.util.Stack;

/**
 * <pre>
 * [Google] Design Text Editor (Doubly Linked List) 
Build a text editor class with the following functions, 

moveCursorLeft(), 

moveCursorRight(), 

insertCharacter(char) //insert the char right before cursor 

backspace() //delete the char right before cursor 

Follow-up 
Implement undo() //undo the last edit. Can be called multiple times until all edits are cancelled. 

All functions above should take O(1) time. 

Example 

( '|' denotes where the cursor locates. 'text' shows what's been written to the text editor. ) 

Start with empty text 
text = "|" 

insertCharacter('a') 
text = "a|" 

insertCharacter('b') 
text = "ab|" 

insertCharacter('c') 
text = "abc|" 

moveCursorLeft() 
text = "ab|c" 

moveCursorLeft() 
text = "a|bc" 

backspace() 
text = "|bc" 

moveCursorLeft() 
text = "|bc" (nothing happens since cursor was on the leftmost position) 

undo() 
text = "a|bc" 

undo() 
text = "ab|c" 

undo() 
text = "abc|" 

undo() 
text = "ab|" 

undo() 
text = "a|"
 * 
 * 
 * </pre>
 * 
 * @author
 *
 */
public class TextEditor {
    private final StringBuilder text;
    // store undo edits.
    private final Stack<UndoEdit> undoEdits;
    private int cursorIndex;

    public TextEditor() {
        this.text = new StringBuilder();
        undoEdits = new Stack<>();
        cursorIndex = 0;
    }

    public boolean moveCursorLeft() {
        return moveCursorLeft(Undo.SAVE);
    }

    private boolean moveCursorLeft(final Undo undo) {
        if (cursorIndex == 0) {
            return false;
        }

        cursorIndex--;
        undo.add(new UndoEdit(UndoEdit.Operation.MOVE_CURSOR_RIGHT), this);
        return true;
    }

    public boolean moveCursorRight() {
        return moveCursorRight(Undo.SAVE);
    }

    private boolean moveCursorRight(final Undo undo) {
        if (cursorIndex == text.length()) {
            return false;
        }

        cursorIndex++;
        undo.add(new UndoEdit(UndoEdit.Operation.MOVE_CURSOR_LEFT), this);
        return true;
    }

    public boolean insertCharacter(final char ch) {
        return insertCharacter(ch, Undo.SAVE);
    }

    private boolean insertCharacter(final char ch, final Undo undo) {
        text.insert(cursorIndex, ch);
        cursorIndex++;
        undo.add(new UndoEdit(UndoEdit.Operation.BACKSPACE), this);
        return true;
    }

    public boolean backspace() {
        return backspace(Undo.SAVE);
    }

    private boolean backspace(final Undo undo) {
        if (cursorIndex == 0) {
            return false;
        }

        cursorIndex--;
        final char ch = text.charAt(cursorIndex);
        undo.add(new UndoEdit(UndoEdit.Operation.INSERT_CHARACTER, ch), this);
        text.deleteCharAt(cursorIndex);
        return true;
    }

    public boolean undo() {
        if (!undoEdits.empty()) {
            final UndoEdit edit = undoEdits.pop();
            return edit.apply(this);
        }
        return false;
    }

    private void saveForUndo(final UndoEdit action) {
        undoEdits.add(action);
    }

    // for unit test/debug
    int cursor() {
        return cursorIndex;
    }

    @Override
    public String toString() {
        return new StringBuilder(text).insert(cursorIndex, "|").toString();
    }

    enum Undo {
        SAVE {
            @Override
            public void add(final UndoEdit edit, final TextEditor textEditor) {
                textEditor.saveForUndo(edit);
            }
        },
        UNSAVE;

        /**
         * Default implementation for doing nothing
         * 
         * @param edit
         * @param textEditor
         */
        public void add(final UndoEdit edit, final TextEditor textEditor) {
            // do nothing
        }
    }

    /**
     * Helper class to encapsulate undo operation and character.
     */
    private static class UndoEdit {
        private static final char EMPTY_CHAR = '\0';
        private final Operation operation;
        private final char ch;

        public UndoEdit(final Operation operation) {
            this.operation = operation;
            this.ch = EMPTY_CHAR;
        }

        public UndoEdit(final Operation operation, final char ch) {
            this.operation = operation;
            this.ch = ch;
        }

        public boolean apply(final TextEditor editor) {
            return operation.apply(ch, editor);
        }

        @Override
        public String toString() {
            return operation.toString() + " " + ch;
        }

        enum Operation {
            MOVE_CURSOR_LEFT {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.moveCursorLeft(Undo.UNSAVE);
                }
            },
            MOVE_CURSOR_RIGHT {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.moveCursorRight(Undo.UNSAVE);
                }
            },
            INSERT_CHARACTER {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.insertCharacter(ch, Undo.UNSAVE);
                }
            },
            BACKSPACE {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.backspace(Undo.UNSAVE);
                }
            };

            public abstract boolean apply(char ch, TextEditor editor);
        }
    }
}
