package edu.cmu.cs.cs214.rec02;

/**
 * Бүхэл тоон (Integer) өгөгдөл хадгалах дарааллын (Queue) интерфэйс.
 *
 * FIFO зарчимтай:
 * 👉 Эхэлж орсон элемент → эхэлж гарна
 *
 * Queue нь өгөгдлийг дарааллаар боловсруулахад ашиглагддаг.
 */
public interface IntQueue {

    /**
     * Queue доторх бүх элементийг устгана.
     * 👉 clear хийсний дараа size = 0 болно.
     */
    void clear();

    /**
     * Queue-ийн эхний элементийг авч, устгана.
     *
     * @return
     * 👉 Эхний элемент
     * 👉 Хэрвээ queue хоосон бол null буцаана
     */
    Integer dequeue();

    /**
     * Queue-ийн сүүл хэсэгт шинэ элемент нэмнэ.
     *
     * @param value
     * 👉 Нэмэх утга
     *
     * @return
     * 👉 Амжилттай нэмсэн бол true
     */
    boolean enqueue(Integer value);

    /**
     * Queue хоосон эсэхийг шалгана.
     *
     * @return
     * 👉 Хоосон бол true
     * 👉 Элемент байвал false
     */
    boolean isEmpty();

    /**
     * Queue-ийн эхний элементийг харна.
     * ⚠️ Гэхдээ устгахгүй!
     *
     * @return
     * 👉 Эхний элемент
     * 👉 Хоосон бол null
     */
    Integer peek();

    /**
     * Queue-д байгаа элементүүдийн тоог буцаана.
     *
     * @return
     * 👉 Элементийн тоо
     */
    int size();
}package edu.cmu.cs.cs214.rec02;

/**
 * Бүхэл тоон (Integer) өгөгдөл хадгалах дарааллын (Queue) интерфэйс.
 *
 * FIFO зарчимтай:
 * 👉 Эхэлж орсон элемент → эхэлж гарна
 *
 * Queue нь өгөгдлийг дарааллаар боловсруулахад ашиглагддаг.
 */
public interface IntQueue {

    /**
     * Queue доторх бүх элементийг устгана.
     * 👉 clear хийсний дараа size = 0 болно.
     */
    void clear();

    /**
     * Queue-ийн эхний элементийг авч, устгана.
     *
     * @return
     * 👉 Эхний элемент
     * 👉 Хэрвээ queue хоосон бол null буцаана
     */
    Integer dequeue();

    /**
     * Queue-ийн сүүл хэсэгт шинэ элемент нэмнэ.
     *
     * @param value
     * 👉 Нэмэх утга
     *
     * @return
     * 👉 Амжилттай нэмсэн бол true
     */
    boolean enqueue(Integer value);

    /**
     * Queue хоосон эсэхийг шалгана.
     *
     * @return
     * 👉 Хоосон бол true
     * 👉 Элемент байвал false
     */
    boolean isEmpty();

    /**
     * Queue-ийн эхний элементийг харна.
     * ⚠️ Гэхдээ устгахгүй!
     *
     * @return
     * 👉 Эхний элемент
     * 👉 Хоосон бол null
     */
    Integer peek();

    /**
     * Queue-д байгаа элементүүдийн тоог буцаана.
     *
     * @return
     * 👉 Элементийн тоо
     */
    int size();
}
