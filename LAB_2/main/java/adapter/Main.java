package adapter;

public class Main {
    public static void main(String[] args) {
        ICalendarService googleCalendar = new GoogleCalendarAdapter();
        ICalendarService outlookCalendar = new OutlookCalendarAdapter();

        TutoringScheduler scheduler1 = new TutoringScheduler(googleCalendar);
        scheduler1.scheduleSession("Maria", "Andrei", "10:00", "11:00");

        TutoringScheduler scheduler2 = new TutoringScheduler(outlookCalendar);
        scheduler2.scheduleSession("Alex", "Ioana", "13:00", "14:00");

    }
}
