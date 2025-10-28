package lab_2.SingeltonPattern;

public class SingletonDemo {

    public static void main(String[] args) {

        System.out.println("--- DEMO SINGLETON (Double-Checked Locking) ---");

        System.out.println("Solicitare 1...");
        TutoringConfig config1 = TutoringConfig.getInstance();
        config1.logStatus();

        System.out.println("------------------------------------------");

        System.out.println("Solicitare 2...");
        TutoringConfig config2 = TutoringConfig.getInstance();

        System.out.println("config1 == config2? " + (config1 == config2));

        config2.setMaxConcurrentSessions(20);

        System.out.print("Valoarea vazuta prin config1: ");
        config1.logStatus();
    }
}
