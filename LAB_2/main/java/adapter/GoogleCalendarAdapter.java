package adapter;

// Simulare API extern Google Calendar
class GoogleCalendarAPI {
    public void createEvent(String title, String start, String end) {
        System.out.println("[Google Calendar] Event created: " + title +
                " (" + start + " - " + end + ")");
    }
}

// Adapter pentru Google
public class GoogleCalendarAdapter implements ICalendarService {
    private GoogleCalendarAPI googleApi;

    public GoogleCalendarAdapter() {
        this.googleApi = new GoogleCalendarAPI();
    }

    @Override
    public void addEvent(String startTime, String endTime, String title) {
        googleApi.createEvent(title, startTime, endTime);
    }
}

