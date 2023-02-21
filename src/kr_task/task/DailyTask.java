package kr_task.task;

import java.time.LocalDate;

public class DailyTask extends Task{
    public DailyTask(String name, LocalDate date, TypeTask typeTask) {
        super(name, date, typeTask);
    }

    @Override
    public TimeTask getTimeTask() {
        return TimeTask.DAILY;
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.equals(this.getDate())||date.isAfter(this.getDate());
    }
}
