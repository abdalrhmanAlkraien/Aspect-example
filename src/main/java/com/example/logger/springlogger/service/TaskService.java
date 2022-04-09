package com.example.logger.springlogger.service;

public interface TaskService {

    String getTask();
    String saveTask();
    String getTaskById(Long id) throws Exception;
    String updateTask();
    String deleteTaskById(Long id) throws Exception;

}
