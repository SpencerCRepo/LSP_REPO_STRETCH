package org.howard.edu.lsp.midterm.crccards;

import java.util.*;


public class TaskManager {
    private Map<String, Task> tasks;


    public TaskManager() {
        tasks = new HashMap<>();
    }


    public void addTask(Task task) {
        String id = task.getTaskId();
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate task ID detected.");
        }
        tasks.put(id, task);
    }


    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }



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