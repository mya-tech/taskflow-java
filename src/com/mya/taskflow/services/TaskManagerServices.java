package com.mya.taskflow.services;

import com.mya.taskflow.model.Priority;
import com.mya.taskflow.model.Status;
import com.mya.taskflow.model.Task;
import com.mya.taskflow.views.Menu;
import com.mya.taskflow.views.Messages;
import com.mya.taskflow.views.TaskView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagerServices {

    private ArrayList<Task> tasks;
    private Messages message;
    private Menu menu;
    private TaskView taskView;
    private Scanner input;

    public TaskManagerServices() {
        this.tasks = new ArrayList<>();
        this.message = new Messages();
        this.menu = new Menu();
        this.taskView = new TaskView();
        this.input = new Scanner(System.in);
    }
    // Getter for tasks (needed by controller)
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public int getValidMenuItem(String prompt, int numMenu){
        int id = -1;
        while(id < 0 || id > numMenu){
            message.displayPromptHeader(prompt);
            if(input.hasNextInt()){
                id = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine(); // Clear invalid input
                id = -1;
                message.displayError("Invalid index");
            }
        }
        return id;
    }

        public int getValidTask(String prompt){
            return getValidMenuItem(prompt, tasks.size());

        }

        public void createTask(){
            try{
                String title = getTaskTitle();
                Priority priority = getTaskPriority();
                LocalDate dueDate = getTaskDueDate();

                Task newTask = new Task(title, priority, dueDate);
                tasks.add(newTask);
                message.displaySuccess("Task Added");
            }catch(Exception e){
                message.displayError("Creating Task - " + e.getMessage());
            }
        }

        public void viewTasks(){
            if(tasks.isEmpty()){
                message.displayTitle("No Task Found");
                return;
            }
            for(int i = 0; i < tasks.size(); i++){
                taskView.displayTasks(i, tasks.get(i));
            }
        }
        public void moveTask(int index, Status newStatus){
            if (isValidIndex(index)){
                tasks.get(index).moveTo(newStatus);
            }else {
                message.displayError("Invalid index");
            }
        }
        public void movePriority(int index, Priority newPriority){
            if (isValidIndex(index)){
                tasks.get(index).changePriority(newPriority);
            }else {
                message.displayError("Invalid index");
            }
        }
        public void changeDueDate(int index, LocalDate dueDate){
            if (isValidIndex(index)){
                tasks.get(index).setDueDate(dueDate);
        }else {
                message.displayError("Invalid index");
        }
        }
        private String getTaskTitle() {
            message.displayPromptHeader("Enter Task Title: ");
            return input.nextLine();
        }

        private Priority getTaskPriority() {
            menu.displayPriorityLevelMenu();
            int priorityChoice = getValidMenuItem("Choose Priority Level: ", Priority.values().length);
            return Priority.values()[priorityChoice];
        }

        private LocalDate getTaskDueDate() throws DateTimeParseException {
            message.displayPromptHeader("Enter due date (YYYY-MM-DD): ");
            return LocalDate.parse(input.nextLine());
        }
        private boolean isValidIndex(int index) {
            return index >= 0 && index < tasks.size();
        }

    }


