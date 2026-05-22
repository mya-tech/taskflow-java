package com.mya.taskflow.tester;

import com.mya.taskflow.controllers.TaskManager;
import com.mya.taskflow.model.Priority;
import com.mya.taskflow.model.Status;
import com.mya.taskflow.views.TaskManagerViews;

import java.time.LocalDate;
import java.util.Scanner;

public class Tester {
  static void main(String[] args){
            Scanner input = new Scanner(System.in);
            TaskManager manager = new TaskManager();
            TaskManagerViews managerViews = new TaskManagerViews();
            manager.loadFromFile();

            while(true){
                managerViews.displayMenu();
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1){
                    System.out.println("Enter task Title: ");
                    String title = input.nextLine();
                    managerViews.displayPriorityLevelMenu();
                    int priorityChoice = input.nextInt();
                    input.nextLine();
                    Priority priority = Priority.values()[priorityChoice];
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(input.nextLine());
                    manager.addTask(title,priority, dueDate);
                }else if (choice == 2){
                    manager.viewTasks();
                }else if (choice == 3){
                    System.out.println("Enter task Index: ");
                    int id = input.nextInt();
                    System.out.println("Select Status: ");
                    System.out.println("0. TO-DO");
                    System.out.println("1. DOING");
                    System.out.println("2. DONE");
                    int statusChoice = input.nextInt();

                    Status newStatus = Status.values()[statusChoice];
                    manager.moveTask(id,newStatus);
                }else if (choice == 4){
                    System.out.println("Enter task Index: ");
                    int id = input.nextInt();
                    System.out.println("Choose Priority Level: ");
                    System.out.println("0. LOW");
                    System.out.println("1. MEDIUM");
                    System.out.println("2. HIGH");
                    int priorityChoice = input.nextInt();
                    Priority priority = Priority.values()[priorityChoice];
                    manager.movePriority(id,priority);
                }else if(choice == 5){
                    manager.saveToFile();
                    break;
                }
            }
        }
}
