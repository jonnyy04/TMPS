package facade;

public class NotificationService {

    public void notifyTutor(String tutorName, String message) {
        System.out.println("[Notification] Sending to tutor " + tutorName + ": " + message);
    }

    public void notifyStudent(String studentName, String message) {
        System.out.println("[Notification] Sending to student " + studentName + ": " + message);
    }
}
