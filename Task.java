import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Task {
    private String name;
    private Date dueDate;

    public Task(String name, Date dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public static Task createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter due date (MM/dd/yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dueDate = null;
        try {
            dueDate = dateFormat.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Task not created.");
        }
        return new Task(name, dueDate);
    }
}

