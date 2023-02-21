package kr_task.task;

import java.time.LocalDate;

public class OneTimeTask extends Task{
    public OneTimeTask(String name, LocalDate date, TypeTask typeTask) {
        super(name, date, typeTask);
    }

    @Override
    public TimeTask getTimeTask() {
        return TimeTask.ONE;
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.equals(this.getDate());
    }
}
