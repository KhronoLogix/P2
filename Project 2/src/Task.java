
public class Task {
    private String name;
    private String desc;
    private int prio;

    public Task(String name, String desc, int prio) {
        this.name = name;
        this.desc = desc;
        this.prio = prio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", prio=" + prio +
                '}';
    }
    public void displayTask(){
        System.out.println("Task Name: " + this.name + "\n Task Description: " + this.desc + "\n Task Priority: " + this.prio);
    }
}
