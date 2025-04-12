package project.managers;

public class Managers {

    static HistoryManager getDefaultHistory() {
        InMemoryHistoryManager newHistoryManager = new InMemoryHistoryManager();
        return newHistoryManager;
    }

    public Managers() {

    }

    public TaskManager getDefault() {
        TaskManager newManager = new InMemoryTaskManager();
        return newManager;
    }
}
