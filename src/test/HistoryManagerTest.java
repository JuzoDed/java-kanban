package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.managers.HistoryManager;
import project.managers.InMemoryTaskManager;
import project.types.Epic;
import project.types.Status;
import project.types.Task;

class HistoryManagerTest {


    InMemoryTaskManager taskManager = new InMemoryTaskManager();
    HistoryManager manager = taskManager.historyManager;
    Task task = new Task("1", "11", Status.NEW);
    Epic epic = new Epic("2", "22", Status.NEW);

    @Test
    void history() {
        taskManager.addNewTask(task);
        taskManager.addNewEpic(epic);
        taskManager.getTaskById(101);
        taskManager.getEpicById(201);
        int[] test1 = {201, 101, 0};
        int[] test2 = manager.getHistory();
        Assertions.assertEquals(test1[0], test2[0]);
        Assertions.assertEquals(test1[1], test2[1]);
        Assertions.assertEquals(test1[2], test2[2]);

    }



}