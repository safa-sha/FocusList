import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean isDone;

    Task(String name) {
        this.name = name;
        this.isDone = false;
    }
}

public class TodoApp {

    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== FOCUS LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String taskName = sc.nextLine();
                    tasks.add(new Task(taskName));
                    System.out.println("Task added!");
                    break;

                case 2:
                    System.out.println("\nYour Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.isDone ? "[✔]" : "[ ]";
                            System.out.println((i + 1) + ". " + status + " " + t.name);
                        }
                    }
                    break;

                case 3:
                     if (tasks.isEmpty()) {
                         System.out.println("No tasks to mark!");
                         break;
                     }

                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        String status = t.isDone ? "[✔]" : "[ ]";
                         System.out.println((i + 1) + ". " + status + " " + t.name);
                     }

                     System.out.print("Enter task number to mark done: ");
                     int doneIndex = sc.nextInt();

                     if (doneIndex > 0 && doneIndex <= tasks.size()) {
                        tasks.get(doneIndex - 1).isDone = true;
                        System.out.println("Task marked as done!");
                     } else {
                     System.out.println("Invalid task number!");
                 }
                 break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int delIndex = sc.nextInt();
                    if (delIndex > 0 && delIndex <= tasks.size()) {
                        tasks.remove(delIndex - 1);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Bye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}