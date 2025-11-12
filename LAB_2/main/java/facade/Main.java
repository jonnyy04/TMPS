package facade;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TutoringSessionFacade tutoringFacade = new TutoringSessionFacade();

        // Clientul apeleaza doar o metoda simpla
        tutoringFacade.scheduleSession(
                "Maria",
                "Andrei",
                "14 November 2025, 15:00",
                25.0
        );
    }
}
