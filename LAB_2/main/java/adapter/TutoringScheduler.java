package adapter;

public class TutoringScheduler {
    private ICalendarService calendarService;

    public TutoringScheduler(ICalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public void scheduleSession(String tutorName, String studentName, String start, String end) {
        String title = "Tutoring session: " + tutorName + " & " + studentName;
        calendarService.addEvent(start, end, title);
    }
}

