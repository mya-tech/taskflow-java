public class Task {
    String title;
    boolean isDone;

    // Constructor
    public Task(String title){
        this.title = title;
        this.isDone = false;
    }
    public void markdown(){
        this.isDone = true;
    }
}
