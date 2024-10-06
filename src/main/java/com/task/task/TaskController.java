package com.task.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    private List<TaskModel> tasks = new ArrayList<>();

    //GET-listar tareas
    @GetMapping
    public ResponseEntity<List<TaskModel>>getAllTasks(){
        return ResponseEntity.ok(tasks);
    }

    //POST- crear una nueva tarea
    @PostMapping
    public ResponseEntity<List<TaskModel>> createTasks(@RequestBody List<TaskModel> newTasks) {
        tasks.addAll(newTasks);  // Añade todas las tareas recibidas a la lista
        return new ResponseEntity<>(newTasks, HttpStatus.CREATED);
    }

    //PUT - Marcar tarea como completada
    @PutMapping("/{id}/complete")
    public ResponseEntity<TaskModel> completeTask(@PathVariable Long id){
        for(TaskModel task: tasks){
            if(task.getId().equals(id)){
                task.setCompleted(true);
                return ResponseEntity.ok(task);
            }
        }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


