package project.types;

public class Subtask extends Epic {
    private int id;
    private int epicId;
    public Epic epic;

    public Subtask(String title, String description, Epic epic, Status status) {
        super(title, description, status);
        this.epic = epic;
        epicId = epic.getId();
        this.status = status;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        epic.subtaskNumber++;
        String hash = "3";
        hash += epicId * 10;
        hash += epic.subtaskNumber;
        return Integer.parseInt(hash);
    }

    public String toString() {
        return "taskmanager.taskstypes.Subtask{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
