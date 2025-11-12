package facade;

import java.time.LocalDateTime;

public class CalendarService {

    public boolean isTutorAvailable(String tutorName, String dateTime) {
        System.out.println("[Calendar] Checking availability for tutor: " + tutorName + " at " + dateTime);
        // simulare
        return true;
    }

    public void bookSession(String studentName, String tutorName, String dateTime) {
        System.out.println("[Calendar] Booking session for " + studentName + " with " + tutorName + " at " + dateTime);
    }
}
