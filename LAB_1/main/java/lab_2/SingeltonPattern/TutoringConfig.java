package lab_2.SingeltonPattern;

public class TutoringConfig {

    private static volatile TutoringConfig instance;

    private String databaseUrl;
    private int maxConcurrentSessions;

    private TutoringConfig() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/tutoring_db";
        this.maxConcurrentSessions = 10;
        System.out.println("[CONFIG] Managerul de configuratii a fost initializat (O data).");
    }

    public static TutoringConfig getInstance() {
        if (instance == null) {
            synchronized (TutoringConfig.class) {
                if (instance == null) {
                    instance = new TutoringConfig();
                }
            }
        }
        return instance;
    }

    // Getters si Setters
    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setMaxConcurrentSessions(int maxSessions) {
        this.maxConcurrentSessions = maxSessions;
        System.out.println("[CONFIG] Sesiuni concurente setate la: " + maxSessions);
    }

    public int getMaxConcurrentSessions() {
        return maxConcurrentSessions;
    }

    public void logStatus() {
        System.out.println("Config Status: URL=" + databaseUrl + ", Max Sessions=" + maxConcurrentSessions);
    }
}
