package com.huynhntp.todobe.repository;

import com.huynhntp.todobe.entity.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, String> {

    TaskGroup findByDate(LocalDate date);

}
