package org.howard.edu.lsp.finalexam.question2;

public class CourseReport extends Report {

    /** The course name, set in {@link #loadData()}. */
    private String courseName;

    /** The number of enrolled students, set in {@link #loadData()}. */
    private int enrollment;


    @Override
    protected void loadData() {
        courseName = "Math 200";
        enrollment = 90;
    }

    /**
     * {@inheritDoc}
     *
     * @return "Course Report"
     */
    @Override
    protected String formatHeader() {
        return "Course Report";
    }

    /**
     * {@inheritDoc}
     *
     * @return the course name and enrollment count
     */
    @Override
    protected String formatBody() {
        return "Course: " + courseName + "\nEnrollment: " + enrollment;
    }

    /**
     * {@inheritDoc}
     *
     * @return "End of Course Report"
     */
    @Override
    protected String formatFooter() {
        return "End of Course Report";
    }
}