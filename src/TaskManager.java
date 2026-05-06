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
    public void addTask(String title){
        Task newTask = new Task(title);
        tasks.add(newTask);
    }
    public void viewTasks(){
        for(int i = 0; i < tasks.size(); i++){
            Task t = tasks.get(i);
            System.out.println(i + ": " + t.title + " [" + (t.isDone ? "Done" : "Not Done") + "]");
        }
    }
    public void markTaskAsDone(int index){
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).markdown();
        }else{
            System.out.println("Invalid Index");
        }
    }
    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("tasks.txt");
            for (Task t : tasks){
                writer.write(t.title + "," + t.isDone + "\n");
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
                boolean isDone = Boolean.parseBoolean(parts[1]);

                Task t = new Task(title);
                if(isDone){
                    t.markdown();
                }
                tasks.add(t);
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("No Saved Tasks Found");
        }
    }
}
