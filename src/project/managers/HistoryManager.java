package project.managers;

import project.types.Task;

public interface HistoryManager {

    void add(Task task);

    int[] getHistory();
}
