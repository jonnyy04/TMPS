package lab_2.BuilderPattern;

public class ReportDirector {
    public void constructReport(ReportBuilder builder, String student, int totalHours) {
        builder.buildHeader("Annual Progress - " + student);

        builder.buildStudentSummary(totalHours, "Acceptable");

        builder.buildRecommendations("Review of chapters 5 and 6.");
    }

}