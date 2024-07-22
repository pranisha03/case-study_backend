package com.example.Task_SpringBoot.services.employee;

import com.example.Task_SpringBoot.dto.CommentDTO;
import com.example.Task_SpringBoot.dto.ProjectDTO;
import com.example.Task_SpringBoot.dto.TaskDTO;

import java.util.List;

public interface EmployeeService {

    List<TaskDTO> getTasksByUserId();

    TaskDTO updateTask(Long id, String status);

    TaskDTO getTaskById(Long id);

    CommentDTO createComment(Long taskId, String content);

    List<CommentDTO> getCommentsByTaskId(Long taskId);

    List<ProjectDTO> getProjectsByUserId(); // New method

    List<TaskDTO> getTasksByProjectId(Long projectId);
}