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
    private static final char EMPTY_CHAR = '\0';
    private StringBuilder text;
    // store undo actions.
    private Stack<Action> undo;
    private int cursorIndex;

    public TextEditor() {
        this.text = new StringBuilder();
        undo = new Stack<>();
        cursorIndex = 0;
    }

    public boolean moveCursorLeft() {
        return moveCursorLeft(true);
    }

    private boolean moveCursorLeft(boolean saveForUndo) {
        if (cursorIndex == 0) {
            return false;
        }
        cursorIndex--;
        if (saveForUndo) {
            undo.add(new Action(Operation.MOVE_CURSOR_RIGHT, EMPTY_CHAR));
        }
        return true;
    }

    public boolean moveCursorRight() {
        return moveCursorRight(true);
    }

    private boolean moveCursorRight(boolean saveForUndo) {
        if (cursorIndex == text.length()) {
            return false;
        }
        cursorIndex++;
        if (saveForUndo) {
            undo.add(new Action(Operation.MOVE_CURSOR_LEFT, EMPTY_CHAR));
        }
        return true;
    }

    public boolean insertCharacter(char ch) {
        return insertCharacter(ch, true);
    }

    private boolean insertCharacter(char ch, boolean saveForUndo) {
        text.insert(cursorIndex, ch);
        cursorIndex++;
        if (saveForUndo) {
            undo.add(new Action(Operation.BACKSPACE, EMPTY_CHAR));
        }
        return true;
    }

    public boolean backspace() {
        return backspace(true);
    }

    private boolean backspace(boolean saveForUndo) {
        if (cursorIndex == 0) {
            return false;
        }

        cursorIndex--;

        if (saveForUndo) {
            char ch = text.charAt(cursorIndex);
            undo.add(new Action(Operation.INSERT_CHARACTER, ch));
        }
        text.deleteCharAt(cursorIndex);
        return true;
    }

    public boolean undo() {
        if (!undo.empty()) {
            Action action = undo.pop();
            return action.operation.apply(action.ch, this);
        }
        return false;
    }

    public int cursor() {
        return cursorIndex;
    }

    @Override
    public String toString() {
        return text.toString();
    }

    enum Undo {
        SAVE(true), UNSAVE(false);
        private boolean saveForUndo;

        private Undo(boolean saveForUndo) {
            this.saveForUndo = saveForUndo;
        }

        public boolean saveForUndo() {
            return saveForUndo;
        }
    }

    enum Operation {
        MOVE_CURSOR_LEFT {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.moveCursorLeft(false);
            }
        },
        MOVE_CURSOR_RIGHT {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.moveCursorRight(false);
            }
        },
        INSERT_CHARACTER {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.insertCharacter(ch, false);
            }
        },
        BACKSPACE {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.backspace(false);
            }
        };

        public abstract boolean apply(char ch, TextEditor editor);
    }

    /**
     * Helper class to wrap the value with Operation
     *
     */
    private static class Action {
        final Operation operation;
        final char ch;

        public Action(Operation operation, char ch) {
            super();
            this.operation = operation;
            this.ch = ch;
        }

        @Override
        public String toString() {
            return operation.toString() + " " + ch;
        }
    }
}
