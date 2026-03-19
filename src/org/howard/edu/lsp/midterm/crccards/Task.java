package org.howard.edu.lsp.midterm.crccards;


public class Task {
    private String taskId;
    private String description;
    private String status;

    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }


    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}