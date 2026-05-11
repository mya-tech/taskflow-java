import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }
    public void addTask(String title, Priority priority){
        Task newTask = new Task(title, priority);
        tasks.add(newTask);
    }
    public void viewTasks(){
        for(int i = 0; i < tasks.size(); i++){
            Task t = tasks.get(i);
            System.out.println(i + ": " + t.title + " [" + t.status + "]" + "->" + t.priority);
        }
    }
    public void moveTask(int index, Status newStatus){
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).moveTo(newStatus);
        }else {
            System.out.println("Invalid index");
        }
    }
    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("tasks.txt");
            for (Task t : tasks){
                writer.write(t.title + "," + t.status + "," + t.priority + "\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error Saving File");
        }
    }
    public void loadFromFile(){
        try{
            File file = new File("tasks.txt");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String parts[] = line.split(",");
                String title = parts[0];
                Status status = Status.valueOf(parts[1]);
                Priority priority = Priority.valueOf(parts[2]);

                Task t = new Task(title, priority);
                t.moveTo(status);
                tasks.add(t);
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("No Saved Tasks Found");
        }
    }
}
