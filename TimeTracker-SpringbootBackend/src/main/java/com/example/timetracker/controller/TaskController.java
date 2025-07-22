package com.example.timetracker.controller;

import com.example.timetracker.model.TaskEntry;
import com.example.timetracker.repository.TaskEntryRepository;
import com.example.timetracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class TaskController {

    private final TaskEntryRepository repo;
    private final TaskService service;

    @GetMapping
    public List<TaskEntry> getAllTasks() {
        return repo.findAll();
    }

      //Add POST /api/tasks → Create Task
    @PostMapping
    public TaskEntry createTask(@RequestBody TaskEntry task) {
         task.setIsRunning(false);
        task.setTimeTracked(0L);
        return repo.save(task);
    }

    //Add POST /api/tasks/{id}/start and /{id}/stop → Time tracking per task
    @PostMapping("/{id}/start")
    public TaskEntry start(@PathVariable Long id) {
         return service.startTaskById(id);
    }

    @PostMapping("/{id}/stop")
    public TaskEntry stopTask(@PathVariable Long id) {
         return service.stopTaskById(id);
    }



    // @PostMapping("/start")
    // public TaskEntry start(@RequestBody Map<String, String> request) {
    //     return service.startTask(request.get("taskName"));
    // }

    // @PostMapping("/stop")
    // public TaskEntry stop() {
    //     return service.stopTask();
    // }

    @GetMapping("/logs")
    public List<TaskEntry> logs() {
        return service.getAllLogs();
    }
   
    // DELETE /api/tasks/{id} → Delete Task by ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
          repo.deleteById(id);;
    }

}
