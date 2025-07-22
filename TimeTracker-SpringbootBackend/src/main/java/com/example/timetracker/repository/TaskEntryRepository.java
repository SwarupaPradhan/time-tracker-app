package com.example.timetracker.repository;

import com.example.timetracker.model.TaskEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntryRepository extends JpaRepository<TaskEntry, Long> {
}
