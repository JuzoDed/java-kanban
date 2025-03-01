import java.util.ArrayList;

public class Epic extends Task {
    static int epicNumber = 0;
    protected int subtaskNumber;
    private int id;

    public Epic(String title, String description, Status status) {
        super(title, description, status);
        subtaskNumber = 0;
        status = Status.NEW;
    }

    public void statusChek() {
        int newTask = 0;
        int inProgress = 0;
        int done = 0;
        for (int i = 1; i < subtaskNumber + 1; i++) {
            String hash = "3" + id + "0" + i;
            if (TaskManager.subtasks.get(Integer.parseInt(hash)).status == Status.NEW) {
                newTask++;
            } else if (TaskManager.subtasks.get(Integer.parseInt(hash)).status == Status.IN_PROGRESS) {
                inProgress++;
            } else if (TaskManager.subtasks.get(Integer.parseInt(hash)).status == Status.DONE) {
                done++;
            }
        }
        if (done == subtaskNumber) status = Status.DONE;
        else if (inProgress > 0) status = Status.IN_PROGRESS;
        else status = Status.NEW;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public static int getEpicNumber() {
        return epicNumber;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        epicNumber++;
        String hash = "20";
        hash += epicNumber;
        return Integer.parseInt(hash);
    }

    public String toString() {
        return "Epic{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
