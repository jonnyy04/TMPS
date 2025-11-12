package lab_2.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        ReportDirector director = new ReportDirector();

        DetailedReportBuilder detailedBuilder = new DetailedReportBuilder();
        director.constructReport(detailedBuilder, "Ana Popa", 15);
        TutoringReport detailedReport = detailedBuilder.getResult();
        System.out.println("--- 1. REPORT (Constructed by Director) ---");
        System.out.println(detailedReport);


        ReportBuilder directBuilder = new DetailedReportBuilder();
        System.out.println("--- 2. DIRECT CONSTRUCTION (Without Director) ---");

        directBuilder.buildHeader("Custom Report");
        directBuilder.buildStudentSummary(5, "Excellent");
        // no recommendations
        TutoringReport customReport = directBuilder.getResult();
        System.out.println(customReport);
    }
}