package lab_2.BuilderPattern;

public class TutoringReport {
    private String header;
    private String summary;
    private String recommendation;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "\n--- TUTORING REPORT ---\n" +
                "Header: " + header + "\n" +
                "Student Summary: " + summary + "\n" +
                "Recommendations: " + recommendation + "\n" +
                "--------------------------";
    }
}