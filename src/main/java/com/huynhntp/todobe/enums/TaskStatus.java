package com.huynhntp.todobe.enums;

import java.util.stream.Stream;

public enum TaskStatus {
    NEW("NEW"),
    FINISHED("FINISHED"),
    REMOVED("REMOVED");

    private String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() {
        return this.taskStatus;
    }

    public static TaskStatus of(String taskStatus) {
        return Stream.of(TaskStatus.values())
                .filter(x -> x.getTaskStatus().equals(taskStatus))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
