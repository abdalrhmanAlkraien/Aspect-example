package com.example.logger.springlogger.controller;

import com.example.logger.springlogger.service.TaskService;
import com.example.logger.springlogger.service.impl.TaskServiceImp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskServiceImp taskService){
        this.taskService=taskService;
    }

    @GetMapping
    @ApiOperation(value = "Get all tasks")
    public void getTask(){
        taskService.getTask();
    }

    @PostMapping
    @ApiOperation(value = "save new task")
    public String saveTask(){
        return taskService.saveTask();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get one task by id")
    public String getTaskById(@ApiParam(value = "1",required = true, example = "123") @PathVariable("id") Long id) throws Exception {
        return taskService.getTaskById(id);
    }

    @PutMapping
    @ApiOperation(value = "update any task")
    public String updateTask(){
        return taskService.updateTask();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete task by id")
    public String deleteTaskById(@ApiParam(value = "1",required = true, example = "123") @PathVariable("id") Long id) throws Exception {
        return taskService.deleteTaskById(id);
    }
}
