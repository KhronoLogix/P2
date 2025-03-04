import java.sql.SQLOutput;
import java.util.*;
//Dominic Cruz/ 3/4/25 / P2
public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Task> taskLi = new ArrayList<>();
    public static void main(String[] args) {
        boolean exit = true;
        while (exit) {
            System.out.println("""
                    Please choose an option: 
                    (1) Add a task.
                    (2) Remove a task.
                    (3) Update a task.
                    (4) List all tasks.
                    (5) List by priority
                    (0) Exit.
                    """);
            int userIntInput = input.nextInt();
            input.nextLine();
            if (userIntInput == 1) {
                add();
            } else if (userIntInput == 2) {
                remove();
            } else if (userIntInput == 3) {
                update();
            } else if (userIntInput == 4) {
                lal();
            } else if (userIntInput == 5){
                lbp();
            } else if (userIntInput == 0) {
                System.out.println("k bye");
                exit = false;
            } else{
                System.out.println("what are you yapping about bruh");
            }
        }
    }
    static void add() {
        System.out.println("Whats the Name of your task?: ");
        String name = input.next();
        input.nextLine();
        System.out.println("Whats the Description of your task?: ");
        String desc = input.next();
        input.nextLine();
        System.out.println("What is your task's Priority? 0-5: ");
        boolean cat = true;
        int prio = 0;
        while (cat) {
            prio = input.nextInt();
            input.nextLine();
            if (prio == 0) {
                System.out.println("Lowest priority");
                cat = false;
            } else if (prio == 1) {
                System.out.println("Lower priority");
                cat = false;
            } else if (prio == 2) {
                System.out.println("Low priority");
                cat = false;
            } else if (prio == 3) {
                System.out.println("High priority");
                cat = false;
            } else if (prio == 4) {
                System.out.println("Higher priority");
                cat = false;
            } else if (prio == 5) {
                System.out.println("Highest priority");
                cat = false;
            } else {
                System.out.println("i said 0-5 that means 0-5");
            }
        }
        Task newTask = new Task(name, desc, prio);
        taskLi.add(newTask);
    }

    static void remove() {
        boolean cat = true;
        int index = 0;
        while (cat) {
            index = input.nextInt();
            input.nextLine();
            if (index > taskLi.size()) {
                System.out.println("what task number would you like to remove?");
                taskLi.remove(index);
                cat = false;
            } else {
                System.out.println("that task doesn't exist");
            }
        }
    }

    static void update() {
        boolean cat = true;
        if (taskLi.isEmpty()) {
            System.out.println("No tasks available to update.");
            return;
        }
        int index = 0;
        while ( cat) {
            System.out.println("Enter the task number to update (starting from 0): ");
            index = input.nextInt();
            input.nextLine();
            if (index < 0 || index >= taskLi.size()) {
                System.out.println("Invalid task number.");
            }
        }
        Task task = taskLi.get(index);

        System.out.println("Updating task: " + task.getName());
        System.out.println("Enter new name (or press Enter to keep '" + task.getName() + "'):");
        String newName = input.nextLine();
        if (!newName.isEmpty()) {
            task.setName(newName);
        }

        System.out.println("Enter new description (or press Enter to keep '" + task.getDesc() + "'):");
        String newDesc = input.nextLine();
        if (!newDesc.isEmpty()) {
            task.setDesc(newDesc);
        }

        System.out.println("Enter new priority (0-5) or -1 to keep " + task.getPrio() + ":");
        int newPrio = input.nextInt();
        input.nextLine();
        try {
            if (newPrio >= 0 && newPrio <= 5) {
                task.setPrio(newPrio);
            } else {
                System.out.println("Keeping current priority.");
            }
        }catch(InputMismatchException e){
            System.out.println("nah uh");
        }

        System.out.println("Task updated successfully!");
    }
    static void lal(){
        for (Task tasks : taskLi) {
            tasks.displayTask();
        }
    }
    static void lbp(){
        System.out.println("what priority would you like to see?");
        int prio = input.nextInt();
        input.nextLine();
        if(prio > 0 && prio<5){
            for(Task tasks : taskLi){
                if(tasks.getPrio() == prio){
                    tasks.displayTask();
                }
            }
        }
    }
}
