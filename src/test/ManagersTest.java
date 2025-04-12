package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.managers.Managers;
import project.managers.TaskManager;
import project.types.Epic;
import project.types.Status;
import project.types.Subtask;
import project.types.Task;

class ManagersTest {

    static Managers managers = new Managers();
    static TaskManager newTaskManager = managers.getDefault();


    @BeforeEach
    void beforeEach() {
        Task task = new Task("1", "11", Status.NEW);
        Epic epic = new Epic("2", "22", Status.NEW);
        Subtask sub = new Subtask("3", "33", epic, Status.IN_PROGRESS);
        newTaskManager.addNewTask(task);
        newTaskManager.addNewEpic(epic);
        newTaskManager.addNewSubtask(sub);

    }

    @Test
    void returnReadyToWorkClass() {

        String test1 = newTaskManager.getTaskById(101).toString();
        Assertions.assertEquals("taskmanager.taskstypes.Task{title='1', description='11', id=101, status=NEW}", test1);
    }

    @Test
    void workWithDiffClasses() {
        String test1 = newTaskManager.getTaskById(101).toString();
        String test2 = newTaskManager.getEpicById(201).toString();
        String test3 = newTaskManager.getSubtaskById(301).toString();
        Assertions.assertEquals("taskmanager.taskstypes.Task{title='1', description='11', id=101, status=NEW}", test1);
        Assertions.assertEquals("taskmanager.taskstypes.Epic{title='2', description='22', id=201, status=NEW}", test2);
        Assertions.assertEquals("taskmanager.taskstypes.Subtask{title='3', description='33', id=301, status=IN_PROGRESS}", test3);
    }

    @Test
    void confGenHashWithSetHash() {
        Task task = new Task("1", "11", Status.NEW);
        Task task2 = new Task("1","11", Status.NEW);
        task2.setId(1277);
        Assertions.assertFalse(task.equals(task2));

    }

    @Test
    void taskStayStatic() {
        String test1 = newTaskManager.getTaskById(101).title;
        Assertions.assertEquals("1", test1);
    }

}