package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import project.types.Status;
import project.types.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task = new Task("1", "11", Status.NEW);

    @Test
    void getId() {
        assertEquals(task.getId(), task.getId());
    }
}