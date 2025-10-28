package lab_2.BuilderPattern;

public interface ReportBuilder {
    void buildHeader(String titile);
    void buildStudentSummary(int hours, String performance);
    void buildRecommendations(String recommendations);
    TutoringReport getResult();
}
