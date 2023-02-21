package kr_task.task;

import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String name, LocalDate date, TypeTask typeTask) {
        super(name, date, typeTask);
    }

    @Override
    public TimeTask getTimeTask() {
        return TimeTask.WEEKLY;
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return this.getDate().getDayOfYear() % 7 == date.getDayOfYear() % 7
                && this.getDate().getDayOfYear() <= date.getDayOfYear();
    }
}
