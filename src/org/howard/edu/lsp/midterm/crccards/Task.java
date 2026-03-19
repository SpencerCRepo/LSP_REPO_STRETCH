package org.howard.edu.lsp.midterm.crccards;

/** Represents a task. */
public class Task {
    private String taskId;
    private String description;
    private String status;


    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /** Returns task ID. */
    public String getTaskId() { return taskId; }

    /** Returns description. * */
    public String getDescription() { return description; }

    /** Returns status.* */
    public String getStatus() { return status; }

    /** Sets status **/
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /** Returns " ID description " */
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}