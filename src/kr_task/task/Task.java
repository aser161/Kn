package kr_task.task;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

    public static final LocalDate TODAY = LocalDate.now();
    public static final LocalDate TOMORROW = LocalDate.now().plusDays(1);
    private static int count = 1;

    public enum TypeTask {
        WORK("Работа") ,
        PERSONAL("Личное");

        private final String translate;

        TypeTask(String translate) {
            this.translate = translate;
        }

        public String getTranslate() {
            return translate;
        }

        @Override
        public String toString() {
            return getTranslate();
        }
    }

    public enum TimeTask {
        ONE("Один раз"),
        EVERY_DAY("Ежедневно"),
        EVERY_WEEK("Еженедельно"),
        EVERY_MONTH("Ежемесячно"),
        EVERY_YEAR("Ежегодно");

        private final String translate;

        TimeTask(String translate) {
            this.translate = translate;
        }

        public String getTranslate() {
            return translate;
        }

        @Override
        public String toString() {
            return getTranslate();
        }
    }

    private final String name;
    private final LocalDate date;
    private final TypeTask typeTask;
    private final TimeTask timeTask;
    private final int id;

    public Task(String name, LocalDate date, TypeTask typeTask, TimeTask timeTask) {
        this.name = name;
        this.date = date;
        this.typeTask = typeTask;
        this.timeTask = timeTask;
        this.id = count;
        count++;
    }

    public Task (String name, LocalDate date) {
        this(name,date,TypeTask.PERSONAL,TimeTask.ONE);
    }

    public LocalDate returnNextDate () {
        if (this.timeTask == TimeTask.ONE){
            return null;
        }
        LocalDate localDate = this.getDate().plusDays(1);
        for (int i = 0; i < 366; i++){
            if(TaskService.isTask(this, localDate)){
                return localDate;
            } else {
                localDate = localDate.plusDays(1);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public TimeTask getTimeTask() {
        return timeTask;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getName().equals(task.getName())
                && getDate().equals(task.getDate())
                && getTypeTask() == task.getTypeTask()
                && getTimeTask() == task.getTimeTask();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDate(), getTimeTask(), getTimeTask());
    }

    @Override
    public String toString() {
        return getName() + " " + getDate() + " порядковый номер: " + getId() + "; " + typeTask + ", " + timeTask;
    }
}
