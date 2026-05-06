import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        manager.loadFromFile();

        while(true){
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task Done");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1){
                System.out.println("Enter task Title: ");
                String title = input.nextLine();
                manager.addTask(title);
            }else if (choice == 2){
                manager.viewTasks();
            }else if (choice == 3){
                System.out.println("Enter task Index: ");
                int id = input.nextInt();
                manager.markTaskAsDone(id);
            }else if(choice == 4){
                manager.saveToFile();
                break;
            }
        }
    }
}