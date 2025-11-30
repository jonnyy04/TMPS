package memento;

public class Main {
    public static void main(String[] args) {
        NotesEditor editor = new NotesEditor();
        NotesHistory history = new NotesHistory();

        editor.type("Lectia 1: Introducere in Java.\n");
        history.saveState(editor);

        editor.type("Observatie student: OOP este important.\n");
        history.saveState(editor);

        editor.type("Exemplu mediator pattern.\n");

        System.out.println("Text curent:\n" + editor.getText());

        history.undo(editor);
        System.out.println("\nDupa UNDO 1:\n" + editor.getText());

        history.undo(editor);
        System.out.println("\nDupa UNDO 2:\n" + editor.getText());
    }
}

