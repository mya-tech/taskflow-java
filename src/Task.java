public class Task {
    String title;
    Status status;

    // Constructor
    public Task(String title){
        this.title = title;
        this.status = Status.TODO;
    }
    public void moveTo(Status newStatus){
        this.status = newStatus;

    }

}
