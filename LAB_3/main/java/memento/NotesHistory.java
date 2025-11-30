package memento;

import java.util.Stack;

public class NotesHistory {
    private Stack<NotesEditor.Memento> history = new Stack<>();

    public void saveState(NotesEditor editor) {
        history.push(editor.save());
    }

    public void undo(NotesEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        }
    }
}

