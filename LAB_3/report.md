# Behavioral Design Patterns

**Author:** [Your Name]

## Objectives:
* Get familiar with Behavioral Design Patterns;
* Choose a specific domain;
* Implement 3 Behavioral Design Patterns for the specific domain;

## Domain
The chosen domain is a **Tutoring Management System** that handles authentication workflows, session history management, and request processing for educational services.

## Implemented Behavioral Design Patterns:

### 1. Mediator Pattern
### 2. Memento Pattern
### 3. Chain of Responsibility Pattern

## Implementation

### Mediator Pattern

The Mediator Pattern defines an object that encapsulates how a set of other objects interact with one another. It reduces coupling between classes that communicate with each other. In this implementation, the pattern manages the interaction between UI components (username field, password field, login button) in the tutoring platform's authentication dialog without direct dependencies between components.

**TutoringMediator.java (Mediator Interface):**
```java
package mediator;

public interface TutoringMediator {
    void notify(Component sender, String event);
}
```

**Component.java (Abstract Component):**
```java
package mediator;

public abstract class Component {
    protected TutoringMediator mediator;

    public Component(TutoringMediator mediator) {
        this.mediator = mediator;
    }
}
```

**UsernameField.java (Concrete Component):**
```java
package mediator;

public class UsernameField extends Component {
    private String text = "";

    public UsernameField(TutoringMediator mediator) {
        super(mediator);
    }

    public void setText(String t) {
        text = t;
        mediator.notify(this, "text");
    }

    public String getText() {
        return text;
    }
}
```

**PasswordField.java (Concrete Component):**
```java
package mediator;

public class PasswordField extends Component {
    private String text = "";

    public PasswordField(TutoringMediator mediator) {
        super(mediator);
    }

    public void setText(String t) {
        text = t;
        mediator.notify(this, "text");
    }

    public String getText() {
        return text;
    }
}
```

**LoginButton.java (Concrete Component):**
```java
package mediator;

public class LoginButton extends Component {
    public LoginButton(TutoringMediator mediator) {
        super(mediator);
    }

    public void click() {
        mediator.notify(this, "click");
    }
}
```

**TutoringLoginDialog.java (Concrete Mediator):**
```java
package mediator;

public class TutoringLoginDialog implements TutoringMediator {
    private UsernameField username;
    private PasswordField password;
    private LoginButton loginButton;

    public TutoringLoginDialog() {
        this.username = new UsernameField(this);
        this.password = new PasswordField(this);
        this.loginButton = new LoginButton(this);
    }

    public UsernameField getUsername() { return username; }
    public PasswordField getPassword() { return password; }
    public LoginButton getLoginButton() { return loginButton; }

    @Override
    public void notify(Component sender, String event) {
        if (sender == loginButton && event.equals("click")) {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                System.out.println("[Mediator] Please enter username and password.");
            } else if (username.getText().equals("student") && password.getText().equals("tutor123")) {
                System.out.println("[Mediator] Welcome to tutoring platform, " + username.getText() + "!");
            } else {
                System.out.println("[Mediator] Invalid credentials.");
            }
        }
    }
}
```

**Main.java:**
```java
package mediator;

public class Main {
    public static void main(String[] args) {
        TutoringLoginDialog dialog = new TutoringLoginDialog();

        dialog.getUsername().setText("student");
        dialog.getPassword().setText("tutor123");
        dialog.getLoginButton().click();
    }
}
```

**Key Features:**
- **Decoupled components**: UI components don't need direct knowledge of each other
- **Centralized control**: All interaction logic resides in the mediator
- **Reusability**: Components can be reused with different mediators
- **Easy maintenance**: Changes to interaction logic only affect the mediator

### Memento Pattern

The Memento Pattern captures and externalizes an object's internal state without violating encapsulation, allowing the object to be restored to this state later. In this implementation, the pattern enables undo functionality for tutoring notes, creating snapshots of editor state and restoring previous versions on demand.

**NotesEditor.java (Originator + Memento):**
```java
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
```

**NotesHistory.java (Caretaker):**
```java
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
```

**Main.java:**
```java
package memento;

public class Main {
    public static void main(String[] args) {
        NotesEditor editor = new NotesEditor();
        NotesHistory history = new NotesHistory();

        editor.type("Lesson 1: Introduction to Java.\n");
        history.saveState(editor);

        editor.type("Student observation: OOP is important.\n");
        history.saveState(editor);

        editor.type("Example: Mediator pattern.\n");

        System.out.println("Current text:\n" + editor.getText());

        history.undo(editor);
        System.out.println("\nAfter UNDO 1:\n" + editor.getText());

        history.undo(editor);
        System.out.println("\nAfter UNDO 2:\n" + editor.getText());
    }
}
```

**Key Features:**
- **Encapsulation preservation**: Memento is created only by the originator
- **State snapshots**: Complete state captured at any moment
- **Undo functionality**: Easy restoration to previous states
- **History management**: Clean separation between caretaker and originator

### Chain of Responsibility Pattern

The Chain of Responsibility Pattern lets you pass requests along a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain. In this implementation, the pattern manages authentication by passing requests through a chain of validation handlers.

**TutoringDatabase.java (Utility Class):**
```java
package chain;

import java.util.HashMap;
import java.util.Map;

public class TutoringDatabase {
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> roles = new HashMap<>();

    public TutoringDatabase() {
        users.put("student1", "pass123");
        users.put("tutorA", "teachme");
        users.put("admin", "root");

        roles.put("student1", "STUDENT");
        roles.put("tutorA", "TUTOR");
        roles.put("admin", "ADMIN");
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public boolean isPasswordValid(String username, String password) {
        return users.get(username).equals(password);
    }

    public String getRole(String username) {
        return roles.get(username);
    }
}
```

**Handler.java (Abstract Handler):**
```java
package chain;

public abstract class Handler {
    private Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public boolean handleNext(String username, String password) {
        if (next == null) return true;
        return next.handle(username, password);
    }

    public abstract boolean handle(String username, String password);
}
```

**UserExistsHandler.java (Concrete Handler):**
```java
package chain;

public class UserExistsHandler extends Handler {
    private TutoringDatabase db;

    public UserExistsHandler(TutoringDatabase db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!db.userExists(username)) {
            System.out.println("[UserExistsHandler] User does not exist. Create an account.");
            return false;
        }
        return handleNext(username, password);
    }
}
```

**ValidPasswordHandler.java (Concrete Handler):**
```java
package chain;

public class ValidPasswordHandler extends Handler {
    private TutoringDatabase db;

    public ValidPasswordHandler(TutoringDatabase db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!db.isPasswordValid(username, password)) {
            System.out.println("[ValidPasswordHandler] Incorrect password.");
            return false;
        }
        return handleNext(username, password);
    }
}
```

**RoleCheckHandler.java (Concrete Handler):**
```java
package chain;

public class RoleCheckHandler extends Handler {
    private TutoringDatabase db;

    public RoleCheckHandler(TutoringDatabase db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        String role = db.getRole(username);

        if (role.equals("ADMIN")) {
            System.out.println("[RoleCheckHandler] Authentication successful. Welcome, Administrator!");
        } else if (role.equals("TUTOR")) {
            System.out.println("[RoleCheckHandler] Authentication successful. Welcome, Tutor!");
        } else {
            System.out.println("[RoleCheckHandler] Authentication successful. Welcome, Student!");
        }

        return handleNext(username, password);
    }
}
```

**AuthService.java (Client):**
```java
package chain;

public class AuthService {
    private Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public void login(String username, String password) {
        if (handler.handle(username, password)) {
            System.out.println("[AuthService] Access granted to tutoring platform.\n");
        }
    }
}
```

**Main.java:**
```java
package chain;

public class Main {
    public static void main(String[] args) {
        TutoringDatabase db = new TutoringDatabase();

        Handler chain = new UserExistsHandler(db);
        chain.setNext(new ValidPasswordHandler(db))
             .setNext(new RoleCheckHandler(db));

        AuthService auth = new AuthService(chain);

        auth.login("student1", "pass123");
        auth.login("tutorA", "wrong");
        auth.login("admin", "root");
    }
}
```

**Key Features:**
- **Sequential processing**: Requests processed through ordered handlers
- **Independent handlers**: Each handler focuses on single responsibility
- **Dynamic chain building**: Handlers can be added/removed at runtime
- **Early termination**: Chain stops when condition is not met

## Results

### Mediator Pattern Output:
```
Bun venit pe platforma de tutoring, student!
```

### Memento Pattern Output:
```
Text curent:
Lectia 1: Introducere in Java.
Observatie student: OOP este important.
Exemplu mediator pattern.

Dupa UNDO 1:
Lectia 1: Introducere in Java.
Observatie student: OOP este important.

Dupa UNDO 2:
Lectia 1: Introducere in Java.
```

### Chain of Responsibility Pattern Output:
```
Autentificare reusita. Bine ai venit, Student!
Acces permis la platforma de tutoring.

Parola incorecta.

Autentificare reusita. Bine ai venit, Administrator!
Acces permis la platforma de tutoring.
```

## Conclusions

The implementation of Behavioral Design Patterns significantly enhances the architecture and maintainability of the Tutoring Management System by improving how objects collaborate and distribute responsibility:

1. **Mediator Pattern** centralizes the interaction logic between UI components, eliminating tight coupling and making components reusable across different contexts. By acting as a single point of contact, the mediator pattern ensures that changes to interaction rules only affect the mediator class, not individual components. This pattern is particularly valuable for complex user interfaces where multiple components need coordination.

2. **Memento Pattern** provides a clean mechanism for implementing undo/redo functionality while preserving encapsulation. The pattern ensures that state snapshots are created only by the originator, preventing external manipulation of internal state. This results in a secure, maintainable approach to state management that scales well with application complexity.

3. **Chain of Responsibility Pattern** creates a flexible, extensible authentication system where validation logic is distributed across independent handlers. Each handler maintains single responsibility while the chain structure allows easy addition of new validation steps. The pattern elegantly handles scenarios where request processing depends on multiple sequential conditions that may change over time.

Together, these three patterns demonstrate how behavioral design patterns improve code organization, maintainability, and flexibility in handling complex interactions and workflows within the tutoring management system.