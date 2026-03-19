package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a single task in the task management system.
 * @author [Your Name Here]
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructor. Default status is OPEN.
     * @param taskId unique task identifier
     * @param description task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /** @return the task ID */
    public String getTaskId() { return taskId; }

    /** @return the task description */
    public String getDescription() { return description; }

    /** @return current status */
    public String getStatus() { return status; }

    /**
     * Sets status. Only OPEN, IN_PROGRESS, COMPLETE are valid; otherwise UNKNOWN.
     * @param status new status value
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns string in required format: taskId description [status]
     * @return formatted string
     */
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}