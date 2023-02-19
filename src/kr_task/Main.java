package kr_task;

import kr_task.task.Task;
import kr_task.task.TaskService;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        TaskService.addTask(new Task("Сдать экзамен", Task.TODAY));
        TaskService.addTask(new Task("Сходить в школу", Task.TODAY, kr_task.task.Task.TypeTask.PERSONAL, Task.TimeTask.EVERY_DAY));
        TaskService.addTask(new Task("Вовремя лечь спать", Task.TODAY, Task.TypeTask.PERSONAL, Task.TimeTask.EVERY_DAY));
        TaskService.addTask(new Task("Оплатить налог", Task.TOMORROW, Task.TypeTask.WORK, Task.TimeTask.EVERY_MONTH));
        TaskService.addTask(new Task(
                "Сходить в магазин",
                LocalDate.of(2023, Month.FEBRUARY, 18),
                Task.TypeTask.PERSONAL,
                Task.TimeTask.EVERY_WEEK));

        TaskService.remove(5);
        System.out.println(TaskService.returnNextDate(3));

        System.out.println("========================");

        TaskService.printAllTask();
        System.out.println("========================");
        LocalDate jostDate = LocalDate.of(2023, 2,22);
        TaskService.printDataTask(jostDate);

    }

}