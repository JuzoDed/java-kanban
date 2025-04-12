package project.managers;

import project.types.Epic;
import project.types.Subtask;
import project.types.Task;

import java.util.ArrayList;
import java.util.HashMap;

public interface TaskManager {

    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();

    public static HashMap<Integer, Subtask> subtasks = new HashMap<>();

    void addNewTask(Task newTask);

    void addNewEpic(Epic newEpic);

    void addNewSubtask(Subtask newSubtask);

    HashMap<Integer, Task> getTasks();

    void claenTasks();

    Task getTaskById(int id);

    void updateTask(int id, Task task);

    void deleteTaskById(int id);

    HashMap<Integer, Epic> getEpics();

    void claenEpics();

    Epic getEpicById(int id);

    void updateEpic(int id, Epic epic);

    void deleteEpicById(int id);

    HashMap<Integer, Subtask> getSubtasks();

    void claenSubtasks();

    Subtask getSubtaskById(int id);

    void updateSubtask(int id, Subtask subtask);

    void deleteSubtaskById(int id);

    ArrayList<Subtask> getSubtasksByEpic(int id);

}


