import java.util.Scanner;

public class Dude {
    private Scanner scanner;
    private String input;
    private String line = "____________________________________________________________";
    private String botName = "Dude";
    private Task[] tasks;
    private int taskPointer;

    public Dude(){
        this.scanner = new Scanner(System.in);
        input = "";
        tasks = new Task[100];
        taskPointer = 0;
    }

    public void start(){
        System.out.println(line);
        System.out.println("Hello! I'm " + botName);
        System.out.println("What can I do for you?");
        System.out.println(line);

        readAndReact();
    }

    public void readAndReact(){
        input = scanner.nextLine();
        String[] splitInput = input.split(" ", 2);

        if(splitInput[0].equals("bye")){
            exit();
            return;
        }
        else if(splitInput[0].equals("list")){
            list();
        }
        else if(splitInput[0].equals("mark")){
            mark(Integer.parseInt(splitInput[1]));
        }
        else if(splitInput[0].equals("unmark")){
            unmark(Integer.parseInt(splitInput[1]));
        }
        else{
            addTask(splitInput[0], splitInput[1]);
        }

        readAndReact();
    }

    public void addTask(String taskType, String taskDes){
        Task newTask = null;
        if(taskType.equals("todo")){
            newTask = new ToDo(taskDes);
        }
        else if(taskType.equals("deadline")){
            String[] splitDes = taskDes.split("/", 2);
            String[] splitBy = splitDes[1].split(" ", 2);
            newTask = new Deadline(splitDes[0], splitBy[1]);
        }
        else if(taskType.equals("event")){
            String[] splitDes = taskDes.split("/", 3);
            String[] splitFrom = splitDes[1].split(" ", 2);
            String[] splitTo = splitDes[2].split(" ", 2);
            newTask = new Event(splitDes[0], splitFrom[1], splitTo[1]);
        }

        this.tasks[taskPointer] = newTask;
        taskPointer++;

        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(newTask);
        System.out.println("Now you have " + taskPointer + " tasks in the list.");
        System.out.println(line);
    }

    public void list(){
        System.out.println(line);
        System.out.println("Here are the tasks in your list:");

        for(int i = 1; i <= taskPointer; i ++){
            System.out.println(i + "." + tasks[i - 1]);
        }

        System.out.println(line);
    }

    public void mark(int index){
        Task task = tasks[index - 1];
        task.markAsDone();

        System.out.println(line);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
        System.out.println(line);
    }

    public void unmark(int index){
        Task task = tasks[index - 1];
        task.markAsNotDone();

        System.out.println(line);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task);
        System.out.println(line);
    }

    public void exit(){
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);

        scanner.close();
    }

    public static void main(String[] args) {
        Dude dude = new Dude();
        dude.start();
    }
}
