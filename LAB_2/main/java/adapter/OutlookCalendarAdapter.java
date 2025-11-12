package adapter;

// Simulare SDK Outlook
class OutlookCalendarSDK {
    public void addMeeting(String subject, String start, String end) {
        System.out.println("[Outlook] Meeting added: " + subject +
                " (" + start + " - " + end + ")");
    }
}

// Adapter pentru Outlook
public class OutlookCalendarAdapter implements ICalendarService {
    private OutlookCalendarSDK outlookSdk;

    public OutlookCalendarAdapter() {
        this.outlookSdk = new OutlookCalendarSDK();
    }

    @Override
    public void addEvent(String startTime, String endTime, String title) {
        outlookSdk.addMeeting(title, startTime, endTime);
    }
}

