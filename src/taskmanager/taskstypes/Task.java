package taskmanager.taskstypes;

import java.util.Objects;

public class Task {
    static int taskNumber = 0;
    public String title;
    public String description;
    private int id;
    public Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status;

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        taskNumber++;
        String hash = "10";
        hash += taskNumber;
        return Integer.parseInt(hash);
    }

    @Override
    public String toString() {
        return "taskmanager.taskstypes.Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
