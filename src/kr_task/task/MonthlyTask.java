package kr_task.task;

import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String name, LocalDate date, TypeTask typeTask) {
        super(name, date, typeTask);
    }

    @Override
    public TimeTask getTimeTask() {
        return TimeTask.MONTHLY;
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfMonth()==this.getDate().getDayOfMonth() && this.getDate().getDayOfYear() <= date.getDayOfYear();
    }
}
