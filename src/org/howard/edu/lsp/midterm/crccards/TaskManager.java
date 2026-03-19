package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/** Manages collection of Tasks. */
public class TaskManager {
    private Map<String, Task> tasks;

    /** Default constructor. */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /** Adds task (throws on duplicate ID). */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID detected.");
        }
        tasks.put(task.getTaskId(), task);
    }

    /** Finds task by ID (null if not found). */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /** Returns tasks matching status. */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks.values()) {
            if (t.getStatus().equals(status)) {
                result.add(t);
            }
        }
        return result;
    }
}