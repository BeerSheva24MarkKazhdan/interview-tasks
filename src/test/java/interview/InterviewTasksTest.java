package interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.interview.InterviewTasks;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int[] array = {1, 3, 5, 7};
        int sum = 8;

        assertTrue(InterviewTasks.hasSumTwo(array, sum));
        assertFalse(InterviewTasks.hasSumTwo(array, 15));
        assertFalse(InterviewTasks.hasSumTwo(new int[]{}, 5)); 
        assertFalse(InterviewTasks.hasSumTwo(new int[]{1}, 1)); 
    }
}