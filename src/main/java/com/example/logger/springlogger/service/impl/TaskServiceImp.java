package com.example.logger.springlogger.service.impl;

import static com.example.logger.springlogger.aspect.TaskServiceAspect.Loggable;
import com.example.logger.springlogger.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp implements TaskService {

    public  TaskServiceImp(){

    }

    @Override
    public String getTask() {
        return "execute getTask";
    }

    @Override
    public String saveTask() {
        return "execute saveTask";

    }

    @Override
    @Loggable
    public String getTaskById(Long id) throws Exception {
        if(id<1){
            throw new Exception("the id less than 1");
        }
        return "execute getTaskById ".concat(id.toString());
    }

    @Override
    public String updateTask() {
        return "execute updateTask";

    }

    @Override
    @Loggable
    public String deleteTaskById(Long id) throws Exception {
        if(id<1){
            throw new Exception("the id less than 1");
        }
        return "execute deleteTaskById ".concat(id.toString());
    }

}
