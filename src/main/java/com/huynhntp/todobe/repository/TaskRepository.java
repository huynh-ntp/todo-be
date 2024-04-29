package com.huynhntp.todobe.repository;

import com.huynhntp.todobe.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    List<Task> findByTaskGroupId(String taskGroupId);

}
