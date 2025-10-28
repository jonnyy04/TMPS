package lab_2.BuilderPattern;

public class DetailedReportBuilder implements ReportBuilder {
    private TutoringReport report;
    public DetailedReportBuilder() {
        this.report = new TutoringReport();
    }

    @Override
    public void buildHeader(String title){
        report.setHeader(title.toUpperCase());
    }

    @Override
    public void buildStudentSummary(int hours, String performance) {
        report.setSummary("Total hours: " + hours + " Performance: " + performance);
    }

    @Override
    public void buildRecommendations(String recommendations) {
        report.setRecommendation("Necessary actions: " + recommendations);
    }

    @Override
    public TutoringReport getResult() {
        TutoringReport finalReport = this.report;
        this.report = new TutoringReport();
        return finalReport;
    }

}
