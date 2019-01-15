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
    private StringBuilder text;
    // store undo actions.
    private Stack<Action> undoAction;
    private int cursorIndex;

    public TextEditor() {
        this.text = new StringBuilder();
        undoAction = new Stack<>();
        cursorIndex = 0;
    }

    public boolean moveCursorLeft() {
        return moveCursorLeft(Undo.SAVE);
    }

    private boolean moveCursorLeft(Undo undo) {
        if (cursorIndex == 0) {
            return false;
        }

        cursorIndex--;
        undo.add(new Action(Operation.MOVE_CURSOR_RIGHT), this);
        return true;
    }

    public boolean moveCursorRight() {
        return moveCursorRight(Undo.SAVE);
    }

    private boolean moveCursorRight(Undo undo) {
        if (cursorIndex == text.length()) {
            return false;
        }
        
        cursorIndex++;
        undo.add(new Action(Operation.MOVE_CURSOR_LEFT), this);
        return true;
    }

    public boolean insertCharacter(char ch) {
        return insertCharacter(ch, Undo.SAVE);
    }

    private boolean insertCharacter(char ch, Undo undo) {
        text.insert(cursorIndex, ch);
        cursorIndex++;
        undo.add(new Action(Operation.BACKSPACE), this);
        return true;
    }

    public boolean backspace() {
        return backspace(Undo.SAVE);
    }

    private boolean backspace(Undo undo) {
        if (cursorIndex == 0) {
            return false;
        }

        cursorIndex--;
        char ch = text.charAt(cursorIndex);
        undo.add(new Action(Operation.INSERT_CHARACTER, ch), this);
        text.deleteCharAt(cursorIndex);
        return true;
    }

    public boolean undo() {
        if (!undoAction.empty()) {
            Action action = undoAction.pop();
            return action.act(this);
        }
        return false;
    }

    private void saveForUndo(Action action) {
        undoAction.add(action);
    }
    
    //for unit test/debug 
    int cursor() {
        return cursorIndex;
    }

    @Override
    public String toString() {
        return text.toString();
    }

    enum Undo {
        SAVE {
            @Override
            public void add(Action action, TextEditor textEditor) {
                textEditor.saveForUndo(action);
            }
        },
        UNSAVE;

        public void add(Action action, TextEditor textEditor) {
            // do nothing
        }
    }

    enum Operation {
        MOVE_CURSOR_LEFT {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.moveCursorLeft(Undo.UNSAVE);
            }
        },
        MOVE_CURSOR_RIGHT {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.moveCursorRight(Undo.UNSAVE);
            }
        },
        INSERT_CHARACTER {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.insertCharacter(ch, Undo.UNSAVE);
            }
        },
        BACKSPACE {
            @Override
            public boolean apply(char ch, TextEditor editor) {
                return editor.backspace(Undo.UNSAVE);
            }
        };

        public abstract boolean apply(char ch, TextEditor editor);
    }

    /**
     * Helper class to wrap the value with Operation
     *
     */
    private static class Action {
        private static final char EMPTY_CHAR = '\0';
        private final Operation operation;
        private final char ch;

        public Action(Operation operation) {
            this.operation = operation;
            this.ch = EMPTY_CHAR;
        }
        public Action(Operation operation, char ch) {
            this.operation = operation;
            this.ch = ch;
        }

        public boolean act(TextEditor editor) {
            return operation.apply(ch, editor);
        }

        @Override
        public String toString() {
            return operation.toString() + " " + ch;
        }
    }
}
