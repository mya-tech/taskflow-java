public class Task {
    String title;
    Status status;
    Priority priority;
    // Constructor
    public Task(String title, Priority priority){
        this.title = title;
        this.status = Status.TODO;
        this.priority = priority;
    }
    public void moveTo(Status newStatus){
        this.status = newStatus;

    }

}
