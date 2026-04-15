package edu.cmu.cs.cs214.rec02;

import java.util.Arrays;

public class ArrayIntQueue implements IntQueue {

    // Queue-д ашиглах массив
    private int[] elementData;

    // Queue-ийн эхний элемент (dequeue хийх байр)
    private int head;

    // Одоогийн элементүүдийн тоо
    private int size;

    private static final int INITIAL_SIZE = 10;

    // Конструктор
    public ArrayIntQueue() {
        elementData = new int[INITIAL_SIZE];
        head = 0;
        size = 0;
    }

    // Queue-г цэвэрлэх
    public void clear() {
        Arrays.fill(elementData, 0); // массивыг 0 болгоно
        size = 0;   // элемент байхгүй
        head = 0;   // эхлэл буцаана
    }

    // Элемент гаргах (FIFO)
    public Integer dequeue() {

        // Хоосон бол null буцаана
        if (isEmpty()) {
            return null;
        }

        // head дээрх утгыг авна
        Integer value = elementData[head];

        // head-ийг дараагийн байр руу шилжүүлнэ (circular)
        head = (head + 1) % elementData.length;

        // size багасна
        size--;

        return value;
    }

    // Элемент нэмэх
    public boolean enqueue(Integer value) {

        // Хэрвээ дүүрсэн бол capacity нэмнэ
        ensureCapacity();

        // tail = дараагийн нэмэх индекс
        int tail = (head + size) % elementData.length;

        // утга хадгална
        elementData[tail] = value;

        // size нэмэгдэнэ
        size++;

        return true;
    }

    // ❗ ЗАСВАР: зөв хоосон шалгалт
    public boolean isEmpty() {
        return size == 0;
    }

    // ❗ ЗАСВАР: хоосон үед null
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData[head];
    }

    // Одоогийн size
    public int size() {
        return size;
    }

    // ❗ ЗАСВАР: зөв copy хийдэг болгов
    private void ensureCapacity() {

        if (size == elementData.length) {

            int oldCapacity = elementData.length;
            int newCapacity = 2 * oldCapacity + 1;

            int[] newData = new int[newCapacity];

            // 🔥 ЗӨВ COPY (дарааллаар)
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[(head + i) % oldCapacity];
            }

            // шинэ массив руу шилжүүлнэ
            elementData = newData;

            // head-г 0 болгоно (straight array боллоо)
            head = 0;
        }
    }
}            head = 0;
        }
    }
}
