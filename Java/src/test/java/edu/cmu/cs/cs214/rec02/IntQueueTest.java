package edu.cmu.cs.cs214.rec02;

import org.junit.Test;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * IntQueueTest — IntQueue интерфэйсийн тест класс.
 */
public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    @Before
    public void setUp() {
        // ✔ Эхлээд LinkedIntQueue дээр тестлэнэ
        IntQueue intQueue = mQueue = new LinkedIntQueue();

        // ✔ Дараа нь ArrayIntQueue болгож солино
        // mQueue = new ArrayIntQueue();

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    // =========================================================

    @Test
    public void testIsEmpty() {
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        mQueue.enqueue(42);
        assertFalse(mQueue.isEmpty());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(mQueue.peek());
    }

    @Test
    public void testPeekNoEmptyQueue() {
        mQueue.enqueue(10);
        mQueue.enqueue(20);
        mQueue.enqueue(30);

        assertEquals(Integer.valueOf(10), mQueue.peek());
        assertEquals(3, mQueue.size());
        assertEquals(Integer.valueOf(10), mQueue.dequeue());
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), mQueue.peek());
            assertEquals(i + 1, mQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        for (Integer val : testList) {
            mQueue.enqueue(val);
        }

        assertEquals(Integer.valueOf(1), mQueue.dequeue());
        assertEquals(Integer.valueOf(2), mQueue.dequeue());
        assertEquals(Integer.valueOf(3), mQueue.dequeue());

        assertTrue(mQueue.isEmpty());
        assertNull(mQueue.dequeue());
    }

    @Test
    public void testContent() throws IOException {
        InputStream in = new FileInputStream("src/test/resources/data.txt");

        try (Scanner scanner = new Scanner(in)) {
            scanner.useDelimiter("\\s*fish\\s*");

            List<Integer> correctResult = new ArrayList<>();

            while (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                correctResult.add(input);
                mQueue.enqueue(input);
            }

            for (Integer result : correctResult) {
                assertEquals(result, mQueue.dequeue()); // ✔ зассан
            }
        }
    }

    // =========================================================
    // НЭМЭЛТ ТЕСТҮҮД (100% coverage)
    // =========================================================

    @Test
    public void testClear() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        mQueue.enqueue(3);

        mQueue.clear();

        assertTrue(mQueue.isEmpty());
        assertEquals(0, mQueue.size());
        assertNull(mQueue.peek());
    }

    @Test
    public void testSize() {
        assertEquals(0, mQueue.size());

        mQueue.enqueue(10);
        assertEquals(1, mQueue.size());

        mQueue.enqueue(20);
        assertEquals(2, mQueue.size());

        mQueue.dequeue();
        assertEquals(1, mQueue.size());

        mQueue.dequeue();
        assertEquals(0, mQueue.size());
    }

    @Test
    public void testEnsureCapacity() {
        // head ≠ 0 болгох
        for (int i = 0; i < 3; i++) mQueue.enqueue(i);
        for (int i = 0; i < 3; i++) mQueue.dequeue();

        // capacity давуулах
        for (int i = 0; i < 11; i++) {
            mQueue.enqueue(i * 10);
        }

        assertEquals(11, mQueue.size());

        for (int i = 0; i < 11; i++) {
            assertEquals(Integer.valueOf(i * 10), mQueue.dequeue());
        }
    }

    @Test
    public void testCircularWraparound() {
        for (int i = 0; i < 7; i++) mQueue.enqueue(i);
        for (int i = 0; i < 7; i++) mQueue.dequeue();

        for (int i = 0; i < 5; i++) mQueue.enqueue(i + 100);

        assertEquals(5, mQueue.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(Integer.valueOf(i + 100), mQueue.dequeue());
        }
    }

    @Test
    public void testEnqueueReturnsTrue() {
        assertTrue(mQueue.enqueue(99));
    }

    @Test
    public void testDequeueFromEmptyQueue() {
        assertNull(mQueue.dequeue());
    }

    @Test
    public void testLargeQueue() {
        int n = 50;

        for (int i = 0; i < n; i++) mQueue.enqueue(i);
        assertEquals(n, mQueue.size());

        for (int i = 0; i < n; i++) {
            assertEquals(Integer.valueOf(i), mQueue.dequeue());
        }

        assertTrue(mQueue.isEmpty());
    }
}
