package facade;

import java.time.LocalDateTime;

public class TutoringSessionFacade {

    private CalendarService calendarService;
    private NotificationService notificationService;
    private PaymentService paymentService;

    public TutoringSessionFacade() {
        this.calendarService = new CalendarService();
        this.notificationService = new NotificationService();
        this.paymentService = new PaymentService();
    }

    public void scheduleSession(String studentName, String tutorName, String dateTime, double price) {
        System.out.println("=== Scheduling Tutoring Session ===");

        // 1. Verifică disponibilitatea tutorului
        if (!calendarService.isTutorAvailable(tutorName, dateTime)) {
            System.out.println("[Facade] Tutor is not available. Cannot schedule session.");
            return;
        }

        // 2. Procesează plata
        boolean paymentSuccess = paymentService.processPayment(studentName, price);
        if (!paymentSuccess) {
            System.out.println("[Facade] Payment failed. Session not scheduled.");
            return;
        }

        // 3. Programează sesiunea în calendar
        calendarService.bookSession(studentName, tutorName, dateTime);

        // 4. Trimite notificări către ambele părți
        notificationService.notifyStudent(studentName, "Your session with " + tutorName + " is scheduled for " + dateTime);
        notificationService.notifyTutor(tutorName, "You have a new session with " + studentName + " at " + dateTime);

        System.out.println("[Facade] Session scheduled successfully!");
    }
}
