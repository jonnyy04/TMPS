package memento;

public class NotesEditor {

    private String text = "";

    public void type(String newText) {
        text += newText;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento m) {
        this.text = m.getSavedText();
    }

    public static class Memento {
        private final String savedText;

        private Memento(String text) {
            this.savedText = text;
        }

        private String getSavedText() {
            return savedText;
        }
    }
}
