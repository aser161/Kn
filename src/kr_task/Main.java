package kr_task;

import kr_task.task.*;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        TaskService.addTask(new OneTimeTask("Сдать экзамен", Task.TODAY, Task.TypeTask.PERSONAL));
        TaskService.addTask(new DailyTask("Сходить в школу", Task.TODAY, kr_task.task.Task.TypeTask.PERSONAL));
        TaskService.addTask(new DailyTask("Вовремя лечь спать", Task.TODAY, Task.TypeTask.PERSONAL));
        TaskService.addTask(new MonthlyTask("Оплатить налог", Task.TOMORROW, Task.TypeTask.WORK));
        TaskService.addTask(new WeeklyTask(
                "Сходить в магазин",
                LocalDate.of(2023, Month.FEBRUARY, 18),
                Task.TypeTask.PERSONAL));

        TaskService.remove(5);
        System.out.println(TaskService.returnNextDate(3));

        System.out.println("==========================");

        TaskService.printAllTask();

        System.out.println("==========================");

        LocalDate jostDate = LocalDate.of(2023, 2,22);
        TaskService.printDataTask(jostDate);

    }

}