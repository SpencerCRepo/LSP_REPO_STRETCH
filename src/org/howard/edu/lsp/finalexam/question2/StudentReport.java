package org.howard.edu.lsp.finalexam.question2;

public class StudentReport extends Report {


    private String studentName;


    private double gpa;


    @Override
    protected void loadData() {
        studentName = "CJ MCDolalr";
        gpa = 3.4;
    }

    /**
     * {@inheritDoc}
     *
     * @return "Student Report"
     */
    @Override
    protected String formatHeader() {
        return "Student Report";
    }

    /**
     * {@inheritDoc}
     *
     * @return the student's name and GPA
     */
    @Override
    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    /**
     * {@inheritDoc}
     *
     * @return "End of Student Report"
     */
    @Override
    protected String formatFooter() {
        return "End of Student Report";
    }
}
