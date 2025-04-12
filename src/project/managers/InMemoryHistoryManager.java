package project.managers;

import project.types.Task;

import java.util.Arrays;

public class InMemoryHistoryManager implements HistoryManager{

    public int[] history = new int[10];

    @Override
    public void add(Task task) {
        for (int i = 9; i > 0; i--) {
            history[i] = history[i - 1];
        }
        history[0] = task.getId();
    }

    @Override
    public int[] getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "InMemoryHistoryManager{" +
                "history=" + Arrays.toString(history) +
                '}';
    }


}
