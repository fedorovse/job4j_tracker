package ru.job4j.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

 /**
 * Управление задачами на предприятии через очередь с приоритетом
 * приоритет задается компаратором
 */
public class ScheduleTask {

    private PriorityQueue<Task> queue;

    public ScheduleTask(Comparator<Task> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    /**
     * @param task Добавить задачу в очередь
     */
    public void addTask(Task task) {
        this.queue.add(task);
    }

     /**
      * @return Прочитать текущую задачу без удаления из очереди
      */
    public Task readTask() {
        return this.queue.peek();
    }

     /**
      * @return Возвращает задачу из головы очереди с удалением её из очереди
      */
    public Task getTask() {
        return this.queue.poll();
    }
}
