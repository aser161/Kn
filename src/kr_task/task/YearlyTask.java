package kr_task.task;

import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String name, LocalDate date, TypeTask typeTask) {
        super(name, date, typeTask);
    }

    @Override
    public TimeTask getTimeTask() {
        return TimeTask.YEARLY;
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfYear()==this.getDate().getDayOfYear() && this.getDate().getYear() <= date.getYear();
    }
}
