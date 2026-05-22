package com.mya.taskflow.controllers;

import com.mya.taskflow.model.Priority;
import com.mya.taskflow.model.Status;
import com.mya.taskflow.model.Task;
import com.mya.taskflow.services.TaskManagerServices;
import com.mya.taskflow.storage.FileHandler;
import com.mya.taskflow.views.Menu;
import com.mya.taskflow.views.Messages;

import java.util.ArrayList;

import java.util.Scanner;

public class TaskManager {
    FileHandler file = new FileHandler();
    Messages message = new Messages();
    Menu menu = new Menu();
    TaskManagerServices manager = new TaskManagerServices();

    ArrayList<Task> tasks = manager.getTasks();


    public void runApplication() {
        file.loadFromFile(tasks);
        while(true) {
            menu.displayMenu();
            int choice = manager.getValidMenuItem("Enter a number for your Selection: ", 5);
            switch (choice) {
                case 1:
                    handleCreateTask();
                    break;
                case 2:
                    handleViewTasks();
                    break;
                case 3:
                    handleChangeStatus();
                    break;
                case 4:
                    handleChangePriority();
                    break;
                case 5:
                    handleExit();
                    return;
                default:
                    message.displayError("Invalid choice");
            }
        }
    }
    private int getValidMenuChoice(int maxOptions) {
        return manager.getValidMenuItem("Enter your choice: ", maxOptions);
    }

    private void handleCreateTask() {
        manager.createTask();
    }

    private void handleViewTasks() {
        manager.viewTasks();
    }
    private void handleChangeStatus() {
        if (manager.getTasks().isEmpty()) {
            message.displayError("No tasks available");
            return;
        }
        manager.viewTasks();
        int taskIndex = manager.getValidTask("Enter Task Index: ");

        menu.displayStatusMenu();
        int statusChoice = getValidMenuChoice(Status.values().length);

        Status newStatus = Status.values()[statusChoice];
        manager.moveTask(taskIndex, newStatus);
        message.displaySuccess("Task status updated");
    }

    private void handleChangePriority() {
        if (manager.getTasks().isEmpty()) {
            message.displayError("No tasks available");
            return;
        }

        manager.viewTasks();
        int taskIndex = manager.getValidTask("Enter Task Index: ");

        menu.displayPriorityLevelMenu();
        int priorityChoice = getValidMenuChoice(Priority.values().length);

        Priority newPriority = Priority.values()[priorityChoice];
        manager.movePriority(taskIndex, newPriority);
        message.displaySuccess("Task priority updated");
    }

    private void handleExit() {
        file.saveToFile(manager.getTasks());
        message.displaySuccess("Exiting application");
    }
}