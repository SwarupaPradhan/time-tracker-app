package com.example.timetracker.service;

import com.example.timetracker.model.TaskEntry;
import com.example.timetracker.repository.TaskEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private TaskEntry currentTask;

    private final TaskEntryRepository taskRepo;

    
    // Create new task
    public TaskEntry createTask(TaskEntry task) {
        task.setStartTime(null);
        task.setEndTime(null);
        return taskRepo.save(task);
    }

    // Delete by ID
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    // Start tracking a task
    public TaskEntry startTaskById(Long id) {
        TaskEntry task = taskRepo.findById(id).orElseThrow();
        task.setStartTime(LocalDateTime.now());
        task.setEndTime(null);
        return taskRepo.save(task);
    }

    // Stop tracking a task
    public TaskEntry stopTaskById(Long id) {
        TaskEntry task = taskRepo.findById(id).orElseThrow();
        task.setEndTime(LocalDateTime.now());
        return taskRepo.save(task);
    }

    // Fetch all tasks
    public List<TaskEntry> getAllLogs() {
        return taskRepo.findAll();
    }


    public TaskEntry startTask(Long id) {
    TaskEntry task = taskRepo.findById(id).orElseThrow();
    if (!Boolean.TRUE.equals(task.getIsRunning())) {
        task.setStartTime(LocalDateTime.now());
        task.setIsRunning(true);
    }
    return taskRepo.save(task);
}

public TaskEntry stopTask(Long id) {
    TaskEntry task = taskRepo.findById(id).orElseThrow();
    if (Boolean.TRUE.equals(task.getIsRunning())) {
        task.setEndTime(LocalDateTime.now());
        long duration = Duration.between(task.getStartTime(), task.getEndTime()).getSeconds();
        task.setTimeTracked(task.getTimeTracked() == null ? duration : task.getTimeTracked() + duration);
        task.setIsRunning(false);
    }
    return taskRepo.save(task);
}


}
