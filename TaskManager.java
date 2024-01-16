import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task{
  private String name;
  private String dueDate;

  public Task(String Name, String DueDate){
    this.name = Name;
    this.dueDate = DueDate;
  }
  public String getName(){
    return name;
}
  public String getDueDate(){
    return dueDate;
  }
}

public class TaskManager{
   private static ArrayList<Task> tasks = new ArrayList<>();
   private static Scanner scanner = new Scanner(System.in);
   public static void main(String[] args) {
     boolean exit = false;

    while (!exit){
      System.out.println("1. Add a Task");
      System.out.println("2. List all Tasks");
      System.out.println("3. Mark a Task as Completed");
      System.out.println("4. Exit");
      System.out.print("Enter your choice:");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice){
        case 1:
          addTask();
          break;
        case 2:
          listTasks();
          break;
        case 3:
          deleteTask();
          break;
        case 4:
          exit = true;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
  
    }
}
    System.out.println("Closing the Task Manager.");

  }
  private static void addTask(){
    System.out.print("Enter the task name:");
    String name = scanner.nextLine();
    System.out.print("Enter the due date (YYYY-MM-DD):");
    String dueDate = scanner.nextLine();
    Task task = new Task(name, dueDate);
    tasks.add(task);
    System.out.println("Task added successfully.");
  }
  private static void listTasks(){
    if (tasks.isEmpty()){
      System.out.println("No tasks found.");
      return;
    }

    Collections.sort(tasks,Comparator.comparing(Task::getDueDate));
    System.out.println("Tasks:");

    for (Task task : tasks){
      System.out.println("Name: " + task.getName() + ", Due Date: " + task.getDueDate());
    }
  }

  private static void deleteTask(){
    listTasks();

    if (tasks.isEmpty()){
      return;
    }

    System.out.print("Enter the name of the task you would like to delete: ");
    String taskName = scanner.nextLine();

    for (Task task : tasks){
      if (task.getName().equalsIgnoreCase(taskName)){
        tasks.remove(task);
        System.out.println("Task deleted successfully.");
        return;
      }
    }
    System.out.println("Task not found.");
  }
}
  