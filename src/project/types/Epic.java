package project.types;
import project.managers.InMemoryTaskManager;

public class Epic extends Task {
    static int epicNumber = 0;
    public int subtaskNumber;
    private int id;

    public Epic(String title, String description, Status status) {
        super(title, description, status);
        subtaskNumber = 0;
        this.status = status;
    }

    public void statusChek() {
        int newTask = 0;
        int inProgress = 0;
        int done = 0;
        for (int i = 1; i < subtaskNumber + 1; i++) {
            String hash = "3" + id + "0" + i;
            if (InMemoryTaskManager.subtasks.get(Integer.parseInt(hash)).status == Status.NEW) {
                newTask++;
            } else if (InMemoryTaskManager.subtasks.get(Integer.parseInt(hash)).status == Status.IN_PROGRESS) {
                inProgress++;
            } else if (InMemoryTaskManager.subtasks.get(Integer.parseInt(hash)).status == Status.DONE) {
                done++;
            }
        }
        if (done != subtaskNumber) {
            if (inProgress > 0) status = Status.IN_PROGRESS;
            else status = Status.DONE;
        } else {
            status = Status.NEW;
        }
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
        return "taskmanager.taskstypes.Epic{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
