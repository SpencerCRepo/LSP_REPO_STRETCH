package org.howard.edu.lsp.finalexam.question2;

public abstract class Report {


    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
    }


    protected abstract void loadData();

    /**
     * Formats and returns the header section of the report.
     *
     * @return the header content string
     */
    protected abstract String formatHeader();

    /**
     * Formats and returns the body section of the report.
     *
     * @return the body content string
     */
    protected abstract String formatBody();

    /**
     * Formats and returns the footer section of the report.
     *
     * @return the footer content string
     */
    protected abstract String formatFooter();
}
