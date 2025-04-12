package project.managers;

import project.types.Epic;
import project.types.Subtask;
import project.types.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    public static HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public HistoryManager historyManager = new InMemoryHistoryManager();

    @Override
    public void addNewTask(Task newTask) {
        Task task = new Task(newTask.title, newTask.description, newTask.status);
        task.setId(task.hashCode());
        tasks.put(task.getId(), task);
    }

    @Override
    public void addNewEpic(Epic newEpic) {
        Epic epic = new Epic(newEpic.title, newEpic.description, newEpic.status);
        epic.setId(epic.hashCode());
        epics.put(epic.getId(), epic);
    }

    @Override
    public void addNewSubtask(Subtask newSubtask) {
        Subtask subtask = new Subtask(newSubtask.title, newSubtask.description, newSubtask.epic, newSubtask.status);
        subtask.setId(subtask.hashCode());
        subtasks.put(subtask.getId(), subtask);
        for (Integer i : epics.keySet()) {
            epics.get(i).statusChek();
        }

    }

    @Override
    public HashMap<Integer, Task> getTasks() {
        System.out.println(tasks.values() + "\n");
        return tasks;
    }

    @Override
    public void claenTasks() {
        tasks.clear();
    }

    @Override
    public Task getTaskById(int id) {
        historyManager.add(tasks.get(id));
        return tasks.get(id);
    }

    @Override
    public void updateTask(int id, Task task) {
        tasks.put(id, task);
    }

    @Override
    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    @Override
    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    @Override
    public void claenEpics() {
        epics.clear();
        subtasks.clear();
    }

    @Override
    public Epic getEpicById(int id) {
        historyManager.add(epics.get(id));
        return epics.get(id);
    }

    @Override
    public void updateEpic(int id, Epic epic) {
        epics.put(id, epic);
    }

    @Override
    public void deleteEpicById(int id) {
        int subtaskNeedToDel = epics.get(id).subtaskNumber;
        for (int i = 1; i < subtaskNeedToDel + 1; i++) {
            String hash = "3" + id + "0" + i;
            subtasks.remove(Integer.parseInt(hash));
        }
        epics.remove(id);
    }

    @Override
    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public void claenSubtasks() {
        subtasks.clear();
        for (Integer i : epics.keySet()) {
            epics.get(i).statusChek();
        }
    }

    @Override
    public Subtask getSubtaskById(int id) {
        historyManager.add(subtasks.get(id));
        return subtasks.get(id);
    }

    @Override
    public void updateSubtask(int id, Subtask subtask) {
        subtasks.put(id, subtask);
        for (Integer i : epics.keySet()) {
            epics.get(i).statusChek();
        }
    }

    @Override
    public void deleteSubtaskById(int id) {
        subtasks.remove(id);
        for (Integer i : epics.keySet()) {
            epics.get(i).statusChek();
        }
    }

    @Override
    public ArrayList<Subtask> getSubtasksByEpic(int id) {
        ArrayList<Subtask> subtasksByEpic = new ArrayList<>();
        int subtaskAtEpic = epics.get(id).subtaskNumber;
        for (int i = 1; i < subtaskAtEpic + 1; i++) {
            String hash = "3" + id + "0" + i;
            subtasksByEpic.add(subtasks.get(Integer.parseInt(hash)));
        }
        return subtasksByEpic;
    }
}
